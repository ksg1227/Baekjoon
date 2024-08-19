import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    단계별로 풀어보기
    동적 계획법 1
    9461번 문제: 파도반 수열
*/


public class Main {

    static int N;
    static int T;

    //P(11) = 9{ P(10) }  + 3 P(6)
    //P(12) = 12{ P(11) } + 4 P(7)
    //P(13) = 16 + 5
    //P(14) = 21 + 7
    static long[] dp;

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        dp = new long[101];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;

        for (int i = 6; i <= 100; i++) {
            dp[i] = dp[i - 1] + dp[i - 5];
        }

        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());

            sb.append(dp[N]).append("\n");
        }

        System.out.println(sb);

    }


    public static void main(String args[]) throws Exception {
        Main.solution();
    }
}


