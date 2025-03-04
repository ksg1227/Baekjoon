import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
    solved.ac
    class3
    1003번 문제 : 피보나치 함수
 */

public class Main {

    static boolean[] set = new boolean[21];

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            String operation = st.nextToken();
            int num = 0;

            if (operation.equals("add")) {
                num = Integer.parseInt(st.nextToken());
                if (!set[num]) {
                    set[num] = true;
                }
            } else if (operation.equals("remove")) {
                num = Integer.parseInt(st.nextToken());
                if (set[num]) {
                    set[num] = false;
                }
            } else if (operation.equals("check")) {
                num = Integer.parseInt(st.nextToken());
                if (set[num]) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            } else if (operation.equals("toggle")) {
                num = Integer.parseInt(st.nextToken());
                set[num] = !set[num];
            } else if (operation.equals("all")) {
                Arrays.fill(set, true);
            } else {
                Arrays.fill(set, false);
            }
        }

        System.out.println(sb);

    }


    public static void main(String[] args) throws Exception {
        Main.solution();
    }
}
