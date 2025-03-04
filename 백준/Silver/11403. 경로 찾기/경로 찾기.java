import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
    solved.ac
    class3
    11403번 문제 : 경로 찾기
 */

public class Main {

    static int N;
    static int[][] graph;
    static boolean[] visited;

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        graph = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int connect = Integer.parseInt(st.nextToken());

                graph[i][j] = connect;
            }
        }

        // 열 값을 확인해서, 해당 열의 데이터를 하나하나 조회.
        // 1인 애들만 queue 에 삽입

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                visited = new boolean[N];
                if (findPath(i, j)) {
                    sb.append(1).append(" ");
                } else{
                    sb.append(0).append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

    // 출발점이 도착점인 경우 ->

    static boolean findPath(int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            visited[current] = true;

            for (int i = 0; i < N; i++) {
                if(graph[current][i] == 1) {
                    if(i == end) {
                        return true;
                    }

                    if(!visited[i]) {
                        queue.add(i);
                    }
                }
            }

        }

        return false;
    }


    public static void main(String[] args) throws Exception {
        solution();
    }
}
