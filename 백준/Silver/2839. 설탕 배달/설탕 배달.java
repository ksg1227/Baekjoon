import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


/*
    단계별로 풀어보기
    브루트포스
    2839번 문제: 설탕 배달
*/

public class Main {

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int max5 = N / 5;
        int max3 = N / 3;

        int min = 5000;

        for (int i = 0; i <= max5; i++) {
            for (int j = 0; j <= max3; j++) {
                if (5 * i + 3 * j == N) {
                    min = Math.min(min, i+j);
                }
            }
        }

        if(min == 5000){
            System.out.println(-1);
        }else {
            System.out.println(min);
        }


    }

    public static void main(String args[]) throws Exception {
        new Main().solution();
    }
}


