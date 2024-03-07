import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;


/*
    단계별로 풀어보기
    약수,배수와 소수2
    4143번 문제: 다음 소수
*/

public class Main {

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<T;i++){
            BigInteger n = new BigInteger(br.readLine());
            if(n.isProbablePrime(10)){
                sb.append(n).append("\n");
            }
            else{
                sb.append(n.nextProbablePrime()).append("\n");
            }
        }

        
        System.out.println(sb);


    }


    public static void main(String args[]) throws Exception {
        new Main().solution();
    }
}
