import java.io.*;
import java.util.StringTokenizer;


/*
    단계별로 풀어보기
    일반 수학1
    2903번 문제: 중앙 이동 알고리즘
*/

public class Main {

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        //사각형은 4^N 개만큼 생김

        // 1번 : 3 + 3 - 1 -> (2 + 1) * 2 - 1   2
        // 2번 : 5 + 5 + 5 + 5 - 4 -> (4 + 1) * 4 - 4

        int result = 4;
        for (int i = 1; i <= N; i++) {
            result += (Math.pow(2, i) + 1) * Math.pow(2, i) - Math.pow(4, i - 1);
        }

        System.out.println(result);


    }

    public static void main(String args[]) throws Exception {
        new Main().solution();
    }
}
