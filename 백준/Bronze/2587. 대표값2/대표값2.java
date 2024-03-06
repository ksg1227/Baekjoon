import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;


/*
    단계별로 풀어보기
    정렬
    2750번 문제: 수 정렬하기
*/

public class Main {

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[5];

        int sum = 0;

        for (int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 5; j++) {
                if (arr[i] < arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        System.out.println(sum / 5);
        System.out.println(arr[2]);



    }

    public static void main(String args[]) throws Exception {
        new Main().solution();
    }
}

