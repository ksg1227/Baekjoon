import java.io.*;
import java.util.StringTokenizer;

/*
    단계별로 풀어보기
    문자열
    2675번 문제: 문자열 반복
*/

public class Main {

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int R = Integer.parseInt(st.nextToken());
            String S = st.nextToken();

            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < S.length(); j++) {
                for (int k = 0; k < R; k++) {
                    sb.append(S.charAt(j));
                }
            }

            System.out.println(sb);
        }


    }

    public static void main(String args[]) throws Exception {
        new Main().solution();
    }
}

