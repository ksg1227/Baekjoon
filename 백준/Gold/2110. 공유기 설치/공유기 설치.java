import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 스터디 5주차
 * 이진 탐색
 * 백준 2110번 : 공유기 설치
 */

public class Main {

    // 개수가 적었으면 완전 탐색도 될텐데 개수가 너무 많아서 불가능함

    // 공유기 사이의 최소 인접 거리를 가지고 탐색을 하면 됨.
    // 만약 최소 인접 거리가 3일 때, 공유기 설치가 성공적으로 가능하다면, 거리를 늘려서 또 측정해보면 되고, 설치가 불가능하다면, 거리를 좁혀서 측정해보면 된다.

    static int N;
    static int C;

    static int[] house;

    static int result = Integer.MIN_VALUE;

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        house = new int[N];

        for (int i = 0; i < N; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(house);

        binarySearch(1, house[N - 1]);

        System.out.println(result);


    }

    static void binarySearch(int low, int high) {

        while (low <= high) {
            int mid = (low + high) / 2;   // 이게 거리임

            if (isPossible(mid)) {
                low = mid + 1;
                result = Math.max(result, mid);
            } else {
                high = mid - 1;
            }
        }
    }

    static boolean isPossible(int distance) {
        int lastShareIndex = 0;

        int count = 1;

        for (int i = 1; i < N; i++) {
            if (house[i] - house[lastShareIndex] >= distance) {   // 최소 인접 거리보다 멀리있다면 설치 가능
                lastShareIndex = i;
                count++;
            }

            // 설치가 불가능하다면 그냥 넘어감
        }

        return count >= C;
    }


    public static void main(String[] args) throws IOException {
        solution();
    }

}







