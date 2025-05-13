import java.io.*;
import java.util.*;

public class Main {

    // 시계 방향으로 돌리면 각각 어느 방향이 되는지
    // 가로 -> 세로
    // 세로 -> 가로

    // 진행 방향에 따라 위로 그려져야하는지 아래로 그려져야하는지
    // 진행 방향이 동쪽이라면 북쪽으로 선이 그려져야함
    // 진행 방향이 서쪽이라면 남쪽으로 선이 그려져야함


    // 진행 방향에 따라 오른쪽으로 그려져야하는지 왼쪽으로 그려져야하는
    // 진행 방향이 북쪽이라면 서쪽으로 선이 그려져야함
    // 진행 방향이 남쪽이라면 동쪽으로 선이 그려져야함

    // K 세대일 경우, 선이 2^K 개 만큼 존재함.
    // 1부터 2^K-1 까지 돌면서 선을 그리면 됨.
    // 무조건 가로, 세로가 번갈아가면서 나옴

    // 동 -> 북 -> 서 -> 남 -> 동 ...
    static int[] dy = {0, -1, 0, 1};
    static int[] dx = {1, 0, -1, 0};


    static int[] forCheckX = {0, -1, 0, -1};
    static int[] forCheckY = {0, 0, 1, 1};

    static int[][] board = new int[101][101];

    static int N;
    static int x;
    static int y;
    static int d;
    static int g;

    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());


            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());

            board[y][x] = 1;

            x = x + dx[d];
            y = y + dy[d];

            board[y][x] = 1;

            drawCurve();
        }


        for (int i = 0; i <= 100; i++) {
            for (int j = 0; j <= 100; j++) {
                if (isPartOfDragonCurve(i, j)) {
                    result++;
                }
            }
        }

        System.out.println(result);


    }

    static void drawCurve() {

        List<Integer> direction = new ArrayList<>();

        direction.add((d + 1) % 4); // 1 세대

        // 1 세대일 땐 뒤에서 1개
        // 2 세대일 땐 뒤에서 2개
        // 3 세대일 땐 뒤에서 4개
        for (int i = 1; i <= g; i++) {
            int size = direction.size();

            for (int j = size - 1; j >= 0; j--) {
                int nextDirection = direction.get(j);

                x += dx[nextDirection];
                y += dy[nextDirection];

                board[y][x] = 1;

                direction.add((nextDirection + 1) % 4);

            }

        }
    }

    static boolean isPartOfDragonCurve(int x, int y) {

        for (int i = 0; i < 4; i++) {
            int nextX = x + forCheckX[i];
            int nextY = y + forCheckY[i];

            if (nextX > 100 || nextX < 0 || nextY > 100 || nextY < 0) {
                return false;
            }

            if (board[nextX][nextY] == 0) {
                return false;
            }
        }

        return true;

    }

}

