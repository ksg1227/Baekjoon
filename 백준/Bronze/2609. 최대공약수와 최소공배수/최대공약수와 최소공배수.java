import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;


/*
    단계별로 풀어보기
    약수,배수와 소수2 (번외문제)
    2609번 문제: 최대공약수와 최소공배수
*/

public class Main {

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int num = Math.min(a, b);

        int firstResult = 1;

        for (int i = 1; i <= num; i++) {
            if (a % i == 0 && b % i == 0) {
                firstResult = i;
            }
        }

        Set<Integer> set = new HashSet<>();

        int secondResult = 0;

        int bigger = Math.max(a, b);
        int smaller = Math.min(a, b);

        outer:  for (int i = 1; i <= smaller; i++) {
            for (int j = 1; j <= bigger; j++) {
                if(bigger*i == smaller*j){
                    secondResult = smaller*j;
                    break outer;
                }
            }
        }

        System.out.println(firstResult+"\n"+secondResult);


    }

    public static void main(String args[]) throws Exception {
        new Main().solution();
    }
}
