import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
    solved.ac
    class3
    1003번 문제 : 피보나치 함수
 */

public class Main {

    // bfs

    static boolean[] visited = new boolean[10000];
    static int init;
    static int end;

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());

            Arrays.fill(visited, false);

            init = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());

            String result = bfs(init);

            sb.append(result).append("\n");
        }

        System.out.println(sb);

    }

    static String bfs(int initNum) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(initNum, ""));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int value = node.value;
            String path = node.path;

            if (value == end) {
                return path;
            }

            if (!visited[value]) {
                visited[value] = true;
                queue.add(new Node(D(value), path + "D"));

                queue.add(new Node(S(value), path + "S"));

                queue.add(new Node(L(value), path + "L"));

                queue.add(new Node(R(value), path + 'R'));
            }
        }

        return "";
    }

    static int D(int num) {
        num *= 2;

        if (num > 9999) {
            num %= 10000;
        }

        return num;
    }

    static int S(int num) {

        num -= 1;

        if (num == -1) {
            num = 9999;
        }

        return num;
    }

    static int L(int num) {

        // 첫번째 위치의 숫자를 맨 뒤로
        if (numLength(num) == 4) {
            int first = num / 1000;

            num -= first * 1000;
            num *= 10;
            num += first;

            return num;
        } else { // 무조건 0이 맨 뒤로 붙는 형태
            return num * 10;
        }
    }

    static int R(int num) {
        int last = num % 10;

        num = num / 10;
        num += last * 1000;
        return num;
    }

    static class Node {
        int value;
        String path;

        public Node(int value, String path) {
            this.value = value;
            this.path = path;
        }
    }

    static int numLength(int num) {
        if (num >= 1000) {
            return 4;
        }

        if (num >= 100) {
            return 3;
        }

        if (num >= 10) {
            return 2;
        }

        return 1;
    }


    public static void main(String[] args) throws Exception {
        Main.solution();
    }
}
