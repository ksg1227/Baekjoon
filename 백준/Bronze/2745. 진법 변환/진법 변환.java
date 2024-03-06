import java.io.*;
import java.util.StringTokenizer;


/*  많이 헷갈렸던 문제
    단계별로 풀어보기
    일반 수학1
    1193번 문제: 분수찾기
*/

public class Main {

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        String N = st.nextToken();
        int B = Integer.parseInt(st.nextToken());

        int k = 0;
        int result = 0;

        for (int i = N.length() - 1; i >= 0; i--) {
            int num = Character.getNumericValue(N.charAt(i));
            result += num * Math.pow(B,k);
            k++;
        }

        System.out.println(result);


    }

    public static void main(String args[]) throws Exception {
        new Main().solution();
    }
}
