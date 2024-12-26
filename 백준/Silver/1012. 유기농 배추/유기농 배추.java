import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
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
//                        dfs(j, k);
//                        bfs(j, k);
                        dfs_stack(j, k);
                        count++;
                    }
                }
            }

            sb.append(count).append("\n");
        }

        System.out.println(sb);

    }


    // 재귀 활용 dfs
    public static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int next_x = x + dx[i];
            int next_y = y + dy[i];

            if (next_x >= 0 && next_x < M && next_y >= 0 && next_y < N) {
                if (map[next_x][next_y] == 1 && !visited[next_x][next_y]) {
                    dfs(next_x, next_y);
                }
            }
        }
    }

    // 스택 + 반복문 활용 dfs
    public static void dfs_stack(int x, int y) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{x, y});
        visited[x][y] = true;

        while(!stack.isEmpty()) {
            int[] data = stack.pop();
            int current_x = data[0];
            int current_y = data[1];

            for (int i = 0; i < 4; i++) {
                int next_x = current_x + dx[i];
                int next_y = current_y + dy[i];

                if(next_x >= 0 && next_x < M && next_y >= 0 && next_y < N) {
                    if(!visited[next_x][next_y] && map[next_x][next_y] == 1) {
                        visited[next_x][next_y] = true;
                        stack.push(new int[]{next_x, next_y});
                    }
                }
            }
        }
    }


    // 큐 + 반복문 활용 bfs
    public static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] data = queue.poll();
            int current_x = data[0];
            int current_y = data[1];

            for (int i = 0; i < 4; i++) {
                int next_x = current_x + dx[i];
                int next_y = current_y + dy[i];

                if(next_x >= 0 && next_x < M && next_y >= 0 && next_y < N) {
                    if(!visited[next_x][next_y] && map[next_x][next_y] == 1) {
                        visited[next_x][next_y] = true;
                        queue.add(new int[]{next_x, next_y});
                    }
                }
            }

        }
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
