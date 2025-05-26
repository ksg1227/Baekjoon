// 숫자가 클수록 우선순위가 높음
import java.util.*;

class Solution {
    
    List<Integer> list = new ArrayList<>();
    
    public int solution(int[] priorities, int location) {
        
        for(int i=0;i<priorities.length;i++) {
            list.add(priorities[i]);
        }
        
        int answer = 0;
        
        while(true) {
            
            int currentPriority = list.get(0);
            
            if(location == 0) {
                if(isExist(currentPriority)) {
                    list.remove(0);
                    list.add(currentPriority);
                    location = list.size()-1;
                } else{
                    answer++;
                    break;
                }
            } else{
                if(isExist(currentPriority)) {
                    list.remove(0);
                    location--;
                    list.add(currentPriority);
                } else{
                    list.remove(0);
                    location--;
                    answer++;
                }
            }
            
            
        }
        
        return answer;
    }
    
    boolean isExist(int priority) {
        for(int i=1;i<list.size();i++) {
            if(list.get(i) > priority) {
                return true;
            }
        }
        
        return false;
    }
}