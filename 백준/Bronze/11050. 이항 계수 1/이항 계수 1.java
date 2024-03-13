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
        
        
        int top = 1;
        int bottom = 1;

        for (int i = 0; i < K; i++) {
            top *= N;
            N--;
        }
        
        int tempK = K;

        for (int i = 0; i < tempK; i++) {
            bottom *= K;
            K--;
        }

        System.out.println(top / bottom);


    }

    public static void main(String args[]) throws Exception {
        Main.solution();
    }
}


