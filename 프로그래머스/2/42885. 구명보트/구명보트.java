import java.util.*;

class Solution {
    
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        int[] peopleWeight = new int[241];
        
        for(int i : people) {
            peopleWeight[i]++;
        }
        
        // 무거운 사람부터 처리
        for (int i = 240; i >= 1; i--) {
            
            while (peopleWeight[i] > 0) {
                peopleWeight[i]--; // 가장 무거운 사람 태움

                // 같이 탈 수 있는 가장 가벼운 사람 탐색
                for (int j = 1; j <= limit - i; j++) {
                    if (peopleWeight[j] > 0) {
                        peopleWeight[j]--;
                        break;
                    }
                }

                answer++; // 보트 하나 사용
            }
        }
        
      
        return answer;
    }
}