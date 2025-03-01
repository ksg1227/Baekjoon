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

            int max = (M * N) / GCD(M, N);

            int order = 0;

            // 큰 쪽에 맞춰야함
            if (M > N) {
                boolean isExist = false;
                for (int j = x; j <= max; j += M) {
                    order = j;

                    int check = 0;

                    if(order % N == 0) {
                        check = N;
                    } else{
                        check = order % N;
                    }

                    if (check == y) {
                        isExist = true;
                        sb.append(order).append("\n");
                        break;
                    }
                }

                if(!isExist) {
                    sb.append(-1).append("\n");
                }
            } else if (M < N) {
                boolean isExist = false;

                for (int j = y; j <= max; j += N) {
                    order = j;

                    int check = 0;

                    if(order % M == 0) {
                        check = M;
                    } else{
                        check = order % M;
                    }

                    if (check == x) {
                        isExist = true;
                        sb.append(order).append("\n");
                        break;
                    }
                }

                if(!isExist) {
                    sb.append(-1).append("\n");
                }
            } else {
                if (x == y) {
                    sb.append(x).append("\n");
                } else {
                    sb.append(-1).append("\n");
                }
            }
        }

        System.out.println(sb);
    }

    static int GCD(int a, int b) {
        if (a % b == 0) {
            return b;
        }

        return GCD(b, a % b);
    }


    public static void main(String[] args) throws Exception {
        Main.solution();
    }
}
