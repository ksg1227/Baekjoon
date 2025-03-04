import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
    solved.ac
    class3
    11724번 문제 : 연결 요소의 개수
 */

public class Main {

    static int[][] graph;
    static boolean[] visited;
    static int N;
    static int M;

    static int count = 0;

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int vertex1 = Integer.parseInt(st.nextToken());
            int vertex2 = Integer.parseInt(st.nextToken());

            graph[vertex1][vertex2] = 1;
            graph[vertex2][vertex1] = 1;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                count++;
                dfs(i);
            }
        }

        System.out.println(count);

    }

    static void dfs(int current) {
        visited[current] = true;

        for (int i = 1; i <= N; i++) {
            if (!visited[i] && graph[current][i] == 1) {
                dfs(i);
            }
        }
    }


    public static void main(String[] args) throws Exception {
        Main.solution();
    }
}
