import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    단계별로 풀어보기
    심화 1단계
    10988번 문제: 팰린드롬인지 확인하기
*/

public class Main {

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        boolean flag = true;
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
                flag = false;
            }
        }

        if (flag) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }


    }

    public static void main(String args[]) throws Exception {
        new Main().solution();
    }
}





