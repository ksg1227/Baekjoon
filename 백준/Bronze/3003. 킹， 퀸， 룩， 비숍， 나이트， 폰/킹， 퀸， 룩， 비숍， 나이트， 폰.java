import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    단계별로 풀어보기
    심화 1단계
    3003번 문제: 킹, 퀸, 룩, 비숍, 나이트, 폰
*/

public class Main {

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        int[] arr = new int[6];

        for (int i = 0; i < 6; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            if (i == 0 || i == 1) {
                sb.append(1 - arr[i]).append(" ");
            } else if (i == 2 || i == 3 || i == 4) {
                sb.append(2 - arr[i]).append(" ");
            } else if (i == 5) {
                sb.append(8 - arr[i]).append(" ");
            }
        }

        System.out.println(sb);


    }

    public static void main(String args[]) throws Exception {
        new Main().solution();
    }
}





