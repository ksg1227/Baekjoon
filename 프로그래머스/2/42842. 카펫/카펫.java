class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        for(int i=1;i<=2049;i++) {
            int width = ((brown + 4) - (i * 2)) / 2;
            
            if((i * 2 + width * 2 == brown + 4) && (i*width - brown == yellow)) {
                answer[0] = width;
                answer[1] = i;
                break;
            }
        }
        
        return answer;
    }
}