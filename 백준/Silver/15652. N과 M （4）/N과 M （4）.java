import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 스터디 10주차
 * DP
 * 백준 15652번 : N과 M(4)
 */

public class Main {

    static int N;
    static int M;

    static int[] nums;

    static StringBuilder sb = new StringBuilder();

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[M];

        backTracking(0, 0, 1);

        System.out.println(sb);


    }

    static void backTracking(int count, int index, int start) {
        if (count == M) {
            for (int i = 0; i < M; i++) {
                sb.append(nums[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= N; i++) {
            nums[index] = i;
            backTracking(count + 1, index + 1, i);
            nums[index] = 0;
        }
    }


    public static void main(String[] args) throws IOException {
        solution();
    }

}








