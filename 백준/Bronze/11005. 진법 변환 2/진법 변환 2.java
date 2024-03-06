import java.io.*;
import java.util.StringTokenizer;


/*  많이 헷갈렸던 문제
    단계별로 풀어보기
    일반 수학1
    11005번 문제: 진법 변환2
*/

public class Main {

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int k = 0;    //자릿수

        while (true) {
            if (Math.pow(B, k) > N) {
                break;
            }
            k++;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = k - 1; i >= 0; i--) {
            int num = (int)(N/Math.pow(B,i));
            N -= Math.pow(B,i) * num;

            //num만 출력하면 됨
            if(num >= 10){
                sb.append((char)('A' - 10 + num));
            }
            else{
                sb.append(num);
            }
        }

        System.out.println(sb);



    }

    public static void main(String args[]) throws Exception {
        new Main().solution();
    }
}
