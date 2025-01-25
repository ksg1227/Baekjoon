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

    // 특정 좌표를 채우는 경우
    // 세로로 하나 두는 경우 + 이전 위치에서 가로로 위 아래 두는 경우
    static long[] dp;

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        dp = new long[n];

        dp[0] = 1;

        if(n >= 2) {
            dp[1] = 2;
        }

        for (int i = 2; i < n; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 10007;
        }


        System.out.println(dp[n-1]);




    }

    public static void main(String[] args) throws IOException {
        solution();
    }

}







