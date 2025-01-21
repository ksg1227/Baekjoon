import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 스터디 4주차
 * DP
 * 백준 2579번 : 계단 오르기
 */

public class Main {

    // 0 : 한 계단 아래에서 올라온 경우
    // 1 : 두 계단 아래에서 올라온 경우
    // 만약 둘 다 1이면 그 다음 위치로는 갈 수 없음

    static int[] stairs;
    static int N;
    static int[][] dp;

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        stairs = new int[N + 1];
        dp = new int[N + 1][2];

        stairs[0] = 0;
        for (int i = 1; i <= N; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        dp[0][0] = stairs[0];
        dp[0][1] = stairs[0];

        dp[1][0] = stairs[1];
        dp[1][1] = stairs[1];

        // 한 계단 아래를 밟고 올라온 경우 : 0 -> 두 계단 아래는 밟지 않은 상태여야함
        // 한 계단 아래를 밟지 않고 올라온 경우 : 1 -> 두 계단 아래를 밟았어도 상관 없음
        for (int i = 2; i <= N; i++) {
            dp[i][0] += dp[i - 1][1] + stairs[i];    // dp[i][0] += dp[i-1][0] 은 불가함.

            if (i - 2 >= 0) {
                dp[i][1] += Math.max(dp[i - 2][0], dp[i - 2][1]) + stairs[i];
            }
        }

        System.out.println(Math.max(dp[N][0], dp[N][1]));


    }

    public static void main(String[] args) throws IOException {
        solution();
    }

}







