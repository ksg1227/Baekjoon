import java.io.*;
import java.util.StringTokenizer;


/*
    단계별로 풀어보기
    1차원 배열
    10818번 문제: 최소, 최대
*/

public class Main {

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];

        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = -1000000, min = 1000000;

        for(int i=0;i<N;i++){
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }

        StringBuilder sb = new StringBuilder();

        sb.append(min);
        sb.append(" ");
        sb.append(max);

        System.out.println(sb);


    }

    public static void main(String args[]) throws Exception {
        new Main().solution();
    }
}
