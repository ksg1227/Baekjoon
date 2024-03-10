import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;


/*
    단계별로 풀어보기
    약수,배수와 소수2
    17103번 문제: 골드바흐 파티션
*/

public class Main {

    static boolean[] prime;

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        ArrayList<Integer> list = new ArrayList<Integer>();

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            list.add(N);

            max = Math.max(max, N);
        }

        fillArr(max);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < list.size(); i++) {
            int num = list.get(i);

            int count = 0;

            for (int j = 2; j <= num / 2; j++) {
                int tempNum = num - j;

                if(prime[j] == true && prime[tempNum] == true){
                    count++;
                }
            }

            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }

    static void fillArr(int max) {
        prime = new boolean[max + 1];

        for (int i = 0; i <= max; i++) {
            prime[i] = true;
        }

        prime[0] = false;
        prime[1] = false;

        for (int i = 2; i <= Math.sqrt(max); i++) {
            if (prime[i] == false) {
                continue;
            }

            for (int j = i * i; j <= max; j += i) {
                prime[j] = false;
            }
        }
    }


    public static void main(String args[]) throws Exception {
        new Main().solution();
    }
}
