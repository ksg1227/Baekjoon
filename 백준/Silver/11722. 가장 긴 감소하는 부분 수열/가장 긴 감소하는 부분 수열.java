import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 스터디 9주차
 * DP
 * 백준 11722번 : 가장 긴 감소하는 부분 수열
 */

public class Main {

    // 자기 이전에 있는 것들중 자신보다 값이 큰 것들은 하나하나 다 확인.
    // 그 중 가장 긴 것 + 1 한 값 으로 갱신

    static int[] A;
    static int[] dp;

    static int N;

    static int result = Integer.MIN_VALUE;

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        A = new int[N];
        dp = new int[N];

        Arrays.fill(dp, 1);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N; i++) {
            dp[i] = findMaxLength(i);
        }

        for (int i = 0; i < N; i++) {
            result = Math.max(result, dp[i]);
        }

        System.out.println(result);

    }

    static int findMaxLength(int index) {
        int num = A[index];

        int maxLength = 1;
        for (int i = index - 1; i >= 0; i--) {
            if (A[i] > num) { // 감소하는 형태
                maxLength = Math.max(maxLength, dp[i] + 1);
            }
        }

        return maxLength;
    }


    public static void main(String[] args) throws IOException {
        solution();
    }

}








