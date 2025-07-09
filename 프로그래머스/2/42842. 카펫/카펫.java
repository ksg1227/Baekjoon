class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        // 10, 2
        
        // [4, 3] => 4 * 2 + 3 * 2 - 4 = 14 - 4 = 10
        
        // X * 2 + Y * 2 = brown + 4
        
        //
        
        for(int i=1;i<=5000;i++) {
            for(int j=1;j<=i;j++) {
                if(i * 2 + j * 2 == brown + 4) {
                    if(i * j - brown == yellow) {
                        answer[0] = i;
                        answer[1] = j;
                        break;
                    }
                }
            }
        }
        return answer;
    }
}