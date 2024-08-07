import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
    단계별로 풀어보기
    그래프와 순회
    7562번 문제: 나이트의 이동
*/

public class Main {

    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

    static int[][] map;
    static boolean[][] visited;

    static int l;
    static int startX, startY;
    static int destX, destY;

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {


            for (int j = 0; j < 3; j++) {

                if (j == 0) {
                    l = Integer.parseInt(br.readLine());

                    map = new int[l][l];
                    visited = new boolean[l][l];
                } else if (j == 1) {
                    st = new StringTokenizer(br.readLine());
                    startX = Integer.parseInt(st.nextToken());
                    startY = Integer.parseInt(st.nextToken());
                } else {
                    st = new StringTokenizer(br.readLine());
                    destX = Integer.parseInt(st.nextToken());
                    destY = Integer.parseInt(st.nextToken());
                }

            }

            sb.append(bfs()).append("\n");

        }

        System.out.println(sb);

    }

    //index 0 : x, 1 : y, 2 : depth
    static int bfs() {
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{startX, startY, 0});

        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            int tempX = poll[0];
            int tempY = poll[1];
            int depth = poll[2];

            if (tempX == destX && tempY == destY) {
                return depth;
            }

            for (int i = 0; i < 8; i++) {
                int nx = tempX + dx[i];
                int ny = tempY + dy[i];

                if(nx < 0 || nx >= l || ny < 0 || ny >= l){
                    continue;
                }

                if(!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, depth + 1});
                }
            }
        }

        return -1;

    }


    public static void main(String args[]) throws Exception {
        Main.solution();
    }
}

