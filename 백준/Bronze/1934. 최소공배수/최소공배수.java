import java.io.*;
import java.util.StringTokenizer;


/*
    단계별로 풀어보기
    약수,배수와 소수2 (번외문제)
    1934번 문제: 최소공배수
*/

public class Main {

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<T;i++){
            st = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            sb.append(lcm(a, b)).append("\n");
        }

        System.out.println(sb);
    }

    static int gcd(int a, int b) {

        while(b != 0) {
            int r = a % b;	// 나머지를 구해준다.

            // GCD(a, b) = GCD(b, r)이므로 변환한다.
            a = b;
            b = r;
        }
        return a;
    }

    // 최대공약수 재귀 방식
//    int gcd(int a, int b) {
//        if(b == 0) return a;
//        // GCD(a, b) = GCD(b, r)이므로 (r = a % b)
//        return gcd(b, a % b);
//    }

    // 최소공배수 : Least Common mulitple
    static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    public static void main(String args[]) throws Exception {
        new Main().solution();
    }
}
