

// 나가는 게 2개 이상 존재하고 들어오는 것이 하나도 없는 정점을 찾으면 그것이 바로 시작 정점임
// 나가는 게 1개이고 들어오는 것이 하나도 없는 경우는 가능함. -> 막대 그래프의 시작 위치

import java.util.*;

class Solution {
    
    ArrayList<Integer>[] in;
    ArrayList<Integer>[] out;
    
    int max = Integer.MIN_VALUE;
    int start;
    
    boolean[] visited;
    
    int edge = 0;
    int vertex = 0;
    
    int[] result = new int[3];
    
    public int[] solution(int[][] edges) {
        
        for(int i=0;i<edges.length;i++) {
            int src = edges[i][0];
            int dest = edges[i][1];
            
            max = Math.max(max, Math.max(src, dest));
        }
            
        visited = new boolean[max+1];
        in = new ArrayList[max+1];
        out = new ArrayList[max+1];
        
    
        for(int j=1;j<=max;j++) {
            in[j] = new ArrayList<>();
            out[j] = new ArrayList<>();
        }
        
        for(int i=0;i<edges.length;i++) {
            int src = edges[i][0];
            int dest = edges[i][1];
            
            // 현재 정점으로 들어오는 것
            in[dest].add(src);
            
            // 현재 정점에서 나가는 것
            out[src].add(dest);
        }
        
        // 시작점 찾기
        for(int i=1;i<=max;i++) {
            if(in[i].size() == 0 && out[i].size() >= 2) {
                start = i;
                visited[start] = true;
                break;
            }
        }
        
        
        ArrayList<Integer> startOutEdges = out[start];
        
        for(int i=0;i<startOutEdges.size();i++) {
            
            edge = 0;
            vertex = 1;
            
            dfs(startOutEdges.get(i));
            
            if(edge == vertex) {
                result[0]++;
            } else if(edge == vertex-1) {
                result[1]++;
            } else {
                result[2]++;
            }
        }
        
        int[] answer = {start, result[0], result[1], result[2]};
        
        return answer;
    }
    
    void dfs(int current) {
        if(out[current].size() > 0) {
            
            ArrayList<Integer> outEdges = out[current];
            
            for(int i : outEdges) {
                
                edge++;
                
                if(!visited[i]) {
                    visited[i] = true;
                    vertex++;
                    dfs(i);
                }
                
            }
            
            
        }
    }
}