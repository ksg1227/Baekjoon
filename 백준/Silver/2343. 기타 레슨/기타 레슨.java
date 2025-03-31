import java.io.*;
import java.util.*;

/**
 * 스터디 11주차
 * 그리디
 * 백준 1080번 : 행렬
 */

public class Main {

    // 블루레이 크기를 찾기 위한 이진탐색
    // 블루레이 크기를 몇 으로 했을 때 M개의 블루레이에 담을 수 있으면 크기 줄이기
    // 블루에이 크기를 몇 으로 했을 때 M개의 블루레이에 담기지 않으면 크기 늘리기
    //
    // 다 담기면 줄이기

    static int N, M;

    static int result = Integer.MAX_VALUE;

    static int[] times;

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        times = new int[N];

        st = new StringTokenizer(br.readLine());

        int max = 0;
        int sum = 0;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            sum += num;
            max = Math.max(num, max);
            times[i] = num;
        }

        binarySearch(max, sum);

        System.out.println(result);
    }

    static void binarySearch(int low, int high) {

        int mid = (low + high) / 2;

        while (low <= high) {
            // mid == 블루레이 크기

            mid = (low + high) / 2;
            long sum = 0;
            int count = 1;

            // 이 로직 수정 필요
            for (int i = 0; i < N; i++) {
                if (sum + times[i] > mid) {
                    count++;
                    sum = times[i];
                } else {
                    sum += times[i];
                }
            }

            if (count <= M) { // 가능하면 크기 줄이기
                result = Math.min(result, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

    }


    public static void main(String[] args) throws IOException {
        solution();
    }
}










