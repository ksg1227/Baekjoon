import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
    단계별로 풀어보기
    그리디
    11047번 문제: 동전 0
*/

public class Main {

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new BufferedReader(new InputStreamReader(System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] value = new int[N];

        int count = 0;

        for (int i = 0; i < N; i++) {
            value[i] = Integer.parseInt(br.readLine());
        }

        for (int i = N - 1; i >= 0; i--) {
            if (value[i] > K) {
                continue;
            } else {
                if(K == 0){
                    break;
                }

                count += K / value[i];
                K = K % value[i];
            }
        }

        System.out.println(count);


    }


    public static void main(String args[]) throws Exception {
        Main.solution();
    }
}

