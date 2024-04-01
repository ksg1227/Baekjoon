import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


/*
    solved.ac
    class2
    10828번 문제 : 스택
 */

public class Main {

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String instruction = st.nextToken();
            if(instruction.equals("push")){
                stack.push(Integer.parseInt(st.nextToken()));
            }else{
                if(instruction.equals("pop")){
                    if(stack.isEmpty()){
                        sb.append(-1).append("\n");
                    }else{
                        sb.append(stack.pop()).append("\n");
                    }
                }else if(instruction.equals("size")){
                    sb.append(stack.size()).append("\n");
                }else if(instruction.equals("empty")){
                    if(stack.isEmpty()){
                        sb.append(1).append("\n");
                    }else{
                        sb.append(0).append("\n");
                    }
                }else if(instruction.equals("top")){
                    if(stack.isEmpty()){
                        sb.append(-1).append("\n");
                    }else{
                        sb.append(stack.peek()).append("\n");
                    }
                }
            }
        }

        System.out.println(sb);


    }


    public static void main(String[] args) throws Exception {
        Main.solution();
    }
}
