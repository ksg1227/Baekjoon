import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    단계별로 풀어보기
    동적 계획법 1
    1932번 문제: 정수 삼각형
*/

public class Main {

    //내 위 레벨의 숫자중 왼쪽, 오른쪽 둘 중 하나
    //해당 레벨에서 내가 가장 왼쪽, 가장 오른쪽이면 그냥 위에꺼 더하면 됨
    //깊이, 해당 레벨에서 내가 몇번째인지

    static int n;

    static int[][] triangle;

    static int[][] dp;

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        triangle = new int[n][];
        dp = new int[n][];

        for (int i = 0; i < n; i++) {
            triangle[i] = new int[i + 1];
            dp[i] = new int[i + 1];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i + 1; j++) {
                int num = Integer.parseInt(st.nextToken());
                triangle[i][j] = num;

                if (i == 0) {
                    dp[i][j] = num;
                }

                if (i == 1) {
                    dp[i][j] = dp[i - 1][0] + num;
                }
            }
        }

        int result = Integer.MIN_VALUE;

        for (int i = 2; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + triangle[i][j];
                } else if (j == i) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
                } else {
                    int tempNum = triangle[i][j];
                    dp[i][j] = Math.max(dp[i - 1][j - 1] + tempNum, dp[i - 1][j] + tempNum);
                }

                if (i == n - 1) {
                    result = Math.max(result, dp[i][j]);
                }
            }
        }

        if(n == 1) {
            System.out.println(dp[0][0]);
        } else if(n == 2) {
            System.out.println(Math.max(dp[1][0], dp[1][1]));
        } else{
            System.out.println(result);
        }




    }


    public static void main(String args[]) throws Exception {
        Main.solution();
    }
}


