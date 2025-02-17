import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 스터디 7주차
 * 그리디
 * 백준 2839번 : 설탕 배달
 */

public class Main {

    static int N;

    // 5로 나눠보고 나머지를 3으로 나눠보는 경우

    // 3으로만 나눠보는 경우

    static int result = -1;

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        // 5킬로그램짜리 1개, 2개, ...

        for (int i = N / 5; i >= 0; i--) {
            int num = N - 5 * i;

            int count = 0;
            count += i; // 5 킬로그램짜리 개수

            if (num % 3 == 0) {
                count += num / 3;

                result = count;
                break;
            }
        }

        System.out.println(result);


    }


    public static void main(String[] args) throws IOException {
        solution();
    }

}








