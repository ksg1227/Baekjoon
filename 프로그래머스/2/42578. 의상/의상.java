import java.io.*;
import java.util.*;

class Solution {
    
    public int solution(String[][] clothes) {
        int answer = 1;
        
        Map<String, Integer> map = new HashMap<>();
        
        for(int i=0;i<clothes.length;i++) {
            String cloth = clothes[i][0];
            String type = clothes[i][1];
            
            map.put(type, map.getOrDefault(type, 0) + 1);
        }
        
        // 입지 않는 경우 고려
        for(String key : map.keySet()) {
            answer *= (map.get(key) + 1);
        }
        
        return answer-1;
    }
}