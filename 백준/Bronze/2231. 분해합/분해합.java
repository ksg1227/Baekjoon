import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
    단계별로 풀어보기
    브루트포스
    2231번 문제: 분해합
*/

public class Main {

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String N = br.readLine();

        int result = 0;

        for (int i = 1; i < Integer.parseInt(N); i++) {
            int total = i;

            String num = Integer.toString(i);

            for (int j = 0; j < num.length(); j++) {
                total += Character.getNumericValue(num.charAt(j));
            }

            if(total == Integer.parseInt(N)){
                result = i;
                break;
            }
        }

        System.out.println(result);


    }

    public static void main(String args[]) throws Exception {
        new Main().solution();
    }
}


