import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    solved.ac
    class3
    9095번 문제 : 1, 2, 3 더하기
 */
public class Main {

    // 1. 1 이전에서 1만 추가하는 경우
    // 2. 2 이전에서 2만 추가하는 경우
    // 3. 3 이전에서 3만 추가하는 경우
    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int[] dp = new int[11];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i <= 10; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        for (int i = 0; i < T; i++) {
            int num = Integer.parseInt(br.readLine());
            System.out.println(dp[num]);
        }

    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
