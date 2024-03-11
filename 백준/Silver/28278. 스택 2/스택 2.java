import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
    단계별로 풀어보기
    스택, 큐, 덱
    28278번 문제: 스택 2
 */
public class Main {

    public static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());


            if (st.countTokens() == 1) {
                int num = Integer.parseInt(st.nextToken());

                if (num == 2) {
                    if (!stack.isEmpty()) {
                        sb.append(stack.pop()).append("\n");
                    } else {
                        sb.append(-1).append("\n");
                    }
                } else if (num == 3) {
                    sb.append(stack.size()).append("\n");
                } else if (num == 4) {
                    if (stack.isEmpty()) {
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                } else if (num == 5) {
                    if (!stack.isEmpty()) {
                        sb.append(stack.peek()).append("\n");
                    } else {
                        sb.append(-1).append("\n");
                    }
                }
            } else {
                int num = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());

                stack.push(value);
            }
        }

        System.out.println(sb);
    }

    public static void main(String args[]) throws Exception {
        Main.solution();
    }
}
