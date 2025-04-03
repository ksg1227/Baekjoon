import java.io.*;
import java.util.*;

/**
 * 스터디 12주차
 * 이진 탐색
 * 백준 2343번 : 기타 레슨
 */

public class Main {

    // 그냥 각각의 수에 대해서, 그 수가 Good 인지를 알면, 그냥 그 수들의 개수만큼 + 해주면 됨

    // Ai => -1,000,000,000 ~ 1,000,000,000

    // 현재 수가 양수인 경우
    // 1. 자기보다 작거나 같은 양의 정수들 중에서 2개를 고르거나
    // 2. 자기보다 큰 양수에서 하나, 음수에서 하나 총 2개를 고르거나

    // 현재 수가 음수인 경우
    // 1. 자기보다 크거나 같은 음의 정수들 중에서 2개를 고르거나
    // 2. 자기보다 작은 음수에서 하나, 양수에서 하나 총 2개를 고르거나

    static int N;

    static List<Integer> negative = new ArrayList<>();
    static List<Integer> positive = new ArrayList<>();
    static List<Integer> all = new ArrayList<>();

    static Map<Integer, Boolean> isGood = new HashMap<>();
    static Map<Integer, Integer> frequency = new HashMap<>();

    static int count = 0;

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());

            all.add(num);
            isGood.put(num, false);
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);

            if (num < 0) {
                negative.add(num);
            } else {
                positive.add(num);
            }
        }

        Collections.sort(negative);
        Collections.sort(positive);

        // 현재 숫자가 양수면 뒤에서부터
        // 만약 이전의 숫자가 현재 숫자와 동일하다면, 이전 숫자가 GOOD 일 경우, 현재 숫자도 무조건 GOOD임

        // 현재 숫자가 음수이면 앞에서부터
        // 만약 이전의 숫자가 현재 숫자와 동일하다면, 이전 숫자가 GOOD 일 경우, 현재 숫자도 무조건 GOOD

        for (int i = positive.size() - 1; i >= 2; i--) {

            if (isGood.get(positive.get(i))) {
                continue;
            }

            for (int j = i - 1; j >= 0; j--) {
                if (isGoodCase(positive.get(i), positive.get(j), 0, j - 1, true)) {
                    isGood.put(positive.get(i), true);
                    break;
                }
            }
        }

        for (int i = positive.size() - 1; i >= 0; i--) {
            if (isGood.get(positive.get(i))) {
                continue;
            }

            for (int j = i + 1; j < positive.size(); j++) {
                if (isGoodCase(positive.get(i), positive.get(j), 0, negative.size() - 1, false)) {
                    isGood.put(positive.get(i), true);
                    break;
                }
            }
        }

        // 음수 경우
        for (int i = 0; i < negative.size() - 2; i++) {
            if (isGood.get(negative.get(i))) {
                continue;
            }

            for (int j = i + 1; j < negative.size() - 1; j++) {
                if (isGoodCase(negative.get(i), negative.get(j), j + 1, negative.size() - 1, false)) {
                    isGood.put(negative.get(i), true);
                    break;
                }
            }
        }

        for (int i = 0; i < negative.size(); i++) {
            if (isGood.get(negative.get(i))) {
                continue;
            }

            for (int j = i - 1; j >= 0; j--) {
                if (isGoodCase(negative.get(i), negative.get(j), 0, positive.size() - 1, true)) {
                    isGood.put(negative.get(i), true);
                    break;
                }
            }
        }

        for (int key : frequency.keySet()) {
            if (isGood.get(key)) {
                count += frequency.get(key);
            }
        }

        System.out.println(count);

    }

    // low, high 는 index
    // 양수인 경우의 첫번째 케이스
    // 1. 자기보다 작거나 같은 양의 정수들 중에서 2개를 고르거나
    static boolean isGoodCase(int result, int current, int low, int high, boolean firstCase) {

        // 첫번째 케이스
        while (low <= high) {
            int mid = (low + high) / 2;

            int sum;

            if (firstCase) {
                sum = current + positive.get(mid);
            } else {
                sum = current + negative.get(mid);
            }

            if (sum == result) {
                return true;
            }

            if (sum < result) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }


    // 0 1 2 3 4 5 6 6 6 8 9 10
    // -100 -100 -100 -99 -98 -2 -1
    public static void main(String[] args) throws IOException {
        solution();
    }
}










