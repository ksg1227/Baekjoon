import java.io.*;
import java.util.*;

public class Main {

    // 0이면 청소되지 않은 빈 칸
    // 1이면 벽
    // 2이면 청소된 빈 칸

    // 주변 4칸이 전부 다 청소된 상태라면
    //

    // case 1 - 현재 칸이 청소되지 않은 경우, 현재 칸을 청소한다.
    // case 2 - 현재 칸은 청소되었고, 주변 4칸중 청소되지 않은 빈 칸이 없는 경우
    // 1. 바라보는 방향을 유지한 채로 한 칸 후진할 수 있으면 한 칸 후진하고 case 1로 돌아감
    // 2. 바라보는 방향의 뒤쪽 칸이 벽이라 후진이 불가할 경우 정지함
    // case 3 - 현재 칸은 청소되었고, 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우
    // 1. 반시계 방향으로 90도 회전한다.
    // 2. 바라보는 방향을 기준으로 앞 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진한다.
    // 3. case 1로 돌아간다.

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int N;
    static int M;

    static int[][] map;

    static int r;
    static int c;

    // 0 - 북
    // 1 - 동
    // 2 - 남
    // 3 - 서

    // + 1 % 4 하면 됨

    static int direction;

    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        direction = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 0 : 청소 안됨
        // 1 : 벽
        // 2 : 청소 됨
        while (true) {

            if (map[r][c] == 0) {
                map[r][c] = 2;
                count++;
            }

            // 청소되지 않은 빈 칸이 없는 경우
            if (allClean(r, c)) {
                if (direction == 0) { // 북
                    if (map[r + 1][c] != 1) { // 뒤가 벽이 아닌 경우
                        r += 1;
                    } else { // 뒤가 벽인 경우
                        break;
                    }
                } else if (direction == 1) { // 동
                    if (map[r][c - 1] != 1) { // 뒤가 벽이 아닌 경우
                        c -= 1;
                    } else { // 뒤가 벽인 경우
                        break;
                    }
                } else if (direction == 2) { // 남
                    if (map[r - 1][c] != 1) { // 뒤가 벽이 아닌 경우
                        r -= 1;
                        continue;
                    } else { // 뒤가 벽인 경우
                        break;
                    }
                } else { // 서
                    if (map[r][c + 1] != 1) { // 뒤가 벽이 아닌 경우
                        c += 1;
                        continue;
                    } else { // 뒤가 벽인 경우
                        break;
                    }
                }
            } else {  // 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우

                // 반시계로 돌아야함
                if (direction == 0) {
                    direction = 3;
                } else {
                    direction--;
                }

                if (direction == 0) {
                    if (map[r - 1][c] == 0) {
                        r -= 1;
                    }
                } else if (direction == 1) {
                    if (map[r][c + 1] == 0) {
                        c += 1;
                    }
                } else if (direction == 2) {
                    if (map[r + 1][c] == 0) {
                        r += 1;
                    }
                } else {
                    if (map[r][c - 1] == 0) {
                        c -= 1;
                    }
                }
            }

        }

        System.out.println(count);

    }

    static boolean allClean(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX >= N || nextX < 0 || nextY >= M || nextY < 0) {
                continue;
            }

            // 청소되지 않은 빈 칸이 있는 경우
            if (map[nextX][nextY] == 0) {
                return false;
            }
        }

        // 청소되지 않은 빈 칸이 없는 경우
        return true;
    }
}
