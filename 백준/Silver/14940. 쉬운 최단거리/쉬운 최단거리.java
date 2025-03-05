import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
    solved.ac
    class3
    14940번 문제 : 쉬운 최단 거리
 */

public class Main {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int n;
    static int m;

    static int[][] map;
    static boolean[][] visited;

    static int startX; // 목적지 == 시작지로 둬도 무방
    static int startY;

    static Queue<Node> queue = new LinkedList<>();

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;

                if (num == 2) {
                    startX = i;
                    startY = j;
                }
            }
        }

        bfs();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    sb.append(-1).append(" ");
                } else{
                    sb.append(map[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);


    }

    static void bfs() {
        queue.add(new Node(startX, startY, 0));
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();


            map[node.x][node.y] = node.depth;


            for (int i = 0; i < 4; i++) {
                int nextX = node.x + dx[i];
                int nextY = node.y + dy[i];

                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m) {
                    if (map[nextX][nextY] == 1 && !visited[nextX][nextY]) { // 방문 안하고, 연결된 것들
                        visited[nextX][nextY] = true;
                        queue.add(new Node(nextX, nextY, node.depth + 1));
                    }
                }
            }
        }

    }

    static class Node {
        int x;
        int y;
        int depth;

        public Node(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }


    public static void main(String[] args) throws Exception {
        Main.solution();
    }
}
