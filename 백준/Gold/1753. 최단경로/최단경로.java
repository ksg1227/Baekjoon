import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 스터디 8주차
 * 다익스트라
 * 백준 1753번 : 최단 경로
 */

public class Main {

    static int INF = 10000000;

    static int V;
    static int E;

    static int start;

    static ArrayList<int[]>[] graph;

    static int[] minDistance;

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        start = Integer.parseInt(br.readLine());

        graph = new ArrayList[V + 1];
        minDistance = new int[V + 1];

        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        Arrays.fill(minDistance, INF);
        minDistance[start] = 0;

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int tempStart = Integer.parseInt(st.nextToken());
            int tempEnd = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            graph[tempStart].add(new int[]{tempEnd, distance});
        }

        dijkstra();

        for (int i = 1; i <= V; i++) {
            if(minDistance[i] == INF) {
                sb.append("INF").append("\n");
            } else{
                sb.append(minDistance[i]).append("\n");
            }
        }

        System.out.println(sb);


    }

    static void dijkstra() {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing((o) -> o[1]));
        pq.add(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] data = pq.poll();
            int vertex = data[0];
            int distance = data[1];

            if (minDistance[vertex] < distance) {
                continue;
            }

            for (int i = 0; i < graph[vertex].size(); i++) {
                int[] next = graph[vertex].get(i);
                if (minDistance[next[0]] > distance + next[1]) {
                    minDistance[next[0]] = distance + next[1];
                    pq.add(new int[]{next[0], minDistance[next[0]]});
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        solution();
    }

}








