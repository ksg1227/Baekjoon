import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
    단계별로 풀어보기
    스택, 큐, 덱
    2164번 문제: 카드 2
 */

public class Main {

    public static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Queue<Integer> queue = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        while(queue.size() > 1){
            queue.poll();

            queue.offer(queue.poll());
        }

        System.out.println(queue.poll());
    }

    public static void main(String args[]) throws Exception {
        Main.solution();
    }
}
