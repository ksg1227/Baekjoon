import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
    단계별로 풀어보기
    스택, 큐, 덱
    9012번 문제: 괄호
 */
public class Main {

    public static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        outer: for(int i=0;i<T;i++) {
            Stack<Integer> stack = new Stack<>();

            String str = br.readLine();

            for(int j=0;j<str.length();j++){
                if(str.charAt(j) == '('){
                    stack.push(1);
                }
                else if(str.charAt(j) == ')'){
                    if(stack.isEmpty()){
                        sb.append("NO").append("\n");
                        continue outer;
                    }
                    stack.pop();
                }
            }

            if(stack.isEmpty()){
                sb.append("YES").append("\n");
            }
            else{
                sb.append("NO").append("\n");
            }
        }

        System.out.println(sb);

    }

    public static void main(String args[]) throws Exception {
        Main.solution();
    }
}
