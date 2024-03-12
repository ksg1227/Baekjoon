import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int totalToken = st.countTokens();

        int[] arr = new int[totalToken + 1];

        for (int i = 1; i <= totalToken; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            deque.add(i);
        }

        int index = 0;

        while (!deque.isEmpty()) {

            if (deque.size() == N) {
                sb.append(deque.pollFirst()).append(" ");

                index = arr[1];
            } else {

                if (index > 0) {
                    for (int j = 0; j < index - 1; j++) {
                        deque.offerLast(deque.pollFirst());
                    }

                    int num = deque.removeFirst();

                    sb.append(num).append(" ");

                    index = arr[num];

                } else if (index < 0) {
                    for (int j = 0; j < Math.abs(index) - 1; j++) {
                        deque.offerFirst(deque.pollLast());
                    }

                    int num = deque.removeLast();

                    sb.append(num).append(" ");

                    index = arr[num];
                }

            }

        }

        System.out.println(sb);


    }

    public static void main(String args[]) throws Exception {
        Main.solution();
    }
}
