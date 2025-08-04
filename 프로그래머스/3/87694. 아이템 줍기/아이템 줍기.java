import java.util.*;

class Solution {
    
    int[][] map = new int[103][103];
    
    boolean[][] visited = new boolean[103][103];
    
    // 위, 오른, 아래, 왼
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    
    // 어느 방향으로 이어졌는지도 추적해야함
    
    int answer = 0;
    
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        
        for(int i=0;i<rectangle.length;i++) {
            int leftBottomX = rectangle[i][0] * 2;
            int leftBottomY = rectangle[i][1] * 2;
            int rightTopX = rectangle[i][2] * 2;
            int rightTopY = rectangle[i][3] * 2;
            
            for(int j=leftBottomX;j<=rightTopX;j++) {
                for(int k=leftBottomY;k<=rightTopY;k++) {
                    if((j == leftBottomX || j == rightTopX || k == leftBottomY || k == rightTopY) && (map[j][k] != 2)) {
                        map[j][k] = 1;
                    } else {
                        map[j][k] = 2;
                    }
                }
            }
            
        }
        
        // 테두리만 남기기
        
        bfs(characterX*2, characterY*2, itemX*2, itemY*2);
        
        return answer;
    }
    
    void bfs(int startX, int startY, int itemX, int itemY) {
        Queue<Node> queue = new LinkedList<>();
        
        queue.offer(new Node(startX, startY, 0));
        
        visited[startX][startY] = true;
        
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            
            int currentX = node.x;
            int currentY = node.y;
            int count = node.count;
            
            if(currentX == itemX && currentY == itemY) {
                answer = count / 2;
                return;
            }
            
            for(int i=0;i<4;i++) {
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];
                
                if(nextX >= 2 && nextX <= 102 && nextY >= 2 && nextY <= 102 && !visited[nextX][nextY] && map[nextX][nextY] == 1) {
                    visited[nextX][nextY] = true;
                    queue.offer(new Node(nextX, nextY, count+1));
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