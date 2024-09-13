import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
    단계별로 풀어보기
    그래프와 순회
    16928번 문제: 뱀과 사다리 게임
*/

public class Main {

    static int[] visited = new int[101];

    static Queue<int[]> queue = new LinkedList<>();

    static HashMap<Integer, Integer> ladder = new HashMap<>();
    static HashMap<Integer, Integer> snake = new HashMap<>();

    static int N;
    static int M;


    //만약 배열에서 i = 홀수 위치에 있다면 오른쪽으로 이동
    //i = 짝수 위치에 있다면 왼쪽으로 이동

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int max = Math.max(x, y);
            int min = Math.min(x, y);

            ladder.put(min, max);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            int max = Math.max(u, v);
            int min = Math.min(u, v);

            snake.put(max, min);
        }

        System.out.println(bfs());

    }

    public static int bfs() {

        queue.add(new int[]{1, 0});
        visited[1] = 1;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            int current_pos = poll[0];
            int depth = poll[1];

            for (int i = 1; i <= 6; i++) {
                int next_pos = current_pos + i;
                if (next_pos <= 100) {
                    if (next_pos == 100) {
                        return depth + 1;
                    } else {
                        if (ladder.containsKey(next_pos)) {
                            next_pos = ladder.get(next_pos);

                            if (visited[next_pos] == 0) {
                                queue.add(new int[]{next_pos, depth + 1});
                                visited[next_pos] = 1;
                            }

                            continue;
                        }

                        if (snake.containsKey(next_pos)) {
                            next_pos = snake.get(next_pos);

                            if (visited[next_pos] == 0) {
                                queue.add(new int[]{next_pos, depth + 1});
                                visited[next_pos] = 1;
                            }

                            continue;
                        }

                        if(visited[next_pos] == 0){
                            queue.add(new int[]{next_pos, depth + 1});
                            visited[next_pos] = 1;
                        }

                    }
                }
            }
        }

        return -1;
    }


    public static void main(String args[]) throws Exception {
        Main.solution();
    }
}

