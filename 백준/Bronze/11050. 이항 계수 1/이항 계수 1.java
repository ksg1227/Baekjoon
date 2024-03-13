import java.io.*;
import java.util.StringTokenizer;


/*
    단계별로 풀어보기
    조합론
    10872번 문제: 팩토리얼
*/

public class Main {

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        System.out.println(fac(N) / (fac(N-K) * fac(K)));


    }

    static int fac(int N) {
        int result = 1;

        for (int i = N; i >= 1; i--) {
            result *= i;
        }

        return result;
    }

    public static void main(String args[]) throws Exception {
        Main.solution();
    }
}


