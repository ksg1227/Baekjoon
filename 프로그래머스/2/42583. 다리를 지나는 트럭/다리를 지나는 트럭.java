import java.util.*;

class Solution {
    // 한 트럭이 다리를 지나가는 데 bridge_length 초 만큼 걸림
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 1;
        
        Queue<Integer> waiting = new LinkedList<>();
        Queue<Integer> onBridge = new LinkedList<>();
        Queue<Integer> passed = new LinkedList<>();
        
        for(int i=0;i<truck_weights.length;i++) {
            waiting.offer(truck_weights[i]);
        }
        
        // 현재 다리 위에 가해지는 무게
        int totalWeight = 0;
        
        // 다리 위에 올라가있는 것 중 가장 앞에 있는 것의 index
        int firstIndex = 0;
        
        // 다리 위에 올라갔던 총 트럭의 개수
        int truckCount = 0;
        
        // 각 트럭이 다리 위에 올라간 지 몇 초가 지났는지 체크
        int[] time = new int[truck_weights.length];
        
        
        // 다 찰 때까지
        while(true) {
            
            // 다리를 다 건너는 경우
            if(time[firstIndex] > bridge_length) {
                int currentWeight = onBridge.poll();
                passed.offer(currentWeight);
                firstIndex++;
                totalWeight -= currentWeight;
            }
            
            if(passed.size() >= truck_weights.length) {
                break;
            }
            
            // 새로운 게 올라갈 수 있는지 체크
            if(!waiting.isEmpty()) {
                int currentWeight = waiting.peek();
                
                // 올라갈 수 있는 경우
                if(totalWeight + currentWeight <= weight) {
                    onBridge.offer(waiting.poll());
                    totalWeight += currentWeight;
                    truckCount++;
                    
                    // 새롭게 올라가는 것은 1초부터 시작
                    time[truckCount-1]++;
                }
            }
            
            
            answer++;
            
            for(int i=firstIndex;i<truckCount;i++) {
                time[i]++;
            }
            
            
        }
        
        return answer;
    }
    
    public void print(int[] arr, int size) {
        for(int i=0;i<size;i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
}