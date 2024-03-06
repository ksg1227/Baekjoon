import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
    단계별로 풀어보기
    시간 복잡도
    24262번 문제: 알고리즘 수업 - 알고리즘의 수행 시간1
*/

public class Main {

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a1 = Integer.parseInt(st.nextToken());
        int a0 = Integer.parseInt(st.nextToken());

        int c = Integer.parseInt(br.readLine());
        int n0 = Integer.parseInt(br.readLine());

        //g(n) = n
        //즉 f(n) <= c * n
        // a1*n + a0 <= c * n  (n >= n0)

        if (c >= a1 && (c - a1) * n0 >= a0) {
            System.out.println(1);
        }
        else{
            System.out.println(0);
        }


    }

    public static void main(String args[]) throws Exception {
        new Main().solution();
    }
}

