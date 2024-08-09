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

    static int[][] map;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int M;
    static int N;

    static int count = 0;

    static Queue<int[]> queue = new LinkedList<>();

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    queue.add(new int[]{i, j, 0});
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
            int tempDepth = poll[2];

            for (int i = 0; i < 4; i++) {
                int nx = tempX + dx[i];
                int ny = tempY + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                } else {
                    if (map[nx][ny] == 0) {
                        map[nx][ny] = 1;
                        queue.add(new int[]{nx, ny, tempDepth + 1});

                        result = Math.max(result, tempDepth + 1);
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 0){
                    result = -1;
                }
            }
        }
        
        return result;
    }


    public static void main(String args[]) throws Exception {
        Main.solution();
    }
}

