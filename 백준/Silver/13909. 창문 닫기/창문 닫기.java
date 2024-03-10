import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;


/*
    단계별로 풀어보기
    약수,배수와 소수2
    13909번 문제: 창문 닫기
*/

public class Main {

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        //각 숫자의 모든 약수의 수만큼 바뀌는데

        int count = 0;

        //약수의 개수가 짝수개이면 문은 닫힘
        //즉 약수의 개수가 홀수개인 것을 찾아야함
        //근데 여기서 약수의 개수가 홀수인 것은 제곱수일 수밖에 없다.

        for (int i = 1; i * i <= N; i++) {
            count++;
        }

        System.out.println(count);
    }


    public static void main(String args[]) throws Exception {
        new Main().solution();
    }
}
