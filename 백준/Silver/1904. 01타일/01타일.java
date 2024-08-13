import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
    단계별로 풀어보기
    동적 계획법 1
    1904번 문제: 01타일

    피보나치 점화식인가봄
*/


public class Main {

    static int[] dp;
    static int N;

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        dp = new int[N + 1];

        dp[1] = 1;

        if(N == 1){
            System.out.println(1);
        } else {
            dp[2] = 2;

            for (int i = 3; i <= N; i++) {
                dp[i] = (dp[i - 1] + dp[i - 2]) % 15746;
            }

            System.out.println(dp[N]);
        }


    }


    public static void main(String args[]) throws Exception {
        Main.solution();
    }
}

