import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

    static PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

    static int N;

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            int tempNum = Integer.parseInt(br.readLine());
            if(tempNum == 0) {
                if(queue.isEmpty()) {
                    sb.append(0).append("\n");
                } else{
                    sb.append(queue.poll()).append("\n");
                }
            } else{
                queue.add(tempNum);
            }
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        Main.solution();
    }
}
