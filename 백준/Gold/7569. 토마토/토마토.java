import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
    단계별로 풀어보기
    그래프와 순회
    7576번 문제: 토마토
*/

public class Main {

    static int[][][] map;

    static int[] dx = {-1, 0, 1, 0, 0, 0};
    static int[] dy = {0, 1, 0, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    static int M;
    static int N;
    static int H;

    static Queue<int[]> queue = new LinkedList<>();

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[N][M][H];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    map[j][k][i] = Integer.parseInt(st.nextToken());
                }
            }
        }

        for(int i=0;i<H;i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (map[j][k][i] == 1) {
                        queue.add(new int[]{j, k, i, 0});
                    }
                }
            }
        }

        System.out.println(bfs());


    }

    static int bfs() {

        int result = 0;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            int tempX = poll[0];
            int tempY = poll[1];
            int tempZ = poll[2];
            int tempDepth = poll[3];

            for (int i = 0; i < 6; i++) {
                int nx = tempX + dx[i];
                int ny = tempY + dy[i];
                int nz = tempZ + dz[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M || nz < 0 || nz >= H) {
                    continue;
                } else {
                    if (map[nx][ny][nz] == 0) {
                        map[nx][ny][nz] = 1;
                        queue.add(new int[]{nx, ny, nz, tempDepth + 1});

                        result = Math.max(result, tempDepth + 1);
                    }
                }
            }
        }

        for(int i=0;i<H;i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (map[j][k][i] == 0) {
                        result = -1;
                    }
                }
            }
        }

        return result;
    }


    public static void main(String args[]) throws Exception {
        Main.solution();
    }
}

