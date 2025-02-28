import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
    solved.ac
    class3
    5430번 문제 : AC
 */

public class Main {

    static int T;
    static String p;

    static int n;

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            Deque<Integer> deque = new LinkedList<>();
            p = br.readLine();
            n = Integer.parseInt(br.readLine());

            st = new StringTokenizer(parseString(br.readLine(), n), ",");

            for (int j = 0; j < n; j++) {
                deque.add(Integer.parseInt(st.nextToken()));
            }

            // fromFront = true 이면 뒤집히지 않은 상태
            // fromFront = false 이면 뒤집힌 상태
            boolean fromFront = true;

            boolean isError = false;

            for (int j = 0; j < p.length(); j++) {
                char function = p.charAt(j);

                if (function == 'R') {
                    fromFront = !fromFront;
                } else {
                    if (deque.isEmpty()) {
                        isError = true;
                        break;
                    }
                    if (fromFront) {
                        deque.pollFirst();
                    } else {
                        deque.pollLast();
                    }
                }
            }

            if (isError) {
                sb.append("error").append("\n");
            } else {
                if (fromFront) {
                    sb.append("[");
                    while (true) {
                        if (deque.isEmpty()) {
                            break;
                        }
                        sb.append(deque.pollFirst());
                        if (deque.isEmpty()) {
                            break;
                        } else {
                            sb.append(",");
                        }
                    }
                    sb.append("]").append("\n");
                } else {
                    sb.append("[");
                    while (true) {
                        if(deque.isEmpty()) {
                            break;
                        }
                        sb.append(deque.pollLast());
                        if (deque.isEmpty()) {
                            break;
                        } else {
                            sb.append(",");
                        }
                    }
                    sb.append("]").append("\n");
                }
            }

        }

        System.out.println(sb);

    }

    static String parseString(String input, int length) {
        if (length > 0) {
            return input.substring(1, input.length() - 1);
        } else {
            return "";
        }

    }


    public static void main(String[] args) throws Exception {
        Main.solution();
    }
}
