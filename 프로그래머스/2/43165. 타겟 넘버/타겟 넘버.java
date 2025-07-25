class Solution {
    
    int answer = 0;
    
    public int solution(int[] numbers, int target) {
        // 현재 숫자를 더하거나 빼거나
        dfs(numbers, 0, 0, target);
        
        return answer;
    }
    
    void dfs(int[] numbers, int sum, int index, int target) {
        
        if(index == numbers.length) {
            if(sum == target) answer++;
            
            return;
        }
        
        // 더하는 경우
        dfs(numbers, sum + numbers[index], index+1, target);
        
        // 빼는 경우
        dfs(numbers, sum - numbers[index], index+1, target);
    }
}