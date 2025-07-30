import java.util.*;

class Solution {
    
    ArrayList<Integer>[] list;
    boolean[] visited;
    int count = 0;
    
    public int solution(int n, int[][] computers) {
        
        list = new ArrayList[n];
        
        visited = new boolean[n];
        
        for(int i=0;i<n;i++) {
            list[i] = new ArrayList<>();
        }
        
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                int current = i;
                int next = j;
                
                if(computers[i][j] == 1 && i != j) {
                    list[current].add(j);
                }
                
            }
        }
        
        for(int i=0;i<n;i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(i);
                count++;
            }
        }
        
        return count;
    }
    
    void dfs(int start) {
        
        for(int i=0;i<list[start].size();i++) {
            int connect = list[start].get(i);
            
            if(!visited[connect]) {
                visited[connect] = true;
                dfs(connect);
            }
            
        }
        
    }
}