import java.io.*;
import java.util.*;

/**
 * 스터디 12주차
 * 이진 탐색
 * 백준 2343번 : 기타 레슨
 */

public class Main {

    // O(N-K) * O(K)

    static int N;
    static int[] nums;

    static int sum = Integer.MAX_VALUE;

    static int first;
    static int second;

    static boolean findResult = false;

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        nums = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N - 1; i++) {
            binarySearch(i + 1, N - 1, nums[i]);

            if (findResult) {
                break;
            }
        }

        System.out.println(first + " " + second);
    }


    static void binarySearch(int low, int high, int current) {

        while (low <= high) {
            int mid = (low + high) / 2;

            int num = nums[mid];

            int tempSum = current + num;

            if (Math.abs(tempSum) < sum) {
                sum = Math.abs(tempSum);
                first = current;
                second = num;
            }

            if (tempSum < 0) {
                low = mid + 1;
            } else if (tempSum == 0) {
                first = current;
                second = num;
                findResult = true;
                return;
            } else {
                high = mid - 1;
            }

        }
    }


    public static void main(String[] args) throws IOException {
        solution();
    }
}










