// dfs
// 방문하지 않았던 것들을 추적해주어야함

import java.util.*;

class Solution {
    
    ArrayList<Integer>[] tree;
    int[] INFO;
    
    int answer = Integer.MIN_VALUE;
    
    public int solution(int[] info, int[][] edges) {
        INFO = info;
        
        tree = new ArrayList[info.length];
        for(int i=0;i<info.length;i++) {
            tree[i] = new ArrayList<>();
        }
        
        for(int[] edge : edges) {
            int parent = edge[0];
            int child = edge[1];
            
            tree[parent].add(child);
        }
        
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        
        dfs(1, 0, visited);
        
        return answer;
    }
    
    void dfs(int sheepCount, int wolfCount, Set<Integer> visited) {
        if(sheepCount <= wolfCount) return;
        
        answer = Math.max(answer, sheepCount);
        
        // 방문한 것들의 자식 중 방문하지 않은 녀석이 있다면 타고 들어감
        for(int current : visited) {
            // 방문했던 것들의 자식
            for(int i=0;i<tree[current].size();i++) {
                
                // 방문한 적이 없다면
                if(!visited.contains(tree[current].get(i))) {
                    
                    Set new_visited = new HashSet(visited);
                    new_visited.add(tree[current].get(i));
                    
                    if(INFO[tree[current].get(i)] == 0) {
                        dfs(sheepCount + 1, wolfCount, new_visited);
                    } else {
                        dfs(sheepCount, wolfCount + 1, new_visited);
                    }
                }
            }
        }
        
    }
    
}