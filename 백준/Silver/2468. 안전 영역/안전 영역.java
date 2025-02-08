import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 스터디 5주차
 * 완전 탐색 - 브루트포스
 * 백준 2468번 : 안전 영역
 */

public class Main {

    // 부분 수열은 연속할 필요가 없나봄

    static int N;

    static int[][] map;

    static boolean[][] visited;

    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};

    static int maxCount = 0;

    // 1이면 다 안잠김 -> 1개
    // 100이면 다 잠김 -> 0개 -> 99까지만 봐도 될 듯

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i <= 100; i++) {

            clearVisited();

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (map[j][k] <= i) {
                        visited[j][k] = true;
                    }
                }
            }

            int count = 0;

            // 여기까지 최대 연산 횟수 = 10000번
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (!visited[j][k]) {
                        count++;
                        visited[j][k] = true;
                        dfs(j, k);
                    }
                }
            }

            maxCount = Math.max(count, maxCount);

        }

        System.out.println(maxCount);

    }

    static void dfs(int currentX, int currentY) {

        for(int i=0;i<4;i++) {
            int nextX = currentX + dx[i];
            int nextY = currentY + dy[i];

            if(nextX < N && nextX >=0 && nextY < N && nextY >= 0) {
                if(!visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    dfs(nextX, nextY);
                }
            }
        }
    }

    static void clearVisited() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                visited[i][j] = false;
            }
        }
    }


    public static void main(String[] args) throws IOException {
        solution();
    }

}








