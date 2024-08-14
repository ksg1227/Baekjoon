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

    static int N;

    static int[][] house;

    static int[][] dp;

    //특정 시점에 r을 선택해야할 때까지 최소값 경우
    //특정 시점에 g를 선택해야할 때까지 최소값 경우
    //특정 시점에 b를 선택해야할 때까지 최소값 경우

    static int result = Integer.MAX_VALUE;

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        house = new int[N][3];
        dp = new int[N][3];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 3; j++) {
                int num = Integer.parseInt(st.nextToken());
                house[i][j] = num;

                if (i == 0) {
                    dp[i][j] = num;
                }
            }
        }


        for (int i = 1; i < N; i++) {

            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    dp[i][j] = Math.min(dp[i - 1][1] + house[i][j], dp[i - 1][2] + house[i][j]);
                } else if (j == 1) {
                    dp[i][j] = Math.min(dp[i - 1][0] + house[i][j], dp[i - 1][2] + house[i][j]);
                } else {
                    dp[i][j] = Math.min(dp[i - 1][0] + house[i][j], dp[i - 1][1] + house[i][j]);
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            result = Math.min(result, dp[N-1][i]);
        }

        System.out.println(result);


    }


    public static void main(String args[]) throws Exception {
        Main.solution();
    }
}


