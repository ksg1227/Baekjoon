import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 스터디 9주차
 * DP
 * 백준 12865번 : 평범한 배낭
 */

public class Main {

    static int N;
    static int K;

    static int[][] dp;

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dp = new int[N + 1][K + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            int W = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            // 맨 처음을 채우고 시작 -> 물건은 하나임
            if (i == 1) {
                for (int j = 0; j <= K; j++) {
                    if(j >= W) {
                        dp[i][j] = V;
                    }
                }
            } else {

                // 가방 용량이 K일 때 최고 가치 갱신
                for (int j = 1; j <= K; j++) {
                    // 못 넣는 경우 = 가방의 용량이 현재 물건의 무게보다 적은 경우
                    if (j < W) {
                        dp[i][j] = dp[i - 1][j];
                        continue;
                    } else { // 넣을 수 있는 경우 -> 넣는 게 이득인지, 안 넣는게 이득인지 판단
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - W] + V);
                    }
                }
            }
        }

        System.out.println(dp[N][K]);


    }


    public static void main(String[] args) throws IOException {
        solution();
    }

}








