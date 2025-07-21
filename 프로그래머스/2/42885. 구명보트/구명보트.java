import java.util.*;

class Solution {
    
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        int rescueCount = 0;
        
        int[] peopleWeight = new int[241];
        
        for(int i : people) {
            peopleWeight[i]++;
        }
        
        while(rescueCount < people.length) {
            
            // 보트에 태울 무게 => 항상 가장 몸무게가 많이 나가는 사람부터
            int currentWeight = 0;
            
            for(int i=limit;i>=1;i--) {
                if(peopleWeight[i] >= 1) {
                    peopleWeight[i]--;
                    currentWeight = i;
                    rescueCount++;
                    break;
                }
            }
            
                
            // i = 더 태울 사람의 몸무게
            for(int i=1;i<=limit - currentWeight;i++) {
                if(peopleWeight[i] >= 1 && currentWeight + i <= limit) {
                    currentWeight += i;
                    peopleWeight[i]--;
                    rescueCount++;

                    break;
                }
            }
            
            answer++;
            
        }
        
      
        return answer;
    }
}