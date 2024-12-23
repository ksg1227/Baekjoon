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
        int M = Integer.parseInt(br.readLine());
        String S = br.readLine();

        int count = 0;  //I + OI가 몇 개인지
        int result = 0;

        for (int i = 1; i < M - 1; i++) {
            if(S.charAt(i) == 'O' && S.charAt(i-1) == 'I' && S.charAt(i+1) == 'I') {
                count++;

                if(count == N) {
                    count--;
                    result++;
                }
                
                i++;
            } else{
                count = 0;
            }
        }

        System.out.println(result);

    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
