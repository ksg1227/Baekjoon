import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    단계별로 풀어보기
    재귀
    24060번 문제: 알고리즘 수업 - 병합 정렬 1
*/

public class Main {

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input;
        while ((input = br.readLine()) != null) {
            int N = Integer.parseInt(input);

            if (N != 0) {
                StringBuilder sb = new StringBuilder();

                for (int i = 0; i < Math.pow(3, N); i++) {
                    sb.append("-");
                }

                System.out.println(retStr(sb));

            } else {
                System.out.println("-");
            }
            
        }

    }

    static StringBuilder retStr(StringBuilder sb) {

        if(sb.length() > 1) {
            StringBuilder left = new StringBuilder();
            StringBuilder middle = new StringBuilder();
            StringBuilder right = new StringBuilder();

            for (int i = 0; i < sb.length(); i++) {
                if (i < sb.length() / 3) {
                    left.append("-");
                } else if (i >= (sb.length() / 3) * 2) {
                    right.append("-");
                } else {
                    middle.append(" ");
                }
            }

            left = retStr(left);
            right = retStr(right);

            return new StringBuilder(left.append(middle).append(right));

        } else{
            return new StringBuilder("-");
        }
    }

    public static void main(String[] args) throws Exception {
        Main.solution();

    }

}








