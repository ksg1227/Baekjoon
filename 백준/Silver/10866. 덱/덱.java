import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/*
    solved.ac
    class2
    10866번 문제 : 덱
 */

public class Main {

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        ArrayDeque<Integer> deque = new ArrayDeque<>();

        int recentNum = -1; //빈 상태

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String instruction = st.nextToken();
            
            if(instruction.equals("push_front")){
                deque.addFirst(Integer.parseInt(st.nextToken()));
            }else if(instruction.equals("push_back")){
                deque.addLast(Integer.parseInt(st.nextToken()));
            }else{
                if(instruction.equals("pop_front")){
                    if(deque.isEmpty()){
                        sb.append(-1).append("\n");
                    }else{
                        sb.append(deque.pollFirst()).append("\n");
                    }
                }else if(instruction.equals("pop_back")){
                    if(deque.isEmpty()){
                        sb.append(-1).append("\n");
                    }else{
                        sb.append(deque.pollLast()).append("\n");
                    }
                }else if(instruction.equals("size")){
                    sb.append(deque.size()).append("\n");
                }else if(instruction.equals("empty")){
                    if(deque.isEmpty()){
                        sb.append(1).append("\n");
                    }else{
                        sb.append(0).append("\n");
                    }
                }else if(instruction.equals("front")){
                    if(deque.isEmpty()){
                        sb.append(-1).append("\n");
                    }else{
                        sb.append(deque.peekFirst()).append("\n");
                    }
                }else if(instruction.equals("back")){
                    if(deque.isEmpty()){
                        sb.append(-1).append("\n");
                    }else{
                        sb.append(deque.peekLast()).append("\n");
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
