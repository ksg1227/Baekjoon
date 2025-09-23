// bfs 고려 -> d, l, r, u  => dfs 로 바꾸자
// 아래 -> 왼 -> 오 -> 위

import java.io.*;
import java.util.*;

// 이동하는 총 거리가 k 여야한다.
// 같은 격자를 두 번 이상 방문해도 된다.
// 문자열이 사전 순으로 가장 빠른 경로 -> 문자열이 아무리 길어도, 알파벳이 작은 게 먼저임

// 최단 거리로 목적지에 도착했는데, k가 그보다 큰 경우에는 -> 왔다리 갔다리 해야함
// 만약 목적지에 도착했는데, (k - 목적지까지 도착하는 데 소요된 거리) % 2 == 1 이라면 impossible임
// (k - 목적지까지 도착하는 데 소요된 거리) % 2 == 0 이라면 가능하고, 만약 % 4 도 0 이라면 dlru, 아니라면 du 로 채우면 됨 

// 이동거리 2 -> dd, dl, dr, du, ld, ll, lr, lu, rd, rl, rr, ru, ud, ul, ur, uu

// 만약 이동 거리가 k+1 인 경우에 도달한다면, k 만큼 이동해서는 탈출할 수 없다는 의미이므로 실패 - impossible

// 이동거리가 k 까지 도달하지 못했는데 더 이상 이동하지 못해 이동이 끊겼다면 "impossible";

// 각 좌표까지 도달하는데 걸리는 최단 경로 추적

// 2칸 인경우 -> du 가 최선

// 4칸 인 경우 -> dduu 가 최선

// 6칸 인 경우 -> ddduuu 가 최선

class Solution {
    
    String[] direction = {"d", "l", "r", "u"};
    
    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, -1, 1, 0};
    
    String result = "";
    
    boolean isFound = false;
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        
        dfs(n, m, x-1, y-1, r-1, c-1, k, new Node(x-1, y-1, ""));
        
        result = result.equals("") ? "impossible" : result;

        return result;
    }
    
    // 이동 불가 케이스 제거
    // 1. 현재 위치 -> 목적지까지 거리가 k 보다 짧은 경우
    // 2. (k - 현재 위치 -> 목적지까지 거리) % 2 == 1 인 경우
    void dfs(int n, int m, int x, int y, int r, int c, int k, Node node) {
        
        if(isFound) {
            return;
        }
        
        String currentPath = node.path;
        int currentX = node.x;
        int currentY = node.y;
        
        if(currentX == r && currentY == c && currentPath.length() == k) {
            isFound = true;
            
            if(result.equals("")) {
                result = currentPath;
            } else {
                if(result.compareTo(currentPath) >= 0) {
                    result = currentPath;
                }
            }
            
            return;
        }
        
        // 앞으로 이동해야할 거리
        int remain = k - currentPath.length();
        
        // 현재 위치에서 도착지까지 거리
        int distance =  Math.abs(r - currentX) + Math.abs(c - currentY);
        
        // 불가 케이스
        if(remain < distance || (remain - distance) % 2 == 1) {
            return;
        }

        for(int i=0;i<4;i++) {
            String nextDirection = direction[i];

            int nextX = currentX + dx[i];
            int nextY = currentY + dy[i];

            if(nextX >= 0 && nextX < n && nextY >= 0 && nextY < m) {
                dfs(n, m, x, y, r, c, k, new Node(nextX, nextY, currentPath + nextDirection));
            }
        }
    
    }

    
    
    class Node {
        int x;
        int y;
        String path;
        
        Node(int x, int y, String path) {
            this.x = x;
            this.y = y;
            this.path = path;
        }
    }
}