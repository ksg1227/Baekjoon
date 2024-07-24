import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * solved.ac
 * class 3
 * 1012번 문제 : 유기농 배추
 * DFS, BFS 문제라 공부 필요!!!!!
 */

public class Main {

    static int M;
    static int N;
    static int K;
    static int map[][];   //전체 map
    static int[] dx = {0, 0, -1, 1};  //x축 이동 반경
    static int[] dy = {1, -1, 0, 0};  //y축 이동 반경
    static boolean[][] visit;   //이미 방문했는지 체크하는 배열
    static int count;

    public static void dfs(int x, int y) {
        visit[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int next_x = x + dx[i];
            int next_y = y + dy[i];


            if (map[next_x][next_y] == 1 && !visit[next_x][next_y]) {
                dfs(next_x, next_y);
            }

        }
    }

    public static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        while (!queue.isEmpty()) {
            x = queue.peek()[0];
            y = queue.peek()[1];
            visit[x][y] = true;
            queue.poll();

            for (int i = 0; i < 4; i++) {
                int next_x = x + dx[i];
                int next_y = y + dy[i];

                if (map[next_x][next_y] == 1 && !visit[next_x][next_y]) {
                    queue.add(new int[]{next_x, next_y});
                    visit[next_x][next_y] = true;
                }

            }
        }
    }

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            count = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            map = new int[M + 2][N + 2];
            visit = new boolean[M + 2][N + 2];

            K = Integer.parseInt(st.nextToken());

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[x + 1][y + 1] = 1;
            }

            for (int x = 1; x < M + 1; x++) {
                for (int y = 1; y < N + 1; y++) {
                    if (map[x][y] == 1 && !visit[x][y]) {
                        dfs(x, y);
                        count++;
                    }
                }
            }

            sb.append(count).append("\n");
        }

        System.out.println(sb);


    }

    public static void main(String[] args) throws Exception {
        Main.solution();
    }
}
