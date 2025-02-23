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

    static int N;
    static int D;
    static int[][] road;
    static int[] minDistance;

    // D를 넘어가면 안됨
    // 특정 지점까지의 최단 거리를 계속해서 추적하면 될 듯

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        // 0 : 시작 위치
        // 1 : 도착 위치
        // 2 : 지름길 길이
        road = new int[N][3];
        minDistance = new int[D + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            road[i][0] = Integer.parseInt(st.nextToken());
            road[i][1] = Integer.parseInt(st.nextToken());
            road[i][2] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(road, (o1, o2) -> {
            return o1[0] - o2[0];
        });

        // 운전해야하는 거리 초기화
        for (int i = 0; i <= D; i++) {
            minDistance[i] = i;
        }

        dijkstra();

        System.out.println(minDistance[D]);

    }

    static void dijkstra() {
        for (int i = 0; i < N; i++) {
            int start = road[i][0];
            int end = road[i][1];
            int distance = road[i][2];

            if (end <= D && (end - start) > distance) {
                int newCase = minDistance[start] + distance;

                // 이번에 거쳐가는 경우가 최소인 경우에만 그 뒤의 경우들을 갱신하면 됨
                if (minDistance[end] > newCase) {
                    for (int j = end; j <= D; j++) {
                        minDistance[j] = Math.min(minDistance[j], newCase + j - end);
                    }
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        solution();
    }

}








