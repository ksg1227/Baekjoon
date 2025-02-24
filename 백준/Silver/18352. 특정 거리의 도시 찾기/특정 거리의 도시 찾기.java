import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 스터디 8주차
 * 다익스트라
 * 백준 1446번 : 지름길
 */

public class Main {

    // 거리를 다 합쳐도 300000 만임.
    // Integer.MAX_VALUE로 값을 설정하니까 오버플로우가 남

    static int TEMP_MAX = 10000000;

    // 다익스트라의 정석 문제
    static int N;
    static int M;
    static int K;
    static int X;

    // 인접 그래프 -> 이렇게 해도 30만 바이트 * 30만 바이트
//    static char[][] graph;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    // 방문 여부를 추적하기 위한 배열
    static boolean[] visited;

    // dp를 위한 배열 -> 시작점에서 도착점까지 걸리는 최소 거리
    static int[] minDistance;

    static ArrayList<Integer> result = new ArrayList<>();


    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        minDistance = new int[N + 1];

        // list 초기화
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 연결된 애들만 저장
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph.get(A).add(B);
        }

        bfs();

        Collections.sort(result);

        if(result.size() == 0) {
            System.out.println(-1);
        } else{
            for(int i=0;i<result.size();i++) {
                sb.append(result.get(i)).append("\n");
            }

            System.out.println(sb);
        }

    }

    static void bfs() {
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{X, 0});
        visited[X] = true;

        while (!queue.isEmpty()) {
            int[] data = queue.poll();
            int current = data[0];
            int currentDepth = data[1];

            if(currentDepth == K) {
                result.add(current);
                continue;
            }

            for (int i = 0; i < graph.get(current).size(); i++) {
                int nextCity = graph.get(current).get(i);

                if (!visited[nextCity]) {
                    visited[nextCity] = true;
                    queue.add(new int[]{nextCity, currentDepth + 1});
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        solution();
    }

}








