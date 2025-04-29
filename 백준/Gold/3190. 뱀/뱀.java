import java.io.*;
import java.util.*;

/**
 * 3190번 - 뱀
 */
public class Main {

    static Deque<Position> snake = new ArrayDeque<>();

    static int N;
    static int K;
    static int L;

    // true 면 사과 존재
    // false 면 사과 없음
    static boolean[][] board;

    static boolean[][] visited;

    static Map<Integer, String> turnInfo = new HashMap<>();

    static int time = 0;

    // 위로 가다가 D 를 만나면 오른쪽, L을 만나면 왼쪽
    // 오른쪽으로 가다가 D를 만나면 아래쪽, L을 만나면 위쪽
    // 아래쪽으로 가다가 D 를 만나면 왼쪽, L을 만나면 오른쪽
    // 왼쪽으로 가다가 D를 만나면 위쪽, L을 만나면 아래쪽
    static String direction = "R"; // R, L, B, T


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        board = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];

        snake.offer(new Position(1, 1));

        visited[1][1] = true;

        K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int appleX = Integer.parseInt(st.nextToken());
            int appleY = Integer.parseInt(st.nextToken());

            board[appleX][appleY] = true;
        }

        L = Integer.parseInt(br.readLine());

        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());

            int time = Integer.parseInt(st.nextToken());
            String direction = st.nextToken();

            turnInfo.put(time, direction);
        }

        game();

        System.out.println(time);


    }

    // X초가 끝난 뒤에 방향 전환임. 즉 이동 후 방향 전환
    static void game() {
        while (true) {
            Position head = snake.peekLast();
            Position tail = snake.peekFirst();

            time++;
            if (direction.equals("R")) {
                int nextX = head.x;
                int nextY = head.y + 1;

                // 벽에 닿으면 게임 종료
                if (nextX >= N + 1 || nextX < 1 || nextY >= N + 1 || nextY < 1) {
                    return;
                }

                // 해당 위치에 몸통이 있으면 게임 종료
                if (visited[nextX][nextY]) {
                    return;
                }

                // 여기서부턴 이동 성공
                visited[nextX][nextY] = true;

                // head 삽입
                snake.offerLast(new Position(nextX, nextY));

                // 사과가 있으면 꼬리 그대로, 없으면 꼬리 줄이기
                if (board[nextX][nextY]) {
                    board[nextX][nextY] = false;
                } else {
                    visited[tail.x][tail.y] = false;
                    snake.pollFirst();
                }

                if (turnInfo.containsKey(time)) {
                    String info = turnInfo.get(time);

                    if (info.equals("D")) {
                        direction = "B";
                    } else { // L 이라면
                        direction = "T";
                    }
                }

            } else if (direction.equals("B")) {
                int nextX = head.x + 1;
                int nextY = head.y;

                // 벽에 닿으면 게임 종료
                if (nextX >= N + 1 || nextX < 1 || nextY >= N + 1 || nextY < 1) {
                    return;
                }

                // 해당 위치에 몸통이 있으면 게임 종료
                if (visited[nextX][nextY]) {
                    return;
                }

                // 여기서부턴 이동 성공
                visited[nextX][nextY] = true;

                // head 삽입
                snake.offerLast(new Position(nextX, nextY));

                // 사과가 있으면 꼬리 그대로, 없으면 꼬리 줄이기
                if (board[nextX][nextY]) {
                    board[nextX][nextY] = false;
                } else {
                    visited[tail.x][tail.y] = false;
                    snake.pollFirst();
                }

                if (turnInfo.containsKey(time)) {
                    String info = turnInfo.get(time);

                    if (info.equals("D")) {
                        direction = "L";
                    } else { // L 이라면
                        direction = "R";
                    }
                }
            } else if (direction.equals("L")) {
                int nextX = head.x;
                int nextY = head.y - 1;

                // 벽에 닿으면 게임 종료
                if (nextX >= N + 1 || nextX < 1 || nextY >= N + 1 || nextY < 1) {
                    return;
                }

                // 해당 위치에 몸통이 있으면 게임 종료
                if (visited[nextX][nextY]) {
                    return;
                }

                // 여기서부턴 이동 성공
                visited[nextX][nextY] = true;

                // head 삽입
                snake.offerLast(new Position(nextX, nextY));

                // 사과가 있으면 꼬리 그대로, 없으면 꼬리 줄이기
                if (board[nextX][nextY]) {
                    board[nextX][nextY] = false;
                } else {
                    visited[tail.x][tail.y] = false;
                    snake.pollFirst();
                }

                if (turnInfo.containsKey(time)) {
                    String info = turnInfo.get(time);

                    if (info.equals("D")) {
                        direction = "T";
                    } else { // L 이라면
                        direction = "B";
                    }
                }
            } else {
                int nextX = head.x - 1;
                int nextY = head.y;

                // 벽에 닿으면 게임 종료
                if (nextX >= N + 1 || nextX < 1 || nextY >= N + 1 || nextY < 1) {
                    return;
                }

                // 해당 위치에 몸통이 있으면 게임 종료
                if (visited[nextX][nextY]) {
                    return;
                }

                // 여기서부턴 이동 성공
                visited[nextX][nextY] = true;

                // head 삽입
                snake.offerLast(new Position(nextX, nextY));

                // 사과가 있으면 꼬리 그대로, 없으면 꼬리 줄이기
                if (board[nextX][nextY]) {
                    board[nextX][nextY] = false;
                } else {
                    visited[tail.x][tail.y] = false;
                    snake.pollFirst();
                }

                if (turnInfo.containsKey(time)) {
                    String info = turnInfo.get(time);

                    if (info.equals("D")) {
                        direction = "R";
                    } else { // L 이라면
                        direction = "L";
                    }
                }
            }
        }
    }


    static class Position {
        int x;
        int y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
