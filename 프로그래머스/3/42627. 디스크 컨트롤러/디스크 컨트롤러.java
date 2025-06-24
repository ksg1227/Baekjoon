import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        int time = 0;
        int count = 0;
        int sum = 0;
        int currentJobEndTime = 0;
        
        int[] endTime = new int[jobs.length];
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        while(true) {
            if(count == jobs.length) {
                break;
            }
            
            for(int i=0;i<jobs.length;i++) {
                if(jobs[i][0] == time) {
                    pq.add(new Node(i, jobs[i][0], jobs[i][1]));
                }
            }
            
            if(!pq.isEmpty() && time >= currentJobEndTime) {
                Node node = pq.poll();
                
                currentJobEndTime = time + node.totalTime;
                
                sum += currentJobEndTime - jobs[node.num][0];
                
                count++;
            }
            
            time++;
            
            
        }
        
        
        
        return sum / jobs.length;
    }
    
    class Node implements Comparable<Node> {
        int num;
        int requestTime;
        int totalTime;
        
        Node(int num, int requestTime, int totalTime) {
            this.num = num;
            this.requestTime = requestTime;
            this.totalTime = totalTime;
        }
        
        public int compareTo(Node o) {
            if(this.totalTime == o.totalTime) {
                if(this.requestTime == o.requestTime) {
                    return this.num - o.num;
                }else {
                    return this.requestTime - o.requestTime;
                }
            } else {
                return this.totalTime - o.totalTime;
            }
            
        }
    }
}