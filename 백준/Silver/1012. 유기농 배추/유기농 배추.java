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

            if (next_x >= 0 && next_y >= 0 && next_x < M && next_y < N) {
                if (map[next_x][next_y] == 1 && !visit[next_x][next_y]) {
                    dfs(next_x, next_y);
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
            map = new int[M][N];
            visit = new boolean[M][N];

            K = Integer.parseInt(st.nextToken());

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
            }

            for (int x = 0; x < M; x++) {
                for(int y = 0; y < N; y++) {
                    if(map[x][y] == 1 && !visit[x][y]) {
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
