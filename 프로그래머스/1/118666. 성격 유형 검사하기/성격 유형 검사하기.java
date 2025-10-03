import java.util.*;

class Solution {
    
    int[][] score = new int[4][2];
    // [0][0] = R(라이언)
    // [0][1] = T(튜브)
    
    // [1][0] = C(콘)
    // [1][1] = F(프로도)
    
    // [2][0] = J(제이지)
    // [2][1] = M(무지)
    
    // [3][0] = A(어피치)
    // [3][1] = N(네오)
    
    // 각 문자가 몇 번 인덱스랑 연결되는지
    Map<String, Integer> map = new HashMap<>();
    
    // 각 인덱스가 어떤 문자랑 연결되는지
    Map<Integer, String> indexToChar = new HashMap<>();
    
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        
        map.put("R", 0);
        map.put("T", 1);
        map.put("C", 2);
        map.put("F", 3);
        map.put("J", 4);
        map.put("M", 5);
        map.put("A", 6);
        map.put("N", 7);
        
        indexToChar.put(0, "R");
        indexToChar.put(1, "T");
        indexToChar.put(2, "C");
        indexToChar.put(3, "F");
        indexToChar.put(4, "J");
        indexToChar.put(5, "M");
        indexToChar.put(6, "A");
        indexToChar.put(7, "N");
        
        
        for(int i=0;i<survey.length;i++) {
            String input = survey[i];
            
            String[] data = input.split("");
            
            int choice = choices[i];
            
            if(choice < 4) { // 비동의 & 첫번째 캐릭터가 점수 얻음
                String type = data[0];
                
                int index = map.get(type);
                
                score[index / 2][index % 2] += 4 - choice;
                
            } else if(choice >= 5) { // 동의 & 두번째 캐릭터가 점수 얻음
                String type = data[1];
                
                int index = map.get(type);
                
                score[index / 2][index % 2] += choice - 4;
            }
        }
        
        for(int i=0;i<4;i++) {
            int firstScore = score[i][0];
            int secondScore = score[i][1];
            
            if(firstScore >= secondScore) {
                String type = indexToChar.get(i * 2);
                
                answer += type;
            } else {
                String type = indexToChar.get(i * 2 + 1);
                
                answer += type;
            }
        }
    
        
        return answer;
    }
}