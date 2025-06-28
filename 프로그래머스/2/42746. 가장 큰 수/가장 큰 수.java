import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        
        // 사전식
        List<String> list = Arrays.stream(numbers)
            .boxed()
            .map(i -> String.valueOf(i))
            .collect(Collectors.toList());
        
        Collections.sort(list, (String o1, String o2) -> {
            return (o2 + o1).compareTo(o1 + o2);
        });
        
        for(int i=0;i<list.size();i++) {
            answer += list.get(i);
        }
        
        if(answer.charAt(0) == '0') {
            return "0";
        }
        
        return answer;
    }
}