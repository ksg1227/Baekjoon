import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 스터디 8주차
 * 다익스트라
 * 백준 11779번 : 최소비용 구하기 2
 */

public class Main {

    static int N;
    static int M;
    static int start;
    static int end;

    static int[][] graph;

    static boolean[] visited;

    static int[] minDistance;

    static ArrayList<Integer>[] path;

    static int TEMP_MAX = 100000000;


    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new int[N + 1][N + 1];
        visited = new boolean[N + 1];
        minDistance = new int[N + 1];
        path = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            Arrays.fill(graph[i], TEMP_MAX);
            path[i] = new ArrayList();
        }

        Arrays.fill(minDistance, TEMP_MAX);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int tempStart = Integer.parseInt(st.nextToken());
            int tempEnd = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[tempStart][tempEnd] = Math.min(graph[tempStart][tempEnd], cost);
        }

        for (int i = 1; i <= N; i++) {
            graph[i][i] = 0;
        }

        st = new StringTokenizer(br.readLine());

        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        dijkstra();

        sb.append(minDistance[end]).append("\n");
        sb.append(path[end].size()).append("\n");
        for (int i = 0; i < path[end].size(); i++) {
            sb.append(path[end].get(i)).append(" ");
        }

        System.out.println(sb);


    }

    static void dijkstra() {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing((o) -> o[1]));

        pq.add(new int[]{start, 0});
        path[start].add(start);

        while (!pq.isEmpty()) {
            int[] data = pq.poll();
            int currentCity = data[0];
            int cost = data[1];

            if (visited[currentCity]) {
                continue;
            }

            visited[currentCity] = true;

            for (int i = 1; i <= N; i++) {
                if (minDistance[i] > cost + graph[currentCity][i] && currentCity != i) {
                    minDistance[i] = cost + graph[currentCity][i];
                    path[i] = new ArrayList<>(path[currentCity]);
                    path[i].add(i);
                    pq.add(new int[]{i, cost + graph[currentCity][i]});
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        solution();
    }

}








