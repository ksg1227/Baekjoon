import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
    solved.ac
    class3
    6064번 문제 : 카잉 달력
 */

public class Main {

    // 마지막 해 = 최소공배수
    // M 이나 N 중 큰 쪽의 수가 주어진 수가 될 때마다, 작은 쪽은 |M-N| 씩 늘어남
    // (이전 수 + |M-N| % 작은 수) % 작은 수 = 결과

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());

            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (x == y) {
                sb.append(x).append("\n");
                continue;
            }

            // 큰 쪽의 숫자에 맞춰야함
            if (M > N) {
                int beforeNum = 0;

                if (x % N == 0) {
                    beforeNum = N;
                } else{
                    beforeNum = x % N;
                }

                int order = x;
                boolean isExist = false;

                if(beforeNum == y) {
                    sb.append(order).append("\n");
                    continue;
                }

                for (int j = 2; j <= N; j++) {
                    order += M;

                    if ((beforeNum + (Math.abs(M - N) % N)) % N == 0) {
                        beforeNum = beforeNum + (Math.abs(M - N) % N);
                    } else {
                        beforeNum = (beforeNum + (Math.abs(M - N) % N)) % N;
                    }

                    if (beforeNum == y) {
                        sb.append(order).append("\n");
                        isExist = true;
                        break;
                    }
                }

                if (!isExist) {
                    sb.append(-1).append("\n");
                }

            } else if (M < N) {
                int beforeNum = 0;

                if (y % M == 0) {
                    beforeNum = M;
                } else{
                    beforeNum = y % M;
                }

                int order = y;
                boolean isExist = false;

                if(beforeNum == x) {
                    sb.append(order).append("\n");
                    continue;
                }

                for (int j = 2; j <= M; j++) {
                    order += N;

                    if ((beforeNum + (Math.abs(M - N) % M)) % M == 0) {
                        beforeNum = beforeNum + (Math.abs(M - N) % M);
                    } else {
                        beforeNum = (beforeNum + (Math.abs(M - N) % M)) % M;
                    }

                    if (beforeNum == x) {
                        sb.append(order).append("\n");
                        isExist = true;
                        break;
                    }
                }

                if (!isExist) {
                    sb.append(-1).append("\n");
                }

            } else {
                sb.append(-1).append("\n");
            }
        }

        System.out.println(sb);
    }


    public static void main(String[] args) throws Exception {
        Main.solution();
    }
}
