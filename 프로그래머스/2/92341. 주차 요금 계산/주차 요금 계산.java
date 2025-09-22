// 입차 후 출차 내역이 없다면 23:59에 출차된 것으로 간주

// 1000 => O(N^2) 이어도 시간 복잡도 안넘음

// IN 인 경우, 그 다음에 동일 차 번호에 대해 OUT 인 걸 찾으면 됨

import java.util.*;

class Solution {
    
    Map<String, Integer> totalFee = new TreeMap<>();
    
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        
        int baseTime = fees[0];
        int baseFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];
        
        for(int i=0;i<records.length;i++) {
            StringTokenizer st = new StringTokenizer(records[i]);
            
            int time = Integer.parseInt(st.nextToken().replace(":", ""));
            String carNumber = st.nextToken();
            String type = st.nextToken();
            
            boolean isOut = false;
            
            if(type.equals("IN")) {
                for(int j=i+1;j<records.length;j++) {
                    st = new StringTokenizer(records[j]);
                    
                    int endTime = Integer.parseInt(st.nextToken().replace(":", ""));  
                    String endCarNumber = st.nextToken();
                    String endType = st.nextToken();
                    
                    if(carNumber.equals(endCarNumber) && endType.equals("OUT")) {
                        int totalMinute = calculateTotalMinute(time, endTime);
                        
                        totalFee.put(carNumber, totalFee.getOrDefault(carNumber, 0) + totalMinute);
                        isOut = true;
                        break;
                    }
                }
                
                // 출차하지 않은 경우
                if(!isOut) {
                    int totalMinute = calculateTotalMinute(time, 2359);
                    totalFee.put(carNumber, totalFee.getOrDefault(carNumber, 0) + totalMinute);
                }
            }
        }
        
        List<Integer> list = new ArrayList<>();
        
        for(String key : totalFee.keySet()) {
            int totalMinute = totalFee.get(key);
            
            // 기본 시간을 초과해서 입차해있던 케이스
            if(totalMinute > fees[0]) {
                int price = baseFee;
                
                price += Math.ceil((totalMinute - baseTime) / (double) unitTime) * unitFee;
                
                list.add(price);
            } else {
                list.add(fees[1]);
            }
        }
        
        answer = list.stream()
            .mapToInt(x -> x)
            .toArray();
        
        return answer;
    }
    
    int calculateTotalMinute(int startTime, int endTime) {
        
        int startHour = startTime / 100;
        int startMinute = startTime % 100;
        
        int endHour = endTime / 100;
        int endMinute = endTime % 100;
        
        //00:10 ~ 01:05분
        
        int totalMinute = 0;
        
        if(endMinute < startMinute) {
            int plusHour = endHour - startHour - 1;
            int plusMinute = (60 - startMinute) + endMinute;
            
            totalMinute = plusHour * 60 + plusMinute;
        } else {
            totalMinute = (endHour - startHour) * 60 + (endMinute - startMinute);
        }
        
        return totalMinute;
        
    }
}