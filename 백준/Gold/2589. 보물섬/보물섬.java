import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 스터디 5주차
 * 완전 탐색 - 브루트포스
 * 백준 2589번 : 보물섬
 */

public class Main {

    // 멀리 돌아가지 않는다 - 이걸 어떻게 판단할까?

    // 끝까지 다 본경우 - depth 를 체크
    // 그 중 depth 가 최대가 되는 시작 좌표와 끝 좌표가 정답임.
    // 근데 그 시작 좌표에서 끝 좌표까지 도달하는 경우의 수가 여러개라면? 그 중에서는 최소여야함
    // 특정점을 시작점으로 했을 때, 특정 도착점까지 걸리는 시간. 만약 특정 도착점까지 걸리는 시간이 이미 값이 차있으면, 둘 중에 더 작은 값으로 설정

    // bfs 를 돌렸을 때, 종료되는 지점
    // 각 점에서 bfs를 돌렸을 때 탐색이 종료되는 시점에 깊이(시간) 의 최대

    static int H;
    static int W;

    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    static char[][] map;
    static boolean[][] visited;

    static int result = Integer.MIN_VALUE;

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        map = new char[H][W];
        visited = new boolean[H][W];

        for (int i = 0; i < H; i++) {
            String input = br.readLine();
            for (int j = 0; j < W; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (map[i][j] == 'L') {
                    clearVisited();
                    bfs(i, j);
                }
            }
        }

        System.out.println(result);

    }

    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{x, y, 0});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] data = queue.poll();
            int currentX = data[0];
            int currentY = data[1];
            int depth = data[2];

            result = Math.max(result, depth);

            for (int i = 0; i < 4; i++) {
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];

                if (nextX >= 0 && nextX < H && nextY >= 0 && nextY < W) {
                    if (!visited[nextX][nextY] && map[nextX][nextY] == 'L') {
                        visited[nextX][nextY] = true;
                        queue.add(new int[]{nextX, nextY, depth + 1});
                    }
                }
            }
        }
    }

    static void clearVisited() {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                visited[i][j] = false;
            }
        }
    }


    public static void main(String[] args) throws IOException {
        solution();
    }

}








