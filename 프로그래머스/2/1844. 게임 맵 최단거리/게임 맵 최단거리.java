import java.util.*;

class Solution {
    int count = 0;
    boolean[][] visited;
    
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    
    int n;
    int m;
    
    public int solution(int[][] maps) {
        
        n = maps.length;
        m = maps[0].length;
        
        visited = new boolean[n][m];
        
        bfs(maps);
        
        if(count == 0) {
            return -1;
        } else {
            return count;
        }
        
    }
    
    void bfs(int[][] maps) {
        Queue<Node> queue = new LinkedList<>();
        
        queue.offer(new Node(0, 0, 1));
        visited[0][0] = true;
        
        while(!queue.isEmpty()) {
            Node currentNode = queue.poll();
            
            int currentX = currentNode.x;
            int currentY = currentNode.y;
            int currentCount = currentNode.count;
            
            if(currentX == n-1 && currentY == m-1) {
                count = currentCount;
                return;
            }
            
            for(int i=0;i<4;i++) {
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];
                
                if(nextX < n && nextX >= 0 && nextY < m && nextY >= 0 && !visited[nextX][nextY] && maps[nextX][nextY] == 1) {
                    visited[nextX][nextY] = true;
                    queue.offer(new Node(nextX, nextY, currentCount+1));
                }
            }
        }
    }
    
    class Node {
        int x;
        int y;
        int count;
        
        Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}