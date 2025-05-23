import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        
        Queue<Integer> queue = new LinkedList<>();
        
        int total = progresses.length;
        
        int currentSize = 0;
        
        while(currentSize < total) {
            
            int count = 0;
            
            for(int i=0;i<total;i++) {
                progresses[i] += speeds[i];
            }
            
            // System.out.println(currentSize);
            
            for(int i=currentSize;i<total;i++) {
                if(progresses[i] >= 100) {
                    count++;
                    currentSize++;
                } else {
                    break;
                }
            }
            
            if(count > 0) {
                queue.offer(count); 
            }
        }
        
        answer = new int[queue.size()];
        
        for(int i=0;i<answer.length;i++) {
            answer[i] = queue.poll();
        }
        
        return answer;
    }
}