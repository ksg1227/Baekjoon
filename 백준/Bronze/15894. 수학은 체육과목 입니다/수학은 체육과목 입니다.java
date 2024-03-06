import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/*
    단계별로 풀어보기
    문자열
    15894번 문제: 수학은 체육과목입니다.
*/

public class Main {

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());

        System.out.println(4 * n);
    }

    public static void main(String args[]) throws Exception {
        Main.solution();
    }
}
