import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
    solved.ac
    class2
    7568번 문제 : 덩치
 */

public class Main {

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(br.readLine());

        String str = br.readLine();

        long result = 0;
        int M = 1234567891;

        for (int i = 0; i < L; i++) {
            char c = str.charAt(i);

            long mulNum = 1;

            for(int j=0;j<i;j++){
                mulNum = (mulNum * 31) % M;
            }

            result += (c - 'a' + 1) * mulNum;
        }

        System.out.println(result % M);

    }


    public static void main(String[] args) throws Exception {
        Main.solution();
    }
}
