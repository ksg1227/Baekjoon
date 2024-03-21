import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    단계별로 풀어보기
    재귀
    25501번 문제: 재귀의 귀재
*/

public class Main {

    static int count = 0;

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {

            count = 0;

            String str = br.readLine();

            int result = isPalindrome(str);

            sb.append(result).append(" ").append(count).append("\n");

        }

        System.out.println(sb);

    }


    static int recursion(String str, int l, int r) {

        count++;

        if (l >= r) {
            return 1;
        } else if (str.charAt(l) != str.charAt(r)) {
            return 0;
        } else {
            return recursion(str, l + 1, r - 1);
        }
    }

    static int isPalindrome(String str) {
        return recursion(str, 0, str.length() - 1);
    }

    public static void main(String[] args) throws Exception {
        Main.solution();

    }

}








