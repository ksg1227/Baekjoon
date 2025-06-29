import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        
        // 최대 인용 횟수
        for(int h=citations[citations.length-1];h>=0;h--) {
            
            int count = 0;
            
            for(int j=citations.length-1;j>=0;j--) {
                if(citations[j] >= h) {
                    count++;
                    
                    if(count == h) {
                        break;
                    }
                }
            
            }
            
            if(count >= h) {
                answer = h;
                break;
            }
            
        }
        
        return answer;
    }
}