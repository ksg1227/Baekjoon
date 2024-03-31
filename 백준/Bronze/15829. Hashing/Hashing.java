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

            result += (long) (((c - 'a' + 1) * Math.pow(31, i))) % M;
        }

        System.out.println(result);

    }


    public static void main(String[] args) throws Exception {
        Main.solution();
    }
}
