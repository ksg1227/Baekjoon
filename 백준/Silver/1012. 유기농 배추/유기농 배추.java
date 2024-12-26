import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static int M;
    static int N;

    static int[][] map;
    static boolean[][] visited;

    // dfs -> 스택 아니면 재귀
    // 배추가 심어져있지만 아직 접근하지 않은 지점에 도착하면 count 1 증가
    // 해당 위치에서 접근 가능한 모든 배추의 위치까지 dfs로 탐색해나가며 보호가능 구역으로 설정
    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            int K = Integer.parseInt(st.nextToken());

            map = new int[M][N];
            visited = new boolean[M][N];

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());

                map[X][Y] = 1;
            }

            int count = 0;
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < N; k++) {
                    if (map[j][k] == 1 && !visited[j][k]) {
                        count += dfs(j, k);
                    }
                }
            }

            sb.append(count).append("\n");
        }

        System.out.println(sb);

    }

    public static int dfs(int x, int y) {

        if (map[x][y] == 1 && !visited[x][y]) {
            visited[x][y] = true;

            for (int i = 0; i < 4; i++) {
                int next_x = x + dx[i];
                int next_y = y + dy[i];

                if (next_x >= 0 && next_x < M && next_y >= 0 && next_y < N) {
                    if(!visited[next_x][next_y]) {
                        dfs(next_x, next_y);
                    }
                }
            }
        }

        return 1;
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
