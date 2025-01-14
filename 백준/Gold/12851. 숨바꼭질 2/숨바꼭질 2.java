import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 스터디 1주차
 * bfs / dfs
 * 백준 12851번 : 숨바꼭질 2
 */

public class Main {

    static boolean[] visited = new boolean[100001];
    static int fastestTime = -1;
    static int count = 0;

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        bfs(N, K);

        sb.append(fastestTime).append("\n");
        sb.append(count).append("\n");

        System.out.println(sb);

    }

    static void bfs(int N, int K) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{N, 0});
        visited[N] = true;

        if(N == K) {
            fastestTime = 0;
            count = 1;
            return;
        }

        while (!queue.isEmpty()) {
            int[] data = queue.poll();
            int index = data[0];
            int time = data[1];

            if (time >= fastestTime && fastestTime != -1) {    // 이미 여기서 최고 빠른 시간보다 오래 걸린 애들은 걸러짐
                break;
            }

            int nextIndex;

            for (int i = 0; i < 3; i++) {
                if (i == 0) {
                    nextIndex = index - 1;
                } else if (i == 1) {
                    nextIndex = index + 1;
                } else {
                    nextIndex = index * 2;
                }

                if (nextIndex <= 100000 && nextIndex >= 0 && !visited[nextIndex]) {
                    if (nextIndex == K) {
                        if (fastestTime == -1) {
                            fastestTime = time + 1;
                        }
                        count++;
                    } else {
                        visited[index] = true;
                        queue.add(new int[]{nextIndex, time + 1});
                    }
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        solution();
    }

}



