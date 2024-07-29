import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
    solved.ac
    class3
    1697번 문제 : 숨바꼭질
 */

public class Main {

    static int N;
    static int K;

    static Queue<Integer> queue = new LinkedList<>();
    static boolean[] visit;
    static int[] count;

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visit = new boolean[200001];
        count = new int[200001];

        count[N] = 0;

        bfs(N);

        System.out.println(count[K]);

    }

    static void bfs(int start) {
        queue.add(start);
        visit[start] = true;

        while (!queue.isEmpty()) {

            int current = queue.poll();

            if (current == K) {
                return;
            }

            if (current == 0) {
                if (!visit[current + 1]) {
                    queue.add(current + 1);
                    visit[current + 1] = true;
                    count[current + 1] = count[current] + 1;
                }

                continue;
            }

            if (current > K) {
                if (!visit[current - 1]) {
                    queue.add(current - 1);
                    visit[current - 1] = true;
                    count[current - 1] = count[current] + 1;
                }

                continue;
            }


            if (!visit[current - 1]) {
                queue.add(current - 1);
                visit[current - 1] = true;
                count[current - 1] = count[current] + 1;
            }

            if (!visit[current + 1]) {
                queue.add(current + 1);
                visit[current + 1] = true;
                count[current + 1] = count[current] + 1;
            }

            if (!visit[current * 2]) {
                queue.add(current * 2);
                visit[current * 2] = true;
                count[current * 2] = count[current] + 1;
            }

        }
    }

    public static void main(String[] args) throws Exception {
        Main.solution();
    }

}




