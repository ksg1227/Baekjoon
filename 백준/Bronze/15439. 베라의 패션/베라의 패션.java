import java.io.*;


/*
    단계별로 풀어보기
    조합론
    15439번 문제: 베라의 패션
*/

public class Main {

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        System.out.println(N * (N - 1));


    }

    public static void main(String args[]) throws Exception {
        Main.solution();
    }
}


