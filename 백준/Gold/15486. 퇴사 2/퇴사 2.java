import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 스터디 4주차
 * DP
 * 백준 15486번 : 퇴사 2
 */

public class Main {

    static int N;
    static int[] dp;

    static int[] days;
    static int[] benefits;

    static int maxValue = Integer.MIN_VALUE;

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        // N+1 인 날까지 체크하기 위해 N+2 만큼의 크기로 배열을 초기화해줌
        dp = new int[N + 2];
        days = new int[N + 2];
        benefits = new int[N + 2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int benefit = Integer.parseInt(st.nextToken());

            days[i] = day;
            benefits[i] = benefit;
        }

        // N+1인 날에 대해 체크로직이 들어가도 arrayIndexOutOfBounds 에러가 터지지 않도록 N+1인 날까지 모두 배열에 담아서 관리
        dp[N + 1] = 0;
        days[N + 1] = 0;
        benefits[N + 1] = 0;

        for (int i = N; i >= 1; i--) {
            if (i + days[i] <= N + 1) {  // 상담이 가능한 경우 -> 상담을 한 경우랑, 안 한 경우 중 더 이득이 큰 걸 고름
                dp[i] = Math.max(dp[i + days[i]] + benefits[i], dp[i + 1]);
            } else {  // 상담이 불가능한 경우 -> 어차피 상담을 못하니까 안 한 경우로 초기화
                dp[i] = dp[i + 1]; // 어차피 상담을 못하니, 다음날부터 얻을 수 있는 최대 이득으로 초기화
            }

            maxValue = Math.max(dp[i], maxValue);
        }

        System.out.println(maxValue);

    }

    public static void main(String[] args) throws IOException {
        solution();
    }

}







