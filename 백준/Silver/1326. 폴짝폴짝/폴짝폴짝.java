import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 스터디 1주차
 * bfs / dfs
 * 백준 1326번 : 폴짝폴짝
 */

public class Main {
    // 최소 몇 번 점프가 필요한지를 체크하니 BFS로 탐색 가능.
    // 1을 만난 시점에서는 한 방에 도착 가능

    static int N;
    static int[] num;
    static boolean[] visited;
    static int a;
    static int b;

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        num = new int[N + 1];
        visited = new boolean[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        System.out.println(bfs(a));

    }

    static int bfs(int start) {
        // 왔던 위치로 다시 되돌아가는 경우는 배제해야함!!!!!
        // queue에 저장되는 데이터
        // index 0 : 현재 위치
        // index 1 : 현재 위치에 도달하는데 소요된 횟수
        // index 2 : 현재 위치에 도달하기 이전 위치 -> 무한 반복을 방지하기 위함
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, 0});
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] data = queue.poll();
            int currentIndex = data[0];
            int count = data[1];
            int currentNum = num[currentIndex];

            if (Math.abs((b - currentIndex)) % currentNum == 0) {
                return count + 1;
            } else {
                for (int i = currentIndex - currentNum; i >= 1; i -= currentNum) {
                    if(!visited[i]) {
                        visited[i] = true;
                        queue.add(new int[]{i, count + 1});
                    }
                }

                for (int i = currentIndex + currentNum; i <= N; i += currentNum) {
                    if (!visited[i]) {
                        visited[i] = true;
                        queue.add(new int[]{i, count + 1});
                    }
                }
            }

        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        solution();
    }

}



