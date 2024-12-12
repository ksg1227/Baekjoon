import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    단계별로 풀어보기
    누적합
    11660번 문제: 구간 합 구하기 5
*/

// 각 행에 가로의 합을 다 더함
// 1행 1열 에는 1행의 1열의 값
// 1행 N열에는 1행의 1 ~ N 열까지의 합
// 그니까 한마디로 각각의 행의 값만을 구하는 거지
public class Main {

    static int[][] sum_map;

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        sum_map = new int[N + 1][N + 1];

        // map에 누적합 저장
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int temp_sum = 0;
            for (int j = 1; j < N + 1; j++) {
                temp_sum += Integer.parseInt(st.nextToken());

                sum_map[i][j] = temp_sum;
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int result = 0;
            if (x1 == x2) {
                result = sum_map[x2][y2] - sum_map[x1][y1 - 1];
            } else {
                for (int j = x1; j <= x2; j++) {
                    result += sum_map[j][y2] - sum_map[j][y1 - 1];
                }
            }

            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
