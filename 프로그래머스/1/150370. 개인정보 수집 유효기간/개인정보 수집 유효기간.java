import java.util.*;

// 유효기간은 1 이상 100 이하 -> 유효기간 / 12 한 값을 년도에 더하고 나머지를 현재에 더하면 됨
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        String todayValue = today.replace(".", "");
        
        Map<String, Integer> termMap = new HashMap<>();
        
        for(int i=0;i<terms.length;i++) {
            StringTokenizer st = new StringTokenizer(terms[i]);
            
            String type = st.nextToken();
            int duration = Integer.parseInt(st.nextToken());
            
            termMap.put(type, duration);
        }
        
        // 그냥 걍 privacy 확인하고, 각 개인정보 수집 날짜 + 약관 더한 값이 현재 날짜보다 더 빠른지만 비교하면 됨
        List<Integer> list = new ArrayList<>();
        
        for(int i=0;i<privacies.length;i++) {
            StringTokenizer st = new StringTokenizer(privacies[i]);
            
            String date = st.nextToken();
            String type = st.nextToken();
            
            int duration = termMap.get(type);
            
            st = new StringTokenizer(date, ".");
            
            String year = st.nextToken();
            String month = st.nextToken();
            String day = st.nextToken();
            
            int plusYear = duration / 12;
            int plusMonth = duration % 12;
            
            int yearValue = Integer.parseInt(year);
            int monthValue = Integer.parseInt(month);
            
            // 여기가 문제임. 12월이 된다고 1년 추가가 아님
            if(monthValue + plusMonth > 12) {
                plusYear += 1;
            }
            
            int newYear = yearValue + plusYear;
            int newMonth = monthValue + plusMonth;
            
            if(monthValue + plusMonth > 12) {
                newMonth -= 12;
            } 
            
            String endDate = "";
            
            System.out.println("newYear : " + newYear);
            System.out.println("newMonth : " + newMonth);
                
            if(newMonth < 10) {
                endDate += newYear + "0" + newMonth + day;
            } else {
                endDate += newYear + (newMonth + day);
            }
            
            System.out.println(endDate);
            
            if(isExpired(todayValue, endDate)) {
                list.add(i+1);
            }
            
        }
        
        int[] answer = new int[list.size()];
        
        for(int i=0;i<list.size();i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    
    boolean isExpired(String todayValue, String endDate) {
        if(todayValue.compareTo(endDate) < 0) {
            return false;
        } else {
            return true;
        }
    }
}