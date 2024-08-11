import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
    단계별로 풀어보기
    동적 계획법 1
    9184번 문제: 신나는 함수 실행
*/

public class Main {


    static int[][][] dp = new int[21][21][21];
    //-50 ~ 0 까지는 다 1
    //21 ~ 50 까지는 다 w(20,20,20)
    //즉 1부터 20까지만 중요

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        String str = "";
        while (!(str = br.readLine()).equals("-1 -1 -1")) {
            StringTokenizer st = new StringTokenizer(str);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            sb.append("w(" + a + ", " + b + ", " + c + ") = " + dp(a, b, c)).append("\n");
        }

        System.out.println(sb);


    }

    static int dp(int a, int b, int c) {

        if(checkRange(a, b, c) && dp[a][b][c] != 0) {
            return dp[a][b][c];
        }

        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }
        if (a > 20 || b > 20 || c > 20) {
            return dp(20, 20, 20);
        }
        if (a < b && b < c) {
            return dp[a][b][c] = dp(a, b, c - 1) + dp(a, b - 1, c - 1) - dp(a, b - 1, c);
        }

        return dp[a][b][c] = dp(a - 1, b, c) + dp(a - 1, b - 1, c) + dp(a - 1, b, c - 1) - dp(a - 1, b - 1, c - 1);

    }

    static boolean checkRange(int a, int b, int c) {

        return a >= 0 && b >= 0 && c >= 0 && a <= 20 && b <= 20 && c <= 20;

    }


    public static void main(String args[]) throws Exception {
        Main.solution();
    }
}

