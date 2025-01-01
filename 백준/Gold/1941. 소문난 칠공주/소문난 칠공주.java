import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 스터디 1주차
 * bfs / dfs
 * 백준 1941번 : 소문난 칠공주
 */

public class Main {

    // 7번을 이동해서 S가 4개 이상이어야함

    static char[][] map = new char[5][5];
    static boolean[] visited;
    static int[] selected = new int[7];

    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    static int answer = 0;

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            String line = br.readLine();
            map[i] = line.toCharArray();
        }

        backTracking(0, 0, 0);

        System.out.println(answer);

    }

    public static void backTracking(int depth, int numY, int start) {
        if (numY >= 4) {
            return;
        }

        if (depth == 7) {
            visited = new boolean[7];  // 각 장소를 방문했는지 안했는지 여부 확인
            bfs();
            return;
        }

        for (int i = start; i < 25; i++) {
            selected[depth] = i;
            if (map[i / 5][i % 5] == 'Y') {
                backTracking(depth + 1, numY + 1, i + 1);
            } else {
                backTracking(depth + 1, numY, i + 1);
            }
        }
    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(selected[0]);
        visited[0] = true;

        int connect = 1;

        while (!queue.isEmpty()) {
            int idx = queue.poll();
            int x = idx / 5;
            int y = idx % 5;

            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];
                int nextIdx = nextX * 5 + nextY;

                if (nextX >= 0 && nextX < 5 && nextY >= 0 && nextY < 5) {
                    for (int j = 0; j < 7; j++) {
                        if(!visited[j] && selected[j] == nextIdx) {
                            queue.add(nextIdx);
                            visited[j] = true;
                            connect++;
                        }
                    }
                }
            }
        }

        if(connect == 7) {
            answer++;
        }

    }


    public static void main(String[] args) throws IOException {
        solution();
    }

}







