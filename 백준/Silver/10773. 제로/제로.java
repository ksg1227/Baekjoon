import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
    단계별로 풀어보기
    스택, 큐, 덱
    10773번 문제: 제로
 */
public class Main {

    public static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < K; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num != 0) {
                stack.push(num);
            } else {
                stack.pop();
            }
        }

        int result = 0;

        while(!stack.isEmpty()){
            result += stack.pop();
        }

        System.out.println(result);

    }

    public static void main(String args[]) throws Exception {
        Main.solution();
    }
}
