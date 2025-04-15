import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int i = 1; i <= 10; i++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());

            char[] password = st.nextToken().toCharArray();

            Stack<Character> stack = new Stack<>();

            for (int j = 0; j < N; j++) {
                if (stack.isEmpty()) {
                    stack.push(password[j]);
                } else {
                    if (stack.peek() == password[j]) {
                        stack.pop();
                    } else {
                        stack.push(password[j]);
                    }
                }
            }

            sb.append("#" + i + " ");

            StringBuilder temp = new StringBuilder();
            while (!stack.isEmpty()) {
                temp.append(stack.pop());
            }

            sb.append(temp.reverse()).append("\n");
        }

        System.out.println(sb);
    }
}
