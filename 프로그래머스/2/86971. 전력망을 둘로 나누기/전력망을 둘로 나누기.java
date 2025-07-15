class Solution {
    
    boolean[] visited;
    int num;
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        for(int i=0;i<wires.length;i++) {
            visited = new boolean[n+1];
            
            visited[wires[i][0]] = true;
            visited[wires[i][1]] = true;
            
            num = 1;
            
            dfs(i, wires[i][0], wires, wires.length);
            
            visited[wires[i][0]] = false;
            visited[wires[i][1]] = false;
            
            answer = Math.min(Math.abs(num - (n-num)), answer);
        }
        
        return answer;
    }
    
    void dfs(int cutWireNum, int currentNum, int[][] wires, int n) {
        
        for(int i=0;i<n;i++) {
            if(i != cutWireNum) {
                if(wires[i][0] == currentNum && !visited[wires[i][1]]) {
                    visited[wires[i][1]] = true;
                    num++;
                    dfs(cutWireNum, wires[i][1], wires, n);
                }
                   
                if(wires[i][1] == currentNum && !visited[wires[i][0]]) {
                    visited[wires[i][0]] = true;
                    num++;
                    dfs(cutWireNum, wires[i][0], wires, n);
                } 
                
            }
        }
        
    }
    
}