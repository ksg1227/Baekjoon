import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    단계별로 풀어보기
    동적 계획법 1
    10844번 문제: 쉬운 계단 수
*/

public class Main {

    static int N;

    static long[][] dp;
    // dp[i][j] : i번째 숫자가 J인 경우 몇 개의 계단 수가 가능한지
    
    static final int MOD = 1000000000;


    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dp = new long[N][10];

        for (int i = 0; i < 10; i++) {
            if(i == 0) {
                dp[0][i] = 0;
            } else {
                dp[0][i] = 1;
            }
        }

        // n == 1 -> 0 불가능
        // n != 1 -> 0 가능
        // n != 1 -> 만약 이전 수가 0이면 1만 가능
        // n != 1 -> 만약 이전 수가 9이면 8만 가능
        // 즉 이전 수가 1, 2, 3, 4, 5, 6, 7, 8 이면 그냥 dp[n] = dp[n-1] * 2이고
        // 이전 수가 0 혹은 9라면 dp[n] = dp[n-1] + 1

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][1] % MOD;
                } else if (j == 9) {
                    dp[i][j] = dp[i - 1][8] % MOD;
                } else {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % MOD;
                }
            }
        }



        long result = 0;
        for (int i = 0; i < 10; i++) {
            result += dp[N-1][i];
        }

        System.out.println(result % MOD);


    }


    public static void main(String args[]) throws Exception {
        Main.solution();
    }
}


