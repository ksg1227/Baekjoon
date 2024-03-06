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

        StringTokenizer st = new StringTokenizer(br.readLine());

        System.out.println(st.countTokens());


    }

    public static void main(String args[]) throws Exception {
        new Main().solution();
    }
}

