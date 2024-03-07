import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


/*
    단계별로 풀어보기
    약수,배수와 소수2 (번외문제)
    2485번 문제: 가로수
*/

public class Main {

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //간격들의 최대공약수를 구하면 됨
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> distList = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(list);

        for (int i = 0; i < list.size() - 1; i++) {
            distList.add(list.get(i + 1) - list.get(i));
        }

        int gcd = distList.get(0);

        for (int i = 1; i < distList.size(); i++) {
            gcd = gcd(gcd, distList.get(i));
        }

        int count = 0;

        for (int i = 0; i < distList.size(); i++) {
            count += distList.get(i) / gcd - 1;
        }

        System.out.println(count);

    }

    static int gcd(int a, int b) {

        while (b != 0) {
            int r = a % b;

            a = b;
            b = r;
        }

        return a;
    }


    public static void main(String args[]) throws Exception {
        new Main().solution();
    }
}
