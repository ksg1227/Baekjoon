import java.io.*;


/*
    단계별로 풀어보기
    조합론
    10872번 문제: 팩토리얼
*/

public class Main {

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int result = 1;

        if(N == 0){
            System.out.println(1);
        }
        else {
            for (int i = N; i >= 1; i--) {
                result *= i;
            }

            System.out.println(result);
        }


    }

    public static void main(String args[]) throws Exception {
        Main.solution();
    }
}


