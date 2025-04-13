import java.util.*;
import java.io.*;

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

            int K = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < K; j++) {
                String operation = st.nextToken();

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                int index = x;
                for (int k = 0; k < y; k++) {
                    list.add(index++, st.nextToken());
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
