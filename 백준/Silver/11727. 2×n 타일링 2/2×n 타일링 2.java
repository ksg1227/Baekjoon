import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
    solved.ac
    class3
    11727번 문제 : 2xn 타일링 2
 */

public class Main {

    static int[] dp;
    static int n;

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 1 x 2 타일 2개는 세트임
        // 2 x 1 , 2 x 2 타일은 각각 따지면 됨

        // 현재 x 위치까지 채우는 경우
        // 2개 전에서 1 x 2를 2개 채우는 경우 , 2x2 를 하나 채우는 경우

        // 1개 전에서 2 x 1 을 채우는 경우

        n = Integer.parseInt(br.readLine());

        dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 2] * 2 + dp[i - 1]) % 10007;
        }

        System.out.println(dp[n]);


    }


    public static void main(String[] args) throws Exception {
        Main.solution();
    }
}
