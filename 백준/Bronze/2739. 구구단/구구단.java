import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*
    단계별로 풀어보기
    반복문
    2739번 문제: 구구단
*/

public class Main {

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= 9; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(N);
            sb.append(" * ");
            sb.append(i);
            sb.append(" = ");
            sb.append(N*i);
            System.out.println(sb);
        }

    }

    public static void main(String args[]) throws Exception {
        new Main().solution();
    }
}
