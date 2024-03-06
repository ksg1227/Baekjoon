import java.io.*;
import java.util.StringTokenizer;


/*
    단계별로 풀어보기
    2차원 배열
    2738번 문제: 행렬 덧셈
*/

public class Main {

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                arr[i][j] = 0;
            }
        }

        for(int i=0;i<2;i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    arr[j][k] += Integer.parseInt(st.nextToken());
                }
            }
        }

        for(int i=0;i<N;i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<M;j++){
                sb.append(arr[i][j]).append(" ");
            }
            System.out.println(sb);
        }




    }

    public static void main(String args[]) throws Exception {
        new Main().solution();
    }
}

