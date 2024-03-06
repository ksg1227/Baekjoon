import java.awt.image.DataBufferDouble;
import java.io.*;
import java.util.StringTokenizer;


/*
    단계별로 풀어보기
    반복문
    11021번 문제: A+B - 7
*/

public class Main {

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }

    public static void main(String args[]) throws Exception {
        new Main().solution();
    }
}
