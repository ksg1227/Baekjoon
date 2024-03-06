import java.io.*;
import java.util.StringTokenizer;


/*
    단계별로 풀어보기
    2차원 배열
    2566번 문제: 최댓값
*/

public class Main {

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int max = -1;
        int x = 0, y = 0;
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                int num = Integer.parseInt(st.nextToken());
                max = Math.max(max, num);

                if (max == num) {
                    x = i + 1;
                    y = j + 1;
                }
            }
        }

        System.out.println(max);
        System.out.println(x + " " + y);


    }

    public static void main(String args[]) throws Exception {
        new Main().solution();
    }
}

