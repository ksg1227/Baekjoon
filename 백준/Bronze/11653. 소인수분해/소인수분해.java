import java.io.*;
import java.util.StringTokenizer;


/*
    단계별로 풀어보기
    약수,배수와 소수
    11653번 문제: 소인수분해
*/

public class Main {

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 2; i <= Math.sqrt(N); i++) {
            while(N % i == 0){
                System.out.println(i);
                N /= i;
            }
        }
        if(N != 1){
            System.out.println(N);
        }


    }

    public static void main(String args[]) throws Exception {
        new Main().solution();
    }
}
