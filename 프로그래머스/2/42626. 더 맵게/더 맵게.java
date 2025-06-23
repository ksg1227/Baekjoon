import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int sco : scoville) {
            pq.add(sco);
        }
        
        while(true) {
            
            if(pq.peek() >= K) {
                break;
            }
            
            if(pq.size() == 1 && pq.peek() < K) {
                answer = -1;
                break;
            }
            
            int first = pq.poll();
            int second = pq.poll();
            
            pq.add(first + second * 2);
            
            answer++;
            
        }
        
        return answer;
    }
}