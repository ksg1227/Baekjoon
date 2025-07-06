import java.util.*;

class Solution {

    boolean[] isUsed;
    Set<Integer> nums = new HashSet<>();
    
    public int solution(String numbers) {
        
        isUsed = new boolean[numbers.length()];
        
        for(int i=0;i<numbers.length();i++) {
            isUsed[i] = true;
            makeNum(numbers.length(), 1, numbers, String.valueOf(numbers.charAt(i)));
            isUsed[i] = false;
        }
        
        int answer = nums.size();
        
        return answer;
    }
    
    
    void makeNum(int length, int count, String numbers, String current) {
        
        System.out.println(current);
        
        int num = Integer.parseInt(current);
        
        if(isPrime(num)) {
            nums.add(num);
        }
        
        for(int i=0;i<length;i++) {
            if(isUsed[i] == false) {
                isUsed[i] = true;
                makeNum(length, count+1, numbers, current + numbers.charAt(i));
                isUsed[i] = false;
            }
        }
    }
    
    boolean isPrime(int num) {
        boolean flag = true;
        
        if(num == 0 || num == 1) {
            return false;
        }
        
        if(num == 2) {
            return true;
        }
        
        for(int i=2;i<num;i++) {
            if(num % i == 0) {
                return false;
            }
        }
        
        return true;
    }
    
    
}