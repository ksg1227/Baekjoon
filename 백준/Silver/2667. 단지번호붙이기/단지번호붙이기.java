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

    static ArrayList<Integer> result = new ArrayList<>();

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static int N;

    static int count = 1;


    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visit = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();

            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visit[i][j]) {
                    dfs(i, j);
                    result.add(count);
                    count = 1;
                }
            }
        }

        Collections.sort(result);

        sb.append(result.size()).append("\n");

        for (int num : result) {
            sb.append(num).append("\n");
        }

        System.out.println(sb);


    }

    static void dfs(int x, int y) {
        visit[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N)
                continue;
            else {
                if (map[nx][ny] == 1 && !visit[nx][ny]) {
                    count++;
                    dfs(nx, ny);
                }
            }

        }
    }


    public static void main(String args[]) throws Exception {
        Main.solution();
    }
}

