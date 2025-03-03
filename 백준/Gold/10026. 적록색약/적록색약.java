import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/*
    solved.ac
    class3
    10026번 문제 : 적록색약
 */

public class Main {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static char[][] map;

    static boolean[][] visited;

    static int N;

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            map[i] = line.toCharArray();
        }

        int normalCount = 0;
        int redGreenCount = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    normalCount++;
                    normalDfs(i, j, map[i][j]);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], false);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    redGreenCount++;
                    redGreenDfs(i, j, map[i][j]);
                }
            }
        }

        System.out.println(normalCount + " " + redGreenCount);

    }

    static void redGreenDfs(int x, int y, char color) {

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
                if (!visited[nextX][nextY]) {

                    if (color == 'B' && map[nextX][nextY] == 'B') {
                        redGreenDfs(nextX, nextY, color);
                    } else if (color != 'B' && map[nextX][nextY] != 'B') {
                        redGreenDfs(nextX, nextY, map[nextX][nextY]);
                    }
                }
            }
        }

    }

    static void normalDfs(int x, int y, char color) {

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
                if (!visited[nextX][nextY] && map[nextX][nextY] == color) {
                    normalDfs(nextX, nextY, color);
                }
            }
        }
    }


    public static void main(String[] args) throws Exception {
        Main.solution();
    }
}
