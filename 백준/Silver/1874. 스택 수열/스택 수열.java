import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;


/*
    solved.ac
    class2
    1874번 문제 : 스택 수열
 */

public class Main {

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        Stack<Integer> st = new Stack<>();

        StringBuilder sb = new StringBuilder();

        int stringIndex = 0;

        outer:for (int i = 1; i <= n; i++) {
            st.push(i);
            sb.append("+").append("\n");
            while(!st.isEmpty() && list.get(stringIndex).equals(st.peek())){
                st.pop();
                sb.append("-").append("\n");
                stringIndex++;
                if(stringIndex == n){
                    break outer;
                }
            }


        }

        if(stringIndex == n){
            System.out.println(sb);
        }else{
            System.out.println("NO");
        }

    }

    public static void main(String[] args) throws Exception {
        Main.solution();
    }
}
