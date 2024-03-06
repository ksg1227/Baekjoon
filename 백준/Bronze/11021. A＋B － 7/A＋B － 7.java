import java.awt.image.DataBufferDouble;
import java.io.*;
import java.util.StringTokenizer;


/*
    단계별로 풀어보기
    반복문
    11021번 문제: A+B - 7
*/

public class Main {

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            bw.write("Case #" + (i+1) + ": " + (A+B) + "\n");

        }

        bw.close();


    }

    public static void main(String args[]) throws Exception {
        new Main().solution();
    }
}
