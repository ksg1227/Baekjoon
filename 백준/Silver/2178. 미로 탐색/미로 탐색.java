import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
    단계별로 풀어보기
    그래프와 순회
    2667번 문제: 단지 번호 붙이기
*/

public class Main {

    static int[][] map;
    static boolean[][] visit;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static int N;
    static int M;

    static int count;

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();

            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        int result = bfs(N - 1, M - 1);

        System.out.println(result);

    }

    //index 0: x, 1 : y, 2 : depth
    static int bfs(int destX, int destY) {
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{0, 0, 1});
        visit[0][0] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            if (poll[0] == destX && poll[1] == destY) {
                return poll[2];
            }

            count = poll[2] + 1;

            for (int i = 0; i < 4; i++) {
                int nx = poll[0] + dx[i];
                int ny = poll[1] + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M)
                    continue;
                else {
                    if (map[nx][ny] == 1 && !visit[nx][ny]) {
                        visit[nx][ny] = true;
                        queue.add(new int[]{nx, ny, count});
                    }
                }
            }
        }

        return -1;

    }


    public static void main(String args[]) throws Exception {
        Main.solution();
    }
}

