import java.util.*;

class Solution {
    
    int[] parent;
    
    public int solution(int n, int[][] costs) {
        
        int answer = 0;
        
        parent = new int[n];
        
        Edge[] edges = new Edge[costs.length];
        
        for(int i=0;i<n;i++) {
            parent[i] = i;
        }
        
        for(int i=0;i<costs.length;i++) {
            edges[i] = new Edge(costs[i][0], costs[i][1], costs[i][2]);
        }
        
        Arrays.sort(edges);
        
        for(Edge edge : edges) {
            int src = edge.src;
            int dest = edge.dest;
            
            if(find(src) != find(dest)) {
                union(src, dest);
                answer += edge.cost;
            }
        }
        
        return answer;
        
    }
    
    int find(int a) {
        if(parent[a] == a) return a;
        else return parent[a] = find(parent[a]);
    }
    
    void union(int a, int b) {
        
        a = find(a);
        b = find(b);
        
        if(a != b) {
            parent[b] = a;
        }
        
    }
    
    class Edge implements Comparable<Edge> {
        int src;
        int dest;
        int cost;
        
        Edge(int src, int dest, int cost) {
            this.src = src;
            this.dest = dest;
            this.cost = cost;
        }
        
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }
    
    
}