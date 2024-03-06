import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
    단계별로 풀어보기
    반복문
    8393번 문제: 합
*/

public class Main {

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        System.out.println(n*(n+1)/2);

    }

    public static void main(String args[]) throws Exception {
        new Main().solution();
    }
}
