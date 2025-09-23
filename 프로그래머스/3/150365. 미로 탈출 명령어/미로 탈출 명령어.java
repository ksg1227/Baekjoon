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

    int[] dx = {1, 0, 0, -1};          // d, l, r, u
    int[] dy = {0, -1, 1, 0};
    char[] dir = {'d', 'l', 'r', 'u'};

    int n, m, r, c, k;

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        this.n = n;
        this.m = m;
        this.r = r;
        this.c = c;
        this.k = k;

        StringBuilder sb = new StringBuilder();

        return dfs(x, y, sb) ? sb.toString() : "impossible";
    }

    // DFS로 사전순 경로를 탐색하며 유효한 경로를 찾으면 true 반환
    public boolean dfs(int x, int y, StringBuilder sb) {
        if (sb.length() == k) {
            return x == r && y == c;
        }

        int remain = k - sb.length();
        int distance = Math.abs(x - r) + Math.abs(y - c);

        // 가지치기: 남은 거리보다 많이 이동해야 하거나, 도달 가능성이 없는 경우
        if (remain < distance || (remain - distance) % 2 != 0) return false;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 1 || nx > n || ny < 1 || ny > m) continue;

            sb.append(dir[i]);
            if (dfs(nx, ny, sb)) return true;
            sb.deleteCharAt(sb.length() - 1);  // 백트래킹
        }

        return false;
    }
}