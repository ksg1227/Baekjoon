import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 스터디 4주차
 * DP
 * 백준 11049번 : 행렬 곱셈 순서
 */

public class Main {

    static int N;
    static int[] row;
    static int[] col;
    static long[][][] dp;

    // 행렬 곱의 첫번째 행렬만 행 값 * 열 값을 하고, 그 다음 행렬부터는 열 값만 곱해주면 됨.

    // 두 행렬을 곱하고, 뒤 행렬의 가장 첫번째 값으로 한 번 나누어주면 계산됨

    // 계산 결과(= 행렬 형태), 계산 횟수를 모두 저장해야하나?
    // 0 : 계산 결과 - 계산 결과(= 계산 후 행렬 형태)를 알아야 그 다음 행렬과 곱셈을 할 때 계산 횟수를 구할 수 있음
    // 1 : 계산 횟수 - 계산 횟수를 알아야 답을 알 수 있음


    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        row = new int[N + 1];
        col = new int[N + 1];
        dp = new long[N + 1][N + 1][2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            row[i] = Integer.parseInt(st.nextToken());
            col[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            dp[i][i][0] = row[i] * col[i];
            dp[i][i][1] = 0;
        }

        if (N >= 2) {
            for (int i = 2; i <= N; i++) { // 행렬 i개를 서로 곱한 경우를 계산
                for (int j = 1; j <= N; j++) { // j번째 행렬에서부터 i개의 행렬을 곱하는 경우를 계산
                    if (j + i - 1 <= N) {
                        long minValue = Long.MAX_VALUE;
                        for (int k = 1; k <= i - 1; k++) {    // i개를 서로 곱한다고 했을 때, k, i-k 개씩 나눠서 계산
                            long result = calculateMatrix(dp[j][j + k - 1][0], dp[j + k][j + i - 1][0], j + k);
                            dp[j][j + i - 1][0] = result;

                            minValue = Math.min(minValue, dp[j][j + k - 1][1] + dp[j + k][j + i - 1][1] + countMatrix(dp[j][j + k - 1][0], dp[j + k][j + i - 1][0], j + k));
                        }
                        dp[j][j + i - 1][1] = minValue;
                    }
                }
            }
        }

        System.out.println(dp[1][N][1]);

    }

    static long calculateMatrix(long fisrstMatrixProd, long secondMatrixProd, int secondMatrixStartIndex) {
        return fisrstMatrixProd * secondMatrixProd / (row[secondMatrixStartIndex] * row[secondMatrixStartIndex]);
    }


    static long countMatrix(long firstMatrixProd, long secondMatrixProd, int secondMatrixStartIndex) {
        return firstMatrixProd * secondMatrixProd / row[secondMatrixStartIndex];
    }


    public static void main(String[] args) throws IOException {
        solution();
    }

}







