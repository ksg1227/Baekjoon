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

    // 주어진 금액들을 다 더한 게 국가 예산을 넘어가면 이진 탐색으로 최대 상한 선 찾기

    static int N;
    static int M;
    static int[] request;

    static int limitPrice = Integer.MIN_VALUE;

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        request = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        int result = 0;
        for (int i = 0; i < N; i++) {
            int price = Integer.parseInt(st.nextToken());
            request[i] = price;
            result += price;
        }

        M = Integer.parseInt(br.readLine());

        Arrays.sort(request);

        if (result <= M) {
            System.out.println(request[N - 1]);
        } else {  // 이 경우는 정수 상한액을 반환하면 됨
            binarySearch(1, request[N - 1]);

            System.out.println(limitPrice);
        }


    }

    static void binarySearch(int low, int high) {

        while (low <= high) {
            int mid = (low + high) / 2;

            if (countPrice(mid) <= M) {
                low = mid + 1;
                limitPrice = Math.max(mid, limitPrice);
            } else{
                high = mid - 1;
            }

        }
    }

    static int countPrice(int price) {
        int count = 0;

        for (int i = 0; i < N; i++) {
            count += Math.min(price, request[i]);
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        solution();
    }

}







