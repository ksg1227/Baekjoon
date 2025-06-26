import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        
        int[] answer = new int[2];
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for(int i=0;i<operations.length;i++) {
            StringTokenizer st = new StringTokenizer(operations[i]);
            
            String operation = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            
            if(operation.equals("I")) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            } else if(operation.equals("D")) {
                
                if(map.isEmpty()) {
                    continue;
                }
                
                if(num == 1) {
                    int maxNum = map.lastKey();
                    int maxNumFrequency = map.get(maxNum);
                    
                    if(maxNumFrequency == 1) {
                        map.remove(maxNum);
                    } else {
                        map.put(maxNum, maxNumFrequency-1);
                    }
                    
                } else {
                    int minNum = map.firstKey();
                    int minNumFrequency = map.get(minNum);
                    
                    if(minNumFrequency == 1) {
                        map.remove(minNum);
                    } else {
                        map.put(minNum, minNumFrequency-1);
                    }
                }
            }
        }
        
        if(map.isEmpty()) {
            answer[0] = 0;
            answer[1] = 0;
        } else {
            answer[0] = map.lastKey();
            answer[1] = map.firstKey();
        }
        
        
        
        return answer;
    }
}