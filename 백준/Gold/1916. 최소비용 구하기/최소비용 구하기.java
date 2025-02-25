import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 스터디 8주차
 * 다익스트라
 * 백준 1446번 : 지름길
 */

public class Main {

    // N이 최대 1,000 이라 인접 그래프 형태를 활용해도 시간 복잡도를 넘지 않음
    // 방향 그래프 형태

    static int[][] graph;

    // 출발점에서 각 점까지의 거리
    static long[] minDistance;

    static boolean[] visited;

    static int N;
    static int M;

    static int start;
    static int end;

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new int[N + 1][N + 1];
        minDistance = new long[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            Arrays.fill(graph[i], Integer.MAX_VALUE);
        }

        Arrays.fill(minDistance, Integer.MAX_VALUE);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int tempStart = Integer.parseInt(st.nextToken());
            int tempEnd = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            graph[tempStart][tempEnd] = Math.min(distance, graph[tempStart][tempEnd]);
        }

        for (int i = 1; i <= N; i++) {
            graph[i][i] = 0;
        }

        st = new StringTokenizer(br.readLine());

        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            minDistance[i] = graph[start][i];
        }

        dijkstra();

        System.out.println(minDistance[end]);

    }

    static void dijkstra() {

        visited[start] = true;

        for (int i = 1; i < N; i++) {
            int currentCity = findCurrentCity();
            
            if(currentCity == -1) {
                return;
            }

            visited[currentCity] = true;

            for (int j = 1; j <= N; j++) {
                minDistance[j] = Math.min(minDistance[currentCity] + graph[currentCity][j], minDistance[j]);
            }
        }
    }

    static int findCurrentCity() {
        long currentMin = Integer.MAX_VALUE;
        int minCity = -1;

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                if (currentMin > minDistance[i]) {
                    currentMin = minDistance[i];
                    minCity = i;
                }
            }
        }

        return minCity;
    }


    public static void main(String[] args) throws IOException {
        solution();
    }

}








