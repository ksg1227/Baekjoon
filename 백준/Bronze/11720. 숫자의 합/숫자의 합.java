import java.io.*;

/*
    단계별로 풀어보기
    문자열
    11720번 문제: 숫자의 합
*/

public class Main {

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String str = br.readLine();

        int sum = 0;

        for(int i=0;i<N;i++){
            sum += Character.getNumericValue(str.charAt(i));
        }

        System.out.println(sum);






    }

    public static void main(String args[]) throws Exception {
        new Main().solution();
    }
}

