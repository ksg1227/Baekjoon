import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    단계별로 풀어보기
    동적 계획법 1
    2156번 문제: 포도주 시식
*/


public class Main {

    static int n;

    static int[] wine;
    static int[][] dp;

    //이전꺼를 마시고 현재에 온 경우 -> 2번으로 계산
    //이전 꺼를 마시지 않고 현재에 온 경우 -> 1번으로 초기화

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        wine = new int[n];
        dp = new int[n][2];

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            wine[i] = num;
        }

        dp[0][0] = wine[0];
        dp[0][1] = wine[0];

        int result = wine[0];

        if (n >= 2) {

            dp[1][0] = wine[0] + wine[1];
            dp[1][1] = wine[1];

            if (n == 2) {
                result = dp[1][0];
            } else {
                
                result = dp[1][0];

                for (int i = 2; i < n; i++) {

                    dp[i][0] = dp[i - 1][1] + wine[i];

                    int tempMax = Integer.MIN_VALUE;

                    for (int j = i - 2; j >= 0; j--) {
                        int dpMax = Math.max(dp[j][0], dp[j][1]);
                        if (dpMax <= tempMax) {
                            break;
                        }
                        tempMax = dpMax;
                    }
                    dp[i][1] = tempMax + wine[i];

                    result = Math.max(result, Math.max(dp[i][0], dp[i][1]));
                }
            }

        }

        System.out.println(result);


    }


    public static void main(String args[]) throws Exception {
        Main.solution();
    }
}


