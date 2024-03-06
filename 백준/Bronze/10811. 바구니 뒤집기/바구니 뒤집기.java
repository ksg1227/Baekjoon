import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/*
    단계별로 풀어보기
    1차원 배열
    10811번 문제: 바구니 뒤집기
*/

public class Main {

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            arr.add(i);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int last = Integer.parseInt(st.nextToken());

            while (last > first) {
                Collections.swap(arr, first-1, last-1);
                first++;
                last--;
            }

        }

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<arr.size();i++){
            sb.append(arr.get(i));
            sb.append(" ");
        }

        System.out.println(sb);


    }

    public static void main(String args[]) throws Exception {
        new Main().solution();
    }
}
