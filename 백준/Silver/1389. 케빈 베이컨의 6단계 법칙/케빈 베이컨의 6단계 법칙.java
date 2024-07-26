import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] graph;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int vertex1 = Integer.parseInt(st.nextToken());
            int vertex2 = Integer.parseInt(st.nextToken());

            graph[vertex1][vertex2] = 1;
            graph[vertex2][vertex1] = 1;
        }

        int minBacon = Integer.MAX_VALUE;
        int resultNode = -1;

        for (int i = 1; i <= N; i++) {
            int baconSum = bfs(i);
            if (baconSum < minBacon) {
                minBacon = baconSum;
                resultNode = i;
            }
        }

        System.out.println(resultNode);
    }

    static int bfs(int start) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start, 0});
        visit = new boolean[N + 1];
        visit[start] = true;

        int totalDistance = 0;

        while (!q.isEmpty()) {
            int[] data = q.poll();
            int vertexNum = data[0];
            int depth = data[1];

            for (int i = 1; i <= N; i++) {
                if (graph[vertexNum][i] == 1 && !visit[i]) {
                    q.add(new int[]{i, depth + 1});
                    visit[i] = true;
                    totalDistance += (depth + 1);
                }
            }
        }

        return totalDistance;
    }
}
