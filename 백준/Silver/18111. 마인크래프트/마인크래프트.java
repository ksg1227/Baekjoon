import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    solved.ac
    class3
    18111번 문제 : 마인크래프트
 */

public class Main {

    // 판정하고자 하는 값 = K
    // count += 현재 좌표의 값 - K
    // 결과 count >= B

    // 최소 시간.

    static int N;
    static int M;
    static int B;

    static int resultHeight;
    static int minTime = Integer.MAX_VALUE;

    static int[][] ground;

    static int max = 0;

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        ground = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int height = Integer.parseInt(st.nextToken());

                max = Math.max(max, height);
                ground[i][j] = height;
            }
        }

        for (int i = max; i >= 0; i--) {
            int time = checkTime(i);
            if (time != -1) {
                if (minTime > time) {
                    minTime = time;
                    resultHeight = i;
                }
            }
        }

        sb.append(minTime).append(" ").append(resultHeight);

        System.out.println(sb);


    }

    static int checkTime(int height) {

        int plus = 0;    // 주어진 높이보다 더 높게 쌓인 블럭 수 == 블록을 제거해야하는 횟수
        int minus = 0;   // 주어진 높이보다 더 낮게 쌓인 블럭 수 == 인벤토리에서 꺼내야하는 횟수

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (ground[i][j] < height) {
                    minus += height - ground[i][j];
                    continue;
                }

                if (ground[i][j] > height) {
                    plus += ground[i][j] - height;
                }
            }
        }

        if (plus - minus + B < 0) {
            return -1;
        }

        return plus * 2 + minus;
    }


    public static void main(String[] args) throws Exception {
        Main.solution();
    }
}
