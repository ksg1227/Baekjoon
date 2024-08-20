import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    단계별로 풀어보기
    동적 계획법 1
    1149번 문제: RGB 거리
*/


public class Main {

    //해당 계단으로 도달할 수 있는 경우는 2가지.
    //두 계단 아래에서 올라오거나, 한 계단 아래에서 올라오거나
    //1차원 배열 : 몇 번째 계단인지
    //2차원 배열 : 0, 1
    //0 : 바로 아래 계단에서 올라온 경우
    //1 : 두 계단 아래에서 올라온 경우

    static int[] stairs;
    static int[][] dp;

    static int n;

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        stairs = new int[n];
        dp = new int[n][2];


        for (int i = 0; i < n; i++) {
            stairs[i] = Integer.parseInt(br.readLine());

            if (i == 0) {
                dp[i][0] = stairs[i];
                dp[i][1] = stairs[i];
            }

            if (i == 1) {
                dp[i][0] = dp[i - 1][0] + stairs[i];
                dp[i][1] = stairs[i];
            }
        }

        // 첫번째 계단에 오르는 경우의 수
        // 두번째 계단에 오르는 경우의 수
        // 미리 채워두기


        for (int i = 2; i < n; i++) {
            //바로 아래 계단에서 올라오는 경우
            //바로 아래 계단은 그 계단보다 2계단 아래에서 올라온 경우여야만 함
            dp[i][0] = dp[i-1][1] + stairs[i];

            //2계단 아래에서 올라오는 경우
            //2계단 아래 계단은 그 계단보다 1계단 아래이던, 2계단 아래에서 올라오던 상관 없음
            dp[i][1] = Math.max(dp[i-2][0], dp[i-2][1]) + stairs[i];
        }

        System.out.println(Math.max(dp[n-1][0], dp[n-1][1]));


    }


    public static void main(String args[]) throws Exception {
        Main.solution();
    }
}


