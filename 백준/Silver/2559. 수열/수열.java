import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    단계별로 풀어보기
    누적합
    2559번 문제: 수열
*/
public class Main {

    static int[] dates;

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        dates = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            if (i == 0) {
                dates[i] = Integer.parseInt(st.nextToken());
            } else {
                dates[i] = Integer.parseInt(st.nextToken()) + dates[i - 1];
            }
        }

        int max = Integer.MIN_VALUE;

        for (int i = K - 1; i < N; i++) {
            if (i == K - 1) {
                max = Math.max(max, dates[i]);
            } else {
                max = Math.max(max, dates[i] - dates[i - K]);
            }
        }

        System.out.println(max);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
