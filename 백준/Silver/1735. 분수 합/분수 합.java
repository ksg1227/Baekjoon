import java.io.*;
import java.util.StringTokenizer;


/*
    단계별로 풀어보기
    약수,배수와 소수2 (번외문제)
    1735번 문제: 분수합
*/

public class Main {

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int top1 = Integer.parseInt(st.nextToken());
        int bottom1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int top2 = Integer.parseInt(st.nextToken());
        int bottom2 = Integer.parseInt(st.nextToken());

        int lcm = lcm(bottom1, bottom2);

        int resultBottom = lcm;
        int resultTop = (lcm / bottom1) * top1 + (lcm / bottom2) * top2;

        int lcmTopBottom = gcd(resultBottom, resultTop);

        resultTop /= lcmTopBottom;
        resultBottom /= lcmTopBottom;

        System.out.println(resultTop + " " + resultBottom);


    }

    static int gcd(int a, int b) {

        while (b != 0) {
            int r = a % b;

            a = b;
            b = r;
        }

        return a;
    }

    static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }


    public static void main(String args[]) throws Exception {
        new Main().solution();
    }
}
