import java.io.*;
import java.util.*;

/**
 * 스터디 11주차
 * 그리디
 * 백준 1080번 : 행렬
 */

public class Main {

    static int N, M;

    static int[][] A;
    static int[][] B;

    static int result = 0;

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N][M];
        B = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                A[i][j] = line.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                B[i][j] = line.charAt(j) - '0';
            }
        }

        boolean flag = false;

        for (int i = 0; i < N * M; i++) {
            int x = i / M;
            int y = i % M;

            // 바꿀 수 있다면
            if (N - 1 - x >= 2 && M - 1 - y >= 2) {

                // 값이 서로 다르면 반드시 바꿔야함
                if (A[x][y] != B[x][y]) {
                    changeA(x, y); // 바꾸고 체크
                    result++;
                }

                if (Arrays.deepEquals(A, B)) {
                    flag = true;
                    break;
                }

            } else { // 바꿀 수 없다면

                // 바꿀 수 없는데 서로 다르다면 바로 틀림
                if (A[x][y] != B[x][y]) {
                    break;
                } else {
                    if (Arrays.deepEquals(A, B)) {
                        flag = true;
                        break;
                    }
                }
            }
        }

        if (flag) {
            System.out.println(result);
        } else {
            System.out.println(-1);
        }

    }


    static void changeA(int x, int y) {
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                if (A[i][j] == 0) {
                    A[i][j] = 1;
                } else {
                    A[i][j] = 0;
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        solution();
    }
}










