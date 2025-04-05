import java.io.*;
import java.util.*;

public class Solution {

    // 서로 다른 열에 놓는 경우 N개를 고르고, 그 N개가 서로 겹치지 않는지 체크

    static int[] dx = {-1, 0, 1, 0, -1, -1, 1, 1};
    static int[] dy = {0, 1, 0, -1, -1, 1, -1, 1};

    static int N;
    static boolean[][] board;

    static Position[] queen;
    static boolean[] visited;

    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            N = Integer.parseInt(br.readLine());

            queen = new Position[N];
            visited = new boolean[N];

            count = 0;

            checkQueen(0);

            sb.append("#" + i + " " + count).append("\n");


        }

        System.out.println(sb);

    }

    static void checkQueen(int row) {
        if (row == N) {
            if (isPossible()) {
                count++;
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                queen[row] = new Position(row, i);
                visited[i] = true;
                checkQueen(row + 1);
                visited[i] = false;
            }
        }
    }

    static boolean isPossible() {
        board = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            int currentX = queen[i].x;
            int currentY = queen[i].y;

            if (board[currentX][currentY]) {
                return false;
            }

            board[currentX][currentY] = true;

            for (int j = 0; j < 8; j++) {

                int nextX = currentX;
                int nextY = currentY;

                while (true) {

                    nextX += dx[j];
                    nextY += dy[j];

                    if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
                        board[nextX][nextY] = true;
                    } else {
                        break;
                    }
                }

            }
        }

        return true;
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
