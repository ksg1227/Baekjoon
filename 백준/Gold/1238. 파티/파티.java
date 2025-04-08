import java.io.*;
import java.util.*;

/*
    solved.ac
    class4
    1238번 문제 : 파티
 */
public class Main {

    static int N;
    static int X;
    static int M;

    static List<Node>[] graph;

    // 현재 도시에서 다른 도시까지 도달하는 데 걸리는 최소 거리
    static int[] minDistance;

    static int maxTime = Integer.MIN_VALUE;

    // 다익스트라.
    // if(minDistance[i] < distance)
    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        minDistance = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            graph[start].add(new Node(dest, value));
        }

        for (int i = 1; i <= N; i++) {
            dijkstra(i);

            int time = 0;

            time += minDistance[X];

            dijkstra(X);

            time += minDistance[i];

            maxTime = Math.max(time, maxTime);
        }

        System.out.println(maxTime);

    }

    // 특정 정점까지 도달하는 데 걸리는 거리
    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        clearMinDistance(start);

        pq.add(new Node(start, 0));
        minDistance[start] = 0;

        while (!pq.isEmpty()) {
            Node edge = pq.poll();

            int destination = edge.destination;
            int value = edge.value;

            if (minDistance[destination] < value) {
                continue;
            }

            for (int i = 0; i < graph[destination].size(); i++) {
                Node nextNode = graph[destination].get(i);
                int nextDest = nextNode.destination;
                if (minDistance[nextDest] > value + nextNode.value) {
                    minDistance[nextDest] = value + nextNode.value;
                    pq.add(new Node(nextDest, minDistance[nextDest]));
                }
            }
        }

    }

    // 목적지 노드랑, 해당 노드까지 가는데 필요한 비용
    static class Node implements Comparable<Node> {
        int destination;
        int value;

        Node(int destination, int value) {
            this.destination = destination;
            this.value = value;
        }

        @Override
        public int compareTo(Node e) {
            return this.value - e.value;
        }
    }

    static void clearMinDistance(int start) {
        Arrays.fill(minDistance, 100 * M + 1);
    }

    // 다익스트라 - 간선에 가중치가 존재하므로
    public static void main(String[] args) throws IOException {
        solution();
    }
}
