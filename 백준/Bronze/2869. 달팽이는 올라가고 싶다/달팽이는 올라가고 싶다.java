import java.io.*;
import java.util.StringTokenizer;


/*
    단계별로 풀어보기
    일반 수학1
    2869번 문제: 달팽이는 올라가고 싶다
*/

public class Main {

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        int count = (V - B) / (A - B);

        if((V - B) % (A - B) != 0){
            count++;
        }


        System.out.println(count);




    }

    public static void main(String args[]) throws Exception {
        new Main().solution();
    }
}
