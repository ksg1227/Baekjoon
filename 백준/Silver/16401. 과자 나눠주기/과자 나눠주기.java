import java.io.*;
import java.util.*;

/**
 * 스터디 12주차
 * 이진 탐색
 * 백준 16401번 : 과자 나눠주기
 */

public class Main {

    // high = 1,000,000,000
    // M = 1, N = 1, L1 = 1,000,000,000 인 경우, 조카 1명에게 줄 수 있는 막대과자의 최대 길이는 1,000,000,000 임

    static int N;
    static int M;

    static int[] length;

    static int result = 0;

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        length = new int[M];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            length[i] = Integer.parseInt(st.nextToken());
        }

        binarySearch(1, 1000000000);

        System.out.println(result);

    }

    static void binarySearch(int low, int high) {

        while (low <= high) {
            int mid = (low + high) / 2;

            int count = 0;

            for (int i = 0; i < M; i++) {
                count += length[i] / mid;
            }

            // 가능하면 더 길게
            if (count >= N) {
                result = Math.max(mid, result);
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
    }


    public static void main(String[] args) throws IOException {
        solution();
    }
}










