import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    단계별로 풀어보기
    동적 계획법 1
    11053번 문제: 가장 긴 증가하는 부분 수열
*/


public class Main {

    static int N;
    static int[] dp;
    static int[] sequence;

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        sequence = new int[N];
        dp = new int[N];
        //0 : 수열의 길이
        //1 : 현재 수

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = 1;

        for (int i = 1; i < N; i++) {

            int num = 1;
            boolean flag = false;

            for (int j = i - 1; j >= 0; j--) {
                if (sequence[i] > sequence[j]) {
                    num = Math.max(num, dp[j]);
                    flag = true;
                }
            }

            if (flag) {
                dp[i] = num + 1;
            } else {
                dp[i] = num;
            }

        }

        int result = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            result = Math.max(dp[i], result);
        }

        System.out.println(result);


    }


    public static void main(String args[]) throws Exception {
        Main.solution();
    }
}


