import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;


/*
    단계별로 풀어보기
    약수,배수와 소수
    1978번 문제: 소수 찾기
*/

public class Main {

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int count = 0;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());

            if(num == 1){
                continue;
            }

            boolean flag = true;

            for (int j = 2; j < num; j++) {
                if(num % j == 0){
                    flag = false;
                }
            }

            if(flag){
                count++;
            }

        }

        System.out.println(count);


    }

    public static void main(String args[]) throws Exception {
        new Main().solution();
    }
}
