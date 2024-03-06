import java.io.*;

/*
    단계별로 풀어보기
    문자열
    9086번 문제: 문자열
*/

public class Main {

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++) {
            String str = br.readLine();
            StringBuilder sb = new StringBuilder();
            sb.append(str.charAt(0)).append(str.charAt(str.length()-1));
            System.out.println(sb);
        }

    }

    public static void main(String args[]) throws Exception {
        new Main().solution();
    }
}

