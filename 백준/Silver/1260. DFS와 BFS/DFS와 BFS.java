import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/*
    solved.ac
    class3
    1260번 문제 : DFS와 BFS
 */

public class Main {

    static int[][] graph;
    static int N;
    static int M;
    static int V;
    static boolean[] visit;

    static Queue<Integer> queue = new LinkedList<>();

    static StringBuilder sb1 = new StringBuilder();
    static StringBuilder sb2 = new StringBuilder();

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][N + 1];
        visit = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int vertex1 = Integer.parseInt(st.nextToken());
            int vertex2 = Integer.parseInt(st.nextToken());

            graph[vertex1][vertex2] = 1;
            graph[vertex2][vertex1] = 1;
        }

        dfs(V);
        clear();
        repeat_Bfs(V);


        System.out.println(sb1);
        System.out.println(sb2);

    }

    static void dfs(int vertexNum) {

        sb1.append(vertexNum).append(" ");
        visit[vertexNum] = true;

        for (int i = 1; i <= N; i++) {
            if (graph[vertexNum][i] == 1 && visit[i] == false) {
                dfs(i);
            }
        }
    }

//    static void recursive_Bfs(int vertexNum) {
//
//        visit[vertexNum] = true;
//        sb2.append(vertexNum).append(" ");
//
//        for (int i = 1; i <= N; i++) {
//            if (graph[vertexNum][i] == 1 && visit[i] == false
//                    && !queue.contains(i)) {
//                queue.add(i);
//            }
//        }
//
//        while (!queue.isEmpty()) {
//            bfs(queue.poll());
//        }
//    }

    static void repeat_Bfs(int vertexNum) {

        visit[vertexNum] = true;   //첫번째 정점을 위한 부분
        queue.add(vertexNum);      //마찬가지로 첫번째 정점을 위한 부분

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            sb2.append(vertex).append(" ");
            for (int i = 1; i <= N; i++) {
                if (graph[vertex][i] == 1 && visit[i] == false && !queue.contains(i)) {
                    visit[i] = true;
                    queue.add(i);
                }
            }
        }
    }


    static void clear() {
        for (int i = 0; i < visit.length; i++) {
            visit[i] = false;
        }
    }

    public static void main(String[] args) throws Exception {
        Main.solution();
    }
}
