import java.io.*;
import java.util.*;


/*
    D3 - 1230
 */
public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= 10; i++) {
            int N = Integer.parseInt(br.readLine());

            List<String> list = new LinkedList<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                list.add(st.nextToken());
            }

            int M = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                String operation = st.nextToken();

                if (operation.equals("I")) {

                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());

                    int index = x;

                    for (int k = 0; k < y; k++) {
                        String s = st.nextToken();
                        list.add(index++, s);
                    }

                } else if (operation.equals("D")) {

                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());

                    for (int k = 0; k < y; k++) {
                        list.remove(x);
                    }

                } else {
                    int y = Integer.parseInt(st.nextToken());

                    for (int k = 0; k < y; k++) {
                        String s = st.nextToken();

                        list.add(s);
                    }

                }
            }

            sb.append("#" + i + " ");

            for (int j = 0; j < 10; j++) {
                sb.append(list.get(j)).append(" ");
            }

            sb.append("\n");

        }

        System.out.println(sb);

    }
}
