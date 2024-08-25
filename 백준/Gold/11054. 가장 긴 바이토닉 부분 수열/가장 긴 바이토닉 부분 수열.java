import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    단계별로 풀어보기
    동적 계획법 1
    11054번 문제: 가장 바이토닉 부분 수열
*/


public class Main {

    static int N;
    static int[] increase_Dp;
    static int[] decrease_Dp;
    static int[] sequence;

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        sequence = new int[N];
        increase_Dp = new int[N];
        decrease_Dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        increase_Dp[0] = 1;
        decrease_Dp[N - 1] = 1;

        LIS();
        LDS();

        int result = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            result = Math.max(increase_Dp[i] + decrease_Dp[i], result);
        }

        System.out.println(result - 1);


    }

    static void LIS() {
        for (int i = 1; i < N; i++) {

            int num = 1;
            boolean flag = false;

            for (int j = i - 1; j >= 0; j--) {
                if (sequence[i] > sequence[j]) {
                    num = Math.max(num, increase_Dp[j]);
                    flag = true;
                }
            }

            if (flag) {
                increase_Dp[i] = num + 1;
            } else {
                increase_Dp[i] = num;
            }

        }
    }

    static void LDS() {
        for (int i = N - 2; i >= 0; i--) {

            int num = 1;
            boolean flag = false;

            for (int j = i + 1; j < N; j++) {
                if (sequence[i] > sequence[j]) {
                    num = Math.max(num, decrease_Dp[j]);
                    flag = true;
                }
            }

            if (flag) {
                decrease_Dp[i] = num + 1;
            } else {
                decrease_Dp[i] = num;
            }

        }
    }


    public static void main(String args[]) throws Exception {
        Main.solution();
    }
}


