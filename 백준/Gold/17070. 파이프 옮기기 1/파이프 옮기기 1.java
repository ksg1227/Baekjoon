import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;
import java.util.StringTokenizer;

/**
 * 스터디 9주차
 * DP
 * 백준 17070번 : 파이프 옮기기
 */

public class Main {
    static int N;
    static int[][] map;

    // 특정 좌표에 파이프가 걸쳐져있는 경우 -> 3가지 경우가 가능
    static int[][][] dp;

    // index 0 : 가로로 세워진 상황
    // case 1. 가로에서 오른쪽으로 하나 가는 경우
    // case 2. 대각선에서 회전시키며 오른쪽으로 가는 경우

    // index 1 : 세로로 세워진 상황
    // case 1. 세로에서 위에서 아래로 하나 가는 경우
    // case 2. 대각선에서 회전시키며 아래로 가는 경우

    // index 2 : 대각선으로 세워진 상황
    // case 1. 가로에서 회전시키며 아래로 가는 경우
    // case 2. 세로에서 회전시키며 아래로 가는 경우
    // case 3. 대각선에서 대각선 아래로 가는 경우
    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        dp = new int[N + 1][N + 1][3];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[1][2][0] = 1;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == 1 && j == 2) {
                    continue;
                }
                if (map[i][j] == 0) {

                    if (j - 1 >= 1) {
                        dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][2];
                    }

                    if (i - 1 >= 1) {
                        dp[i][j][1] = dp[i - 1][j][1] + dp[i - 1][j][2];
                    }

                    if (i - 1 >= 1 && j - 1 >= 1) {
                        if (map[i - 1][j] == 0 && map[i][j - 1] == 0) {
                            dp[i][j][2] = dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
                        }
                    }
                }
            }
        }

        System.out.println(dp[N][N][0] + dp[N][N][1] + dp[N][N][2]);


    }


    public static void main(String[] args) throws IOException {
        solution();
    }

}








