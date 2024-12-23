/*
    solved.ac
    class3
    5525번 문제 : IOIOI
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    // P_N : 0이 N개, 1이 N+1 개
    // P_N은 무조건 0으로 시작

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int length = Integer.parseInt(br.readLine());
        String S = br.readLine();

        StringBuilder P_N = new StringBuilder();

        for (int i = 0; i < (2 * N + 1); i++) {
            if (i % 2 == 0) {
                P_N.append("I");
            } else {
                P_N.append("O");
            }
        }

        int result = 0;
        for (int i = 0; i <= length - (2 * N + 1); i++) {
            if (P_N.toString().equals(S.substring(i, i + (2 * N + 1)))) {
                result++;
            }
        }

        System.out.println(result);

    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
