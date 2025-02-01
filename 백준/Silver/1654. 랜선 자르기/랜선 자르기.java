import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 스터디 5주차
 * 이진 탐색
 * 백준 1654번 : 랜선 자르기
 */

public class Main {

    // K개의 랜선을 가지고 특정 길이로 잘랐을 때, N개 이상의 랜선이 만들어지면 됨.
    // 단순히 완전 탐색을 할거면, 주어진 K개의 랜선 중 가장 큰 값부터 1까지 차례대로 줄여나가면서 잘라보면 됨
    // 다만 최악의 경우 K = 10,000 이고 N 이 1,000,000 이라면 1,000,000 * 10,000 번의 연산이 필요해진다.
    // 당연히 시간 초과. 그럼 어떻게? 이진 탐색
    // 근데 이진 탐색 힌트 없이 생각 없이 들어가면, 뒤에서부터 찾을 수도 있을 것 같음. 그냥 테스트겸 해보자

    static int K;
    static int N;

    static int[] lan;
    static long result = Integer.MIN_VALUE;

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        lan = new int[K];

        for (int i = 0; i < K; i++) {
            lan[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(lan);

        int low = 1;
        int high = lan[lan.length - 1];

        binarySearch(low, high);

        System.out.println(result);

    }

    static void binarySearch(long low, long high) {

        while (low <= high) {
            long mid = (low + high) / 2;

            if (countLan(mid) >= N) {
                low = mid + 1;
                result = Math.max(mid, result);
            } else {
                high = mid - 1;
            }
        }
    }

    static int countLan(long length) {
        int count = 0;
        for (int i = 0; i < K; i++) {
            count += lan[i] / length;
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        solution();
    }

}







