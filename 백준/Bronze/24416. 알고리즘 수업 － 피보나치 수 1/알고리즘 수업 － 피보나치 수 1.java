import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
    단계별로 풀어보기
    동적 계획법 1
    24416번 문제: 피보나치 수 1
*/

public class Main {

    static int recursiveCount = 0;
    static int dynamicCount = 0;

    static int[] dp;

    static int n;

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        dp = new int[n + 1];

        dp[1] = 1;
        dp[2] = 1;

        fib(n);
        fibonacci(n);

        System.out.println(recursiveCount + " " + dynamicCount);

    }

    static int fib(int num) {
        if (num == 1 || num == 2) {
            recursiveCount++;
            return 1;
        } else {
            return fib(num - 1) + fib(num - 2);
        }
    }

    static int fibonacci(int num) {
        for (int i = 3; i <= num; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            dynamicCount++;
        }

        return dp[num];
    }


    public static void main(String args[]) throws Exception {
        Main.solution();
    }
}

