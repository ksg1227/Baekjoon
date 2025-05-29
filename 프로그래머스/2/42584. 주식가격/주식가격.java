class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        for(int i=0;i<prices.length;i++) {
            int price = prices[i];
            
            boolean flag = false;
            
            for(int j=i+1;j<prices.length;j++) {
                if(price > prices[j]) {  // 가격이 떨어진 순간
                    answer[i] = j-i;
                    flag = true;
                    break;
                }
            }
            
            if(!flag) {
                answer[i] = prices.length - 1 - i;
            }
        }
        
        
        return answer;
    }
}