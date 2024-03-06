import java.io.*;
import java.util.StringTokenizer;

/*
    단계별로 풀어보기
    문자열
    2908번 문제: 상수
*/

public class Main {

    static String swap(String str){
        String first = Character.toString(str.charAt(0));
        String third = Character.toString(str.charAt(2));

        String newstr = third + str.charAt(1) + first;

        return newstr;
    }

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        String num1 = st.nextToken();
        String num2 = st.nextToken();

        num1 = swap(num1);
        num2 = swap(num2);

        int result = Math.max(Integer.parseInt(num1), Integer.parseInt(num2));

        System.out.println(result);

    }

    public static void main(String args[]) throws Exception {
        new Main().solution();
    }
}

