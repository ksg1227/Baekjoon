import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 싸피 코테 준비
 * D2 - 21425
 * +=
 */
class Solution {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            int count = 0;
            while (true) {
                if (A > N || B > N) {
                    sb.append(count).append("\n");
                    break;
                }

                if (A > B) {
                    B += A;
                    count++;
                } else {
                    A += B;
                    count++;
                }
            }
        }

        System.out.println(sb);


    }
}



