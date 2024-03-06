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

        StringTokenizer st;
        String str;

        while(!(str = br.readLine()).equals("0 0")){

            st = new StringTokenizer(str);

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            
            System.out.println(A+B);
        }

    }

    public static void main(String args[]) throws Exception {
        new Main().solution();
    }
}
