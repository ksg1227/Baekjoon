import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/*
    단계별로 풀어보기
    1차원 배열
    1546번 문제: 평균
*/

public class Main {

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int max = arr[N - 1];

        double total = 0;
        for (int i = 0; i < N; i++) {
            total += (double)arr[i] / max * 100;
        }

        System.out.println(total / N);


    }

    public static void main(String args[]) throws Exception {
        new Main().solution();
    }
}
