import java.io.*;
import java.util.*;

// D3 1220
public class Solution {

    // 각각의 열에 대해서만 따지면 됨
    // 처음 나오는 N극 자성체를 찾아야함. S극이 먼저나오면 어차피 걔는 교착상태 아님.
    // N극 자성체를 찾고, 그 다음에 나오는 S극 자성체랑 짝을 이루어서 하나의 교착 상태로 판단하면 됨.
    // 그 사이에 몇 개의 N극 자성체가 있는지는 상관 없음
    // 즉 N극 자성체를 찾았을 때 flag 를 true 로 해놓고, flag 가 true 일 때 S극 자성체를 만나면 그 시점에 개수를 증가시키면 됨

    static int N;
    static int[][] table;

    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        table = new int[100][100];

        for (int i = 1; i <= 10; i++) {
            N = Integer.parseInt(br.readLine());

            for (int j = 0; j < 100; j++) {
                st = new StringTokenizer(br.readLine());

                for (int k = 0; k < 100; k++) {
                    table[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            count = 0;

            for (int j = 0; j < 100; j++) {
                countConflict(j);
            }

            sb.append("#" + i + " " + count).append("\n");

        }

        System.out.println(sb);
    }

    static void countConflict(int col) {

        boolean flag = false;

        // 1 = N 극
        // 2 = S 극
        for (int i = 0; i < 100; i++) {
            if (!flag && table[i][col] == 1) {
                flag = true;
                continue;
            }

            if (flag && table[i][col] == 2) {
                flag = false;
                count++;
            }
        }
    }
}
