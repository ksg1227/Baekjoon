import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String input = bf.readLine();

        Stack<String> stack = new Stack<>();

        int count = 0;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                stack.push("(");
                count++;
            } else if (input.charAt(i) == ')') {
                if (input.charAt(i - 1) == '(') {
                    stack.pop();
                    count--;
                    count += stack.size();
                } else {
                    stack.pop();
                }
            }
        }

        System.out.println(count);


    }
}
