import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
    단계별로 풀어보기
    스택, 큐, 덱
    24511번 문제: queuestack
 */

public class Main {

    /**
     * 담긴 값이 0 : 큐
     * 담긴 값이 1 : 스택
     */
    static int[] queueStack;
    static Deque<Integer> result = new ArrayDeque<>();

    public static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        queueStack = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            queueStack[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (queueStack[i] == 0) {
                result.addFirst(num);
            }
        }

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            result.addLast(num);
        }

        for (int i = 0; i < M; i++) {
            sb.append(result.pollFirst()).append(" ");
        }

        System.out.println(sb);
    }

    public static void main(String args[]) throws Exception {
        Main.solution();
    }
}
