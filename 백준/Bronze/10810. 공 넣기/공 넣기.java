import java.io.*;
import java.util.StringTokenizer;


/*
    단계별로 풀어보기
    1차원 배열
    10810번 문제: 공넣기
*/

public class Main {

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = 0;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int last = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            for (int j = first - 1; j < last; j++) {
                arr[j] = k;
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<N;i++){
            sb.append(arr[i]);
            sb.append(" ");
        }

        System.out.println(sb);


    }

    public static void main(String args[]) throws Exception {
        new Main().solution();
    }
}
