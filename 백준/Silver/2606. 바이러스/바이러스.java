import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
    단계별로 풀어보기
    그래프와 순회
    2606번 문제: 바이러스
*/

public class Main {

    static int computerNum;
    static int pair;

    static int[][] graph;
    static boolean[] visit;


    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        computerNum = Integer.parseInt(br.readLine());
        pair = Integer.parseInt(br.readLine());

        graph = new int[computerNum + 1][computerNum + 1];
        visit = new boolean[computerNum + 1];

        StringTokenizer st;

        for (int i = 0; i < pair; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        dfs(1);

        int count = 0;

        for (int i = 2; i <= computerNum; i++) {
            if (visit[i]) {
                count++;
            }
        }

        System.out.println(count);

    }

    static void dfs(int current) {

        visit[current] = true;

        for (int i = 1; i <= computerNum; i++) {
            if (i != current) {
                if (graph[current][i] == 1 && !visit[i]) {
                    dfs(i);
                }
            }
        }
    }

    public static void main(String args[]) throws Exception {
        Main.solution();
    }
}

