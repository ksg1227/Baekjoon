import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
    단계별로 풀어보기
    스택, 큐, 덱
    18258번 문제: 큐 2
 */

public class Main {

    public static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        Deque<Integer> deque = new LinkedList<>();


        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String instruction = st.nextToken();

            if(instruction.equals("push")){
                int X = Integer.parseInt(st.nextToken());

                deque.add(X);
            }
            else{
                if(instruction.equals("pop")){
                    if(deque.isEmpty()){
                        sb.append(-1).append("\n");
                    }
                    else{
                        sb.append(deque.poll()).append("\n");
                    }
                }
                else if(instruction.equals("size")){
                    sb.append(deque.size()).append("\n");
                }
                else if(instruction.equals("empty")){
                    if(deque.isEmpty()){
                        sb.append(1).append("\n");
                    }
                    else{
                        sb.append(0).append("\n");
                    }
                }
                else if(instruction.equals("front")){
                    if(deque.isEmpty()){
                        sb.append(-1).append("\n");
                    }
                    else {
                        sb.append(deque.peek()).append("\n");
                    }
                }
                else if(instruction.equals("back")){
                    if(deque.isEmpty()){
                        sb.append(-1).append("\n");
                    }
                    else{
                        sb.append(deque.getLast()).append("\n");
                    }
                }

            }
        }

        System.out.println(sb);
    }

    public static void main(String args[]) throws Exception {
        Main.solution();
    }
}
