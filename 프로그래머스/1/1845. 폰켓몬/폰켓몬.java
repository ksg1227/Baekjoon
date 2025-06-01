import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        answer = Math.min(map.size(), nums.length / 2);
    
        // 종류가 N/2 보다 많으면 -> N/2 가 답
        
        // 종류가 N/2 보다 적으면 -> 그 종류가 답
        
        
        
        return answer;
    }
}