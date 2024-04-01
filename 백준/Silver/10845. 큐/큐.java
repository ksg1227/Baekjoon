import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;


/*
    solved.ac
    class2
    10845번 문제 : 큐
 */

public class Main {

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        Queue<Integer> queue = new LinkedList<>();

        int recentNum = -1; //빈 상태

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String instruction = st.nextToken();
            if(instruction.equals("push")){
                int num = Integer.parseInt(st.nextToken());
                recentNum = num;
                queue.add(num);
            }else{
                if(instruction.equals("pop")){
                    if(queue.isEmpty()){
                        sb.append(-1).append("\n");
                    }else{
                        sb.append(queue.poll()).append("\n");
                    }
                }else if(instruction.equals("size")){
                    sb.append(queue.size()).append("\n");
                }else if(instruction.equals("empty")){
                    if(queue.isEmpty()){
                        sb.append(1).append("\n");
                    }else{
                        sb.append(0).append("\n");
                    }
                }else if(instruction.equals("front")){
                    if(queue.isEmpty()){
                        sb.append(-1).append("\n");
                    }else{
                        sb.append(queue.peek()).append("\n");
                    }
                }else if(instruction.equals("back")){
                    if(queue.isEmpty()){
                        sb.append(-1).append("\n");
                    }else{
                        sb.append(recentNum).append("\n");
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
