import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;


/*
    단계별로 풀어보기
    1차원 배열
    10871번 문제: X보다 작은 수
*/

public class Main {

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            int num = Integer.parseInt(st.nextToken());
            if(num < X){
                sb.append(num);
                sb.append(" ");
            }
        }

        System.out.println(sb);

    }

    public static void main(String args[]) throws Exception {
        new Main().solution();
    }
}
