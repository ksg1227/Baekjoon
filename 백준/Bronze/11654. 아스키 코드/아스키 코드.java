import java.io.*;

/*
    단계별로 풀어보기
    문자열
    9086번 문제: 문자열
*/

public class Main {

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        byte num = (byte)br.readLine().charAt(0);

        System.out.println(num);

    }

    public static void main(String args[]) throws Exception {
        new Main().solution();
    }
}

