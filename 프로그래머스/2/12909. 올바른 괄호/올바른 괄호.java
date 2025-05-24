import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            
            if(c == '(') {
                stack.push(1);
            } else {
                if(stack.isEmpty()) {
                    answer = false;
                    break;
                } 
                
                stack.pop();
            }
        }

        if(answer) {
            if(!stack.isEmpty()) {
                answer = false;
            }
        }

        return answer;
    }
}