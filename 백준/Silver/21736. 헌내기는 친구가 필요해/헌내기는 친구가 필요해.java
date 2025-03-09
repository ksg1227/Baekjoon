import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
    solved.ac
    class3
    21736번 문제 : 헌내기는 친구가 필요해
 */

public class Main {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static char[][] map;
    static boolean[][] visited;

    static int N;
    static int M;

    static int startX;
    static int startY;

    static int count = 0;

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                char info = line.charAt(j);
                if (info == 'I') {
                    startX = i;
                    startY = j;
                }
                map[i][j] = info;
            }
        }

        dfs(startX, startY);

        if(count == 0) {
            System.out.println("TT");
        } else{
            System.out.println(count);
        }


    }

    static void dfs(int currentX, int currentY) {

        visited[currentX][currentY] = true;
        if (map[currentX][currentY] == 'P') {
            count++;
        }

        for (int i = 0; i < 4; i++) {
            int nextX = currentX + dx[i];
            int nextY = currentY + dy[i];

            if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M) {
                if (!visited[nextX][nextY] && map[nextX][nextY] != 'X') {
                    dfs(nextX, nextY);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Main.solution();
    }
}
