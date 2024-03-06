import java.io.*;


/*
    단계별로 풀어보기
    반복문
    11021번 문제: A+B - 7
*/

public class Main {

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < N - i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < i; k++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }

    public static void main(String args[]) throws Exception {
        new Main().solution();
    }
}
