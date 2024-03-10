import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


/*
    단계별로 풀어보기
    약수,배수와 소수2
    4948번 문제: 베르트랑 공준
*/

public class Main {

    static boolean[] prime;

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> nlist = new ArrayList<>();

        String str = "";

        int max = Integer.MIN_VALUE;
        while (!((str = br.readLine()).equals("0"))) {
            int num = Integer.parseInt(str);

            nlist.add(num);

            max = Math.max(max, num);
        }

        fillArr(max);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < nlist.size(); i++) {
            int num = nlist.get(i);

            int count = 0;

            for (int j = num + 1; j <= num * 2; j++) {
                if (prime[j] == true) {
                    count++;
                }
            }

            sb.append(count).append("\n");

        }

        System.out.println(sb);


    }

    static void fillArr(int max) {
        prime = new boolean[2 * max + 1];

        for (int i = 0; i <= 2 * max; i++) {
            prime[i] = true;
        }

        prime[0] = false;
        prime[1] = false;

        for (int i = 2; i <= Math.sqrt(2 * max); i++) {

            if (prime[i] == false) {
                continue;
            }

            for (int j = i * i; j <= 2 * max; j += i) {
                prime[j] = false;
            }
        }

    }


    public static void main(String args[]) throws Exception {
        new Main().solution();
    }
}
