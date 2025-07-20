import java.util.*;

class Solution {
    
    // 내 뒤에 나보다 더 큰 값이 나오는 애를 제거하면 됨
    
    public String solution(String number, int k) {
        String answer = "";
        
        Stack<Integer> stack = new Stack<>();
        
        int count = 0;
        
        for(char c : number.toCharArray()) {
            
            // 이전 숫자보다 현재 숫자가 더 크다면, 이전 꺼 날리기
            while(count < k && !stack.isEmpty() && stack.peek() < c - '0') {
                stack.pop();
                count++;
            }
            
            stack.push(c - '0');
        }
        
        while(count < k) {
            stack.pop();
            count++;
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        
        
        return sb.reverse().toString();
        
    }
    

}