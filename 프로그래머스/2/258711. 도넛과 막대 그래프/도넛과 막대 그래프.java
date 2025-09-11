
// 8자 -> 만약 특정 정점과 연결됐는데, 해당 정점이 들어오는 것도 2개, 나가는 것도 2개라면 그 정점과 연결된 것들은 전부 8자 그래프임
// 만약 나가는 것도 하나, 들어오는 것도 하나라면 도넛과 헷갈릴 수 있지만, 결국엔 순회를 돌며 다음 이동 경로를 찾을 때, 연결된 점이 4개라면 바로 아 얘는 도넛이구나 판단하면 됨. 어차피 항상 이 들어오는 것 + 나가는 것이 4개인 정점은 지나게 되어있음

// 막대 -> 아예 나가는 것도, 들어오는 것도 없는 정점이 존재함 -> 이런 경우 막대임
// 더 이상 진행할 수 없는 곳이 

// 도넛 -> 자기 자신으로 들어오는 정점이 있는 케이스가 존재함 -> 이 경우 도넛임
// 어느점과 연결되든 시작 정점과 연결된 지점으로 다시 돌아옴

// 나가는 게 2개 이상 존재하고 들어오는 것이 하나도 없는 정점을 찾으면 그것이 바로 시작 정점임
// 나가는 게 1개이고 들어오는 것이 하나도 없는 경우는 가능함. -> 막대 그래프의 시작 위치

import java.util.*;

class Solution {
    
    ArrayList<Integer>[] in;
    ArrayList<Integer>[] out;
    
    int max = Integer.MIN_VALUE;
    int start;
    
    boolean[] visited;
    
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
        
        for(int i=1;i<=max;i++) {
            in[i] = new ArrayList<>();
            out[i] = new ArrayList<>();
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
            
            visited[startOutEdges.get(i)] = true;
            result[guessGraph(startOutEdges.get(i))]++;
        }
        
        int[] answer = {start, result[0], result[1], result[2]};
        
        return answer;
    }
    
    int guessGraph(int start) {
        
        if(out[start].size() == 0) {
            return 1;
        }
        
        ArrayList<Integer> outEdges = out[start];
        
        int type = 0;
        
        for(int i=0;i<outEdges.size();i++) {
            
            // 나가는 간선이 2개 이상인 정점이 존재하면 8자임
            if(outEdges.size() >= 2) {
                type = 2;
                break;
            }
            
            int nextVertex = outEdges.get(i);
            
            if(visited[nextVertex]) {
                type = 0;
                break;
            }
            
            visited[nextVertex] = true;
            
            if(out[nextVertex].size() == 0) {
                type = 1;
                break;
            }
            
            outEdges = out[nextVertex];
            i--;
        }
        
        return type;
        
    }
}