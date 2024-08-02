import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
    단계별로 풀어보기
    그래프와 순회
    24480번 문제: 알고리즘 수업 - 깊이 우선 탐색 2
*/

public class Main {

    static int N;
    static int M;
    static int R;

    static Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
    static int[] visit;
    static int count = 0;

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        visit = new int[N + 1];

        for(int i = 1; i <= N; i++) {
            map.put(i, new PriorityQueue<>(Comparator.reverseOrder()));
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int vertex1 = Integer.parseInt(st.nextToken());
            int vertex2 = Integer.parseInt(st.nextToken());

            map.get(vertex1).add(vertex2);
            map.get(vertex2).add(vertex1);
        }

        dfs(R);

        for (int i = 1; i <= N; i++) {
            sb.append(visit[i]).append("\n");
        }

        System.out.println(sb);

    }

    static void dfs(int current) {
        visit[current] = ++count;


        while (!map.get(current).isEmpty()) {
            int nextVertex = map.get(current).poll();
            if(visit[nextVertex] == 0) {
                dfs(nextVertex);
            }
        }
    }

    public static void main(String args[]) throws Exception {
        Main.solution();
    }
}
