import java.io.*;

/*
    단계별로 풀어보기
    문자열
    27866번 문제: 문자와 문자열
*/

public class Main {

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        
        int i = Integer.parseInt(br.readLine());

        System.out.println(S.charAt(i-1));


    }

    public static void main(String args[]) throws Exception {
        new Main().solution();
    }
}

