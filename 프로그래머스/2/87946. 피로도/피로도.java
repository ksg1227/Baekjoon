class Solution {
    
    boolean[] visited;
    
    int answer = -1;
    
    public int solution(int k, int[][] dungeons) {
        
        int length = dungeons.length;
        visited = new boolean[length];
        
        explore(dungeons, k, 0, length);
        
        return answer;
    }
    
    void explore(int[][] dungeons, int currentK, int count, int length) {
        
        answer = Math.max(answer, count);
        
        // 더 이상 탐색이 불가능할 때 종료
        if(cantExplore(dungeons, currentK, length)) {
            return;
        }
        
        for(int i=0;i<length;i++) {
            if(!visited[i]) {
                // 탐험 하는 경우
                if(currentK >= dungeons[i][0]) {
                    
                    visited[i] = true;
                    explore(dungeons, currentK - dungeons[i][1], count+1, length);
                    visited[i] = false;
                }
            }
        }
        
    }
    
    boolean cantExplore(int[][] dungeons, int currentK, int length) {
        
        for(int i=0;i<length;i++) {
            if(!visited[i] && currentK >= dungeons[i][0]) {
                return false;
            }
        }
        
        return true;
    }
}