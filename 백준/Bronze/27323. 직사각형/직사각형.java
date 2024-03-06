import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    단계별로 풀어보기
    문자열
    27866번 문제: 문자와 문자열
*/

public class Main {

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());

        System.out.println(A * B);
    }

    public static void main(String args[]) throws Exception{
        Main.solution();
    }
}
