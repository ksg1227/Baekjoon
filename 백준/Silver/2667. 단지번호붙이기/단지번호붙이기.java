import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 스터디 1주차
 * bfs / dfs
 * 백준 2667번 : 단지 번호 붙이기
 */

public class Main {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static List<Integer> list = new ArrayList<>();
    static int count = 0;
    static int result = 0;

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    dfs(i, j);
                    count++;
                    list.add(result);
                    result = 0;
                }
            }
        }

        Collections.sort(list);

        sb.append(count).append("\n");

        for(int i=0;i<list.size();i++){
            sb.append(list.get(i)).append("\n");
        }

        System.out.println(sb);



    }

    static void dfs(int x, int y) {
        result++;
        visited[x][y] = true;

        for(int i=0;i<4;i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
                if(map[nextX][nextY] == 1 && !visited[nextX][nextY]) {
                    dfs(nextX, nextY);
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        solution();
    }
}
