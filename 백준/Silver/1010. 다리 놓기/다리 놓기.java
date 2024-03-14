import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;


/*
    단계별로 풀어보기
    조합론
    10872번 문제: 팩토리얼
*/

public class Main {

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            BigInteger N = new BigInteger(st.nextToken());
            BigInteger M = new BigInteger(st.nextToken());

            BigInteger result = new BigInteger("1");

            int tempN = N.intValue();

            for (int j = 0; j < N.intValue(); j++) {
                result = result.multiply(M);

                M = M.subtract(BigInteger.valueOf(1));
            }

            for(int j=1;j<=N.intValue();j++){
                result = result.divide(BigInteger.valueOf(j));
            }

            System.out.println(result);


        }
    }

    public static void main(String args[]) throws Exception {
        Main.solution();
    }
}


