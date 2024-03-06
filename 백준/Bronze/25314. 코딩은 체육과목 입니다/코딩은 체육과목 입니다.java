import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
    단계별로 풀어보기
    반복문
    25314번 문제: 코딩은 체육과목입니다
*/

public class Main {

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < N / 4; i++) {
            sb.append("long ");
        }
        sb.append("int");

        System.out.println(sb);


    }

    public static void main(String args[]) throws Exception {
        new Main().solution();
    }
}
