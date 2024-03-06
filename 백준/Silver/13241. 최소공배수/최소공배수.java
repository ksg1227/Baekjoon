import java.io.*;
import java.util.StringTokenizer;


/*
    단계별로 풀어보기
    약수,배수와 소수2 (번외문제)
    13241번 문제: 최소공배수
*/

public class Main {

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        long result = lcm(A, B);

        System.out.println(result);

    }

    static long gcd(long a, long b) {

        while (b != 0) {
            long r = a % b;

            a = b;
            b = r;
        }

        return a;
    }

    static long gcdRecursive(long a, long b) {


        if (b != 0) {
            return gcdRecursive(b, a % b);
        }
        else{
            return a;
        }
    }
    
    static long lcm(long a, long b){
        return a * b / gcd(a, b);
    }


    public static void main(String args[]) throws Exception {
        new Main().solution();
    }
}
