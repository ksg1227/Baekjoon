import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
    단계별로 풀어보기
    스택, 큐, 덱
    12789번 문제: 도키도키 간식드리미
 */

public class Main {

    public static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        Stack<Integer> stack = new Stack<>();

        boolean success = true;

        int ticketNum = 1;

        int totalToken = st.countTokens();

        for (int i = 0; i < totalToken; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (num != ticketNum) {
                if (!stack.isEmpty()) {
//                    if(stack.peek() == ticketNum){
//                        stack.pop();
//                        ticketNum++;
//                    }
//                    else{
//                        stack.push(num);
//                    }

                    while (!stack.isEmpty() && stack.peek() == ticketNum) {
                        stack.pop();
                        ticketNum++;
                    }

                    stack.push(num);
                } else {
                    stack.push(num);
                }
            } else {
                ticketNum++;
            }
        }

        if (!stack.isEmpty()) {
            int temp = stack.size();

            for (int i = 0; i < temp; i++) {
                if (stack.pop() == ticketNum) {
                    ticketNum++;
                } else {
                    success = false;
                    break;
                }
            }
        }

        if (success) {
            System.out.println("Nice");
        } else {
            System.out.println("Sad");
        }
    }

    public static void main(String args[]) throws Exception {
        Main.solution();
    }
}
