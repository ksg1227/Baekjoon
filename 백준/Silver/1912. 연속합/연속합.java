import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/*
    단계별로 풀어보기
    동적 계획법 1
    1912번 문제: 연속합
*/


public class Main {

    static ArrayList<Integer> dp = new ArrayList<>();
    static int N;

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (i == 0) {
                dp.add(num);
            } else {
                if (dp.get(i-1) + num < num) {
                    dp.add(num);
                } else {
                    dp.add(dp.get(i-1) + num);
                }
            }
        }

        Collections.sort(dp);

        System.out.println(dp.get(N-1));


    }


    public static void main(String args[]) throws Exception {
        Main.solution();
    }
}

