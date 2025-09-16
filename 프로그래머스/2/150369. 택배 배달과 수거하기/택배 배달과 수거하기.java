// 그냥 매번 제일 조금씩만 가면 됨

// 집에 존재하는 택배들을 확인하고, 각 집에 배달해야하는 택배들을 합쳤을 때, cap 보다 작거나 같은 집까지 채울정도만 가져가면 됨

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        int lastDeliveryHouse = findLastDeliveryHouse(deliveries);
        int lastPickupHouse = findLastPickupHouse(pickups);
        
        if(lastDeliveryHouse == 0 && deliveries[0] == 0 && lastPickupHouse == 0 && pickups[0] == 0) {
            return 0;
        }
        
        boolean noMoreDelivery = false;
        boolean noMorePickup = false;
        
        // 둘 다 true 가 아닐 때
        while(!noMoreDelivery || !noMorePickup) {
            
            int distance = Math.max(lastDeliveryHouse, lastPickupHouse);
            
            answer += (distance+1) * 2;
            
            int deliveryCount = cap;
            int pickupCount = cap;
            
            // 더 이상 실어갈 것도, 가져올 것도 없는 케이스 찾기
            
            // 트럭에 실어가야할 택배 수
            for(int i=lastDeliveryHouse;i>=0;i--) {
                if(deliveries[i] < deliveryCount) {
                    deliveryCount -= deliveries[i];
                    deliveries[i] = 0;
                    
                    if(i == 0) {
                        noMoreDelivery = true;
                        lastDeliveryHouse = 0;
                        break;
                    }
                } else if (deliveries[i] == deliveryCount) { 
                    deliveries[i] = 0;
                    deliveryCount = 0;
                    
                    if(i == 0) {
                        noMoreDelivery = true;
                        lastDeliveryHouse = 0;
                        break;
                    }
                } else {
                    deliveries[i] -= deliveryCount;
                    lastDeliveryHouse = i;
                    break;
                }
            }
            
            
            // 마지막 픽업해야할 지점에 도착했을 때는 항상 트럭은 비어있어야함
            for(int i=lastPickupHouse;i>=0;i--) {
                if(pickups[i] < pickupCount) {
                    pickupCount -= pickups[i];
                    pickups[i] = 0;
                    
                    if(i == 0) {
                        noMorePickup = true;
                        lastPickupHouse = 0;
                        break;
                    }
                } else if(pickups[i] == pickupCount) {
                    pickups[i] = 0;
                    pickupCount = 0;
                    
                    if(i == 0) {
                        noMorePickup = true;
                        lastPickupHouse = 0;
                        break;
                    }
                } else {
                    pickups[i] -= pickupCount;
                    lastPickupHouse = i;
                    break;
                }
            }
        }
        
        
        return answer;
    }
    
    int findLastDeliveryHouse(int[] deliveries) {
        for(int i=deliveries.length-1;i>=0;i--) {
            if(deliveries[i] != 0) {
                return i;
            }
        }
        
        return 0;
    }
    
    int findLastPickupHouse(int[] pickups) {
        for(int i=pickups.length-1;i>=0;i--) {
            if(pickups[i] != 0) {
                return i;
            }
        }
        
        return 0;
    }
}