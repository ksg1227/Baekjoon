import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

/*
    단계별로 풀어보기
    스택, 큐, 덱
    28279번 문제: 덱 2
 */

public class Main {

    public static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Deque<Integer> deque = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int instruction = Integer.parseInt(st.nextToken());

            if (instruction == 1 || instruction == 2) {
                int X = Integer.parseInt(st.nextToken());
                if (instruction == 1) {
                    deque.addFirst(X);
                } else {
                    deque.addLast(X);
                }
            } else {
                switch(instruction) {
                    case 3:{
                        if(deque.isEmpty()){
                            sb.append(-1).append("\n");
                        }else{
                            sb.append(deque.pollFirst()).append("\n");
                        }
                        continue;
                    }
                    case 4:{
                        if(deque.isEmpty()){
                            sb.append(-1).append("\n");
                        }else{
                            sb.append(deque.pollLast()).append("\n");
                        }
                        continue;
                    }
                    case 5:{
                        sb.append(deque.size()).append("\n");
                        continue;
                    }
                    case 6:{
                        if(deque.isEmpty()){
                            sb.append(1).append("\n");
                        }else{
                            sb.append(0).append("\n");
                        }
                        continue;
                    }
                    case 7:{
                        if(deque.isEmpty()){
                            sb.append(-1).append("\n");
                        }
                        else{
                            sb.append(deque.peekFirst()).append("\n");
                        }
                        continue;
                    }
                    case 8:{
                        if(deque.isEmpty()){
                            sb.append(-1).append("\n");
                        }
                        else{
                            sb.append(deque.peekLast()).append("\n");
                        }
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
