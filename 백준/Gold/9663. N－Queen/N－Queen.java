import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {

    static int N;

    // 각 행의 몇 번째 열에 퀸이 놓아져있는지 체크
    static int[] board;

    // 퀸은 각 행, 혹은 각 열마다 하나씩밖에 두지 못한다.

    static int result;

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        board = new int[N];

        backTracking(0, 0);

        System.out.println(result);

    }

    static void backTracking(int row, int count) {
        if (count == N) {
            result++;
            return;
        }

        // 열
        for (int i = 0; i < N; i++) {
            // 특정 열에 둘 수 있는지
            // 위쪽, 대각선 오른쪽, 대각선 왼쪽에 이미 놓아져있는지 체크
            if (checkPossible(row, i)) {
                board[row] = i;
                backTracking(row + 1, count + 1);
                board[row] = 0;
            }

        }
    }

    static boolean checkPossible(int row, int col) {
        for (int i = 0; i < row; i++) {
            // 상단
            if (board[i] == col) {
                return false;
            }

            // 좌측 상단 대각선
            if (board[i] == col - (row - i)) {
                return false;
            }

            // 우측 상단 대각선
            if (board[i] == col + (row - i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
