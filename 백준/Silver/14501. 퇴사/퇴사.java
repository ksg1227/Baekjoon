import java.io.*;
import java.util.*;

/**
 * 백준 - 14501번
 */
public class Main {

    static int N;
    static int[][] day;

    // 해당 날짜까지 얻을 수 있는 최대 이익
    static int[] dp;

    // T_i = 기간
    // 현재 날짜 + T_i - 1 일까지 상담함.
    // 즉 기간이 1일이라면 4일에 상담을 시작해서 4일에 끝남.
    // 그래서 다음날부터 바로 새로운 상담을 할 수 있음

    // P_i = 금액

    // 그 날 상담을 하는 경우, 안하는 경우중 뭐가 더 이득인지
    // 뒤에서 부터 체크 - DP
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        day = new int[N + 1][2];
        dp = new int[2000];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            day[i][0] = Integer.parseInt(st.nextToken());
            day[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = N; i >= 1; i--) {
            // 상담을 어차피 못하는 경우
            if (i + (day[i][0] - 1) >= N + 1) {
                dp[i] = dp[i+1];
                continue;
            }

            // 상담을 할 수 있는 경우
            // 상담을 안하는 것과, 상담을 하는 것 중 어떤 게 더 이득인지
            dp[i] = Math.max(dp[i+1], dp[i + day[i][0]] + day[i][1]);
        }

        System.out.println(dp[1]);
    }
}
