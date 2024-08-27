import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
    단계별로 풀어보기
    동적 계획법 1
    2565번 문제: 전깃줄

    철거되어야할 최소 개수 구하기
    =
    전체 전선 개수 - 설치 가능한 최대 개수

    => A 전봇대의 위치가 커질수록 B 전봇대의 위치도 커져야함
*/


public class Main {

    static ArrayList<int[]> list = new ArrayList<>();

    static int n;

    static int[] dp;

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        dp = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list.add(new int[]{x, y});
        }

        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for (int i = 0; i < n; i++) {
            dp[i] = 1;

            for (int j = 0; j < i; j++) {
                if (list.get(i)[1] > list.get(j)[1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }


        int max = 0;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(n - max);


    }


    public static void main(String args[]) throws Exception {
        Main.solution();
    }
}


