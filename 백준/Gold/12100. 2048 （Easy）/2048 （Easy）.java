import java.io.*;
import java.util.*;

public class Main {

    // 스택 사용
    // 하나 뽑고, 그 다음 꺼를 뽑음
    // 처음 뽑은 거랑 그 다음 뽑은게 같으면 둘 다 빼버리고 그 더한 걸 값으로 설정
    // 처음 뽑은 거랑 그 다음 뽑은게 다르면 그 다음 뽑은 건 다시 집어넣음
    // 더이상 뽑을 게 없거나, 하나 뽑고 끝나면 그냥 추가하면 됨

    static int N;
    static int[][] board;
    // 0 이면 빈 칸

    static int max = Integer.MIN_VALUE;

    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 가장 큰 값 계산하기
        game(0);

        System.out.println(max);

    }

    static void game(int count) {
        if (count == 5) {
            max = Math.max(max, findMax());
            return;
        }

        for (int i = 0; i < 4; i++) {
            int[][] copy = new int[N][N];
            copyMap(copy, board);

            if (i == 0) {
                moveRight();
            } else if (i == 1) {
                moveTop();
            } else if (i == 2) {
                moveLeft();
            } else {
                moveBottom();
            }

            game(count + 1);
            copyMap(board, copy);
        }


    }

    static void moveRight() {
        for (int i = 0; i < N; i++) {
            int[] row = board[i];

            for (int j = 0; j < N; j++) {
                if (row[j] != 0) {
                    stack.push(row[j]);
                }
            }

            List<Integer> tempList = new ArrayList<>();

            while (!stack.isEmpty()) {
                // 첫번쨰 숫자
                int first = stack.pop();

                if (stack.isEmpty()) {
                    tempList.add(first);
                    break;
                }

                //
                int second = stack.peek();

                if (first == second) {
                    tempList.add(first + second);
                    stack.pop();
                } else {
                    tempList.add(first);
                }
            }

            int index = N - 1;

            for (int j = 0; j < tempList.size(); j++) {
                board[i][index--] = tempList.get(j);
            }

            for (int j = index; j >= 0; j--) {
                board[i][j] = 0;
            }
        }
    }

    static void moveTop() {
        // 열 들
        for (int i = 0; i < N; i++) {
            int[] col = new int[N];

            for (int j = 0; j < N; j++) {
                col[j] = board[j][i];
            }


            for (int j = N - 1; j >= 0; j--) {
                if (col[j] != 0) {
                    stack.push(col[j]);
                }
            }

            List<Integer> tempList = new ArrayList<>();

            while (!stack.isEmpty()) {
                // 첫번쨰 숫자
                int first = stack.pop();

                if (stack.isEmpty()) {
                    tempList.add(first);
                    break;
                }

                //
                int second = stack.peek();

                if (first == second) {
                    tempList.add(first + second);
                    stack.pop();
                } else {
                    tempList.add(first);
                }
            }

            int index = 0;

            for (int j = 0; j < tempList.size(); j++) {
                board[index++][i] = tempList.get(j);
            }

            for (int j = index; j < N; j++) {
                board[j][i] = 0;
            }
        }
    }

    static void moveLeft() {
        // 열 들
        for (int i = 0; i < N; i++) {
            int[] row = board[i];


            for (int j = N - 1; j >= 0; j--) {
                if (row[j] != 0) {
                    stack.push(row[j]);
                }
            }

            List<Integer> tempList = new ArrayList<>();

            while (!stack.isEmpty()) {
                // 첫번쨰 숫자
                int first = stack.pop();

                if (stack.isEmpty()) {
                    tempList.add(first);
                    break;
                }

                //
                int second = stack.peek();

                if (first == second) {
                    tempList.add(first + second);
                    stack.pop();
                } else {
                    tempList.add(first);
                }
            }

            int index = 0;

            for (int j = 0; j < tempList.size(); j++) {
                board[i][index++] = tempList.get(j);
            }

            for (int j = index; j < N; j++) {
                board[i][j] = 0;
            }
        }
    }

    static void moveBottom() {
        // 열 들
        for (int i = 0; i < N; i++) {
            int[] col = new int[N];

            for (int j = N - 1; j >= 0; j--) {
                col[j] = board[j][i];
            }


            for (int j = 0; j < N; j++) {
                if (col[j] != 0) {
                    stack.push(col[j]);
                }
            }

            List<Integer> tempList = new ArrayList<>();

            while (!stack.isEmpty()) {
                // 첫번쨰 숫자
                int first = stack.pop();

                if (stack.isEmpty()) {
                    tempList.add(first);
                    break;
                }

                //
                int second = stack.peek();

                if (first == second) {
                    tempList.add(first + second);
                    stack.pop();
                } else {
                    tempList.add(first);
                }
            }

            int index = N - 1;

            for (int j = 0; j < tempList.size(); j++) {
                board[index--][i] = tempList.get(j);
            }

            for (int j = index; j >= 0; j--) {
                board[j][i] = 0;
            }
        }
    }

    static void copyMap(int[][] copy, int[][] original) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                copy[i][j] = original[i][j];
            }
        }
    }


    static int findMax() {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                max = Math.max(max, board[i][j]);
            }
        }

        return max;
    }
}
