import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 스터디 7주차
 * 그리디
 * 백준 16953번 : A -> B
 */

public class Main {

    static int A;
    static int B;

    static long result = Integer.MAX_VALUE;

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        findMin(A, 0);

        if (result == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(result + 1);
        }

    }

    static void findMin(long num, int count) {
        if (num == B) {
            result = Math.min(result, count);
            return;
        }

        if (num > B) {
            return;
        }

        findMin(num * 2, count + 1);

        findMin(num * 10 + 1, count + 1);
    }


    public static void main(String[] args) throws IOException {
        solution();
    }

}








