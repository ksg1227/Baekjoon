import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
    solved.ac
    class3
    11286번 문제 : 절댓값 힙
 */

public class Main {

    static PriorityQueue<Node> pq = new PriorityQueue<>();

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0) {
                if(pq.isEmpty()) {
                    sb.append(0).append("\n");
                } else{
                    Node node = pq.poll();
                    sb.append(node.sign * node.value).append("\n");
                }
            } else {
                if(num < 0) {
                    pq.add(new Node(Math.abs(num), -1));
                } else{
                    pq.add(new Node(Math.abs(num), 1));
                }
            }
        }

        System.out.println(sb);


    }

    static class Node implements Comparable<Node> {
        int value;
        int sign;

        public Node(int value, int sign) {
            this.value = value;
            this.sign = sign;
        }

        @Override
        public int compareTo(Node o) {
            if (this.value == o.value) {
                return this.sign * this.value - o.sign * o.value;
            }

            return this.value - o.value;
        }
    }


    public static void main(String[] args) throws Exception {
        Main.solution();
    }
}
