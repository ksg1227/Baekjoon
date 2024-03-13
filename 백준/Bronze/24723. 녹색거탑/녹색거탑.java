import java.io.*;


/*
    단계별로 풀어보기
    조합론
    24723번 문제: 녹색거탑
*/

public class Main {

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        System.out.println((int)Math.pow(2,N));


    }

    public static void main(String args[]) throws Exception {
        Main.solution();
    }
}


