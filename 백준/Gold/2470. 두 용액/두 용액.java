import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 스터디 5주차
 * 이진 탐색
 * 백준 2470번 : 두 용액
 */

public class Main {

    // 2진 탐색 쓰면 n logn 정도로 끊길 듯?

    static int N;

    static List<Integer> ph = new ArrayList<>();
    static List<Integer> al = new ArrayList<>();

    static StringBuilder sb = new StringBuilder();

    static int closestToZero = Integer.MAX_VALUE;

    static int firstValue;
    static int secondValue;

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (num < 0) {
                al.add(num);
            } else {
                ph.add(num);
            }
        }

        Collections.sort(al);
        Collections.sort(ph);

        // 1. ph가 빈 경우 -> 무조건 al 1, 2 번째 값만 더해보면 됨.
        // 2. al이 빈 경우 -> 무조건 ph 1, 2 번째 값만 더해보면 됨.
        // 3. 둘 다 비진 않았지만 ph만으로 값을 계산하는 게 더 0에 가까운 경우 -> 무조건 1, 2 번째 값만 더해보면 됨.
        // 4. 둘 다 비진 않았지만 al만으로 값을 계산하는 게 더 0에 가까운 경우 -> 무조건 1, 2 번째 값만 더해보면 됨.

        if (ph.isEmpty()) {  // O(1)
            sb.append(al.get(al.size() - 2)).append(" ").append(al.get(al.size() - 1));
        } else if (al.isEmpty()) {   // O(1)
            sb.append(ph.get(0)).append(" ").append(ph.get(1));
        } else {

            if (ph.size() >= 2) {    // O(1)
                int sum = ph.get(0) + ph.get(1);

                if (Math.abs(sum) < Math.abs(closestToZero)) {
                    closestToZero = sum;
                    firstValue = ph.get(0);
                    secondValue = ph.get(1);
                }
            }

            if (al.size() >= 2) {   // O(1)
                int sum = al.get(al.size() - 1) + al.get(al.size() - 2);

                if (Math.abs(sum) < Math.abs(closestToZero)) {
                    closestToZero = sum;
                    firstValue = al.get(al.size() - 2);
                    secondValue = al.get(al.size() - 1);
                }
            }

            for (int i = 0; i < ph.size(); i++) {
                if(binarySearch(0, al.size() - 1, ph.get(i))) {
                    break;
                }
            }

            sb.append(firstValue).append(" ").append(secondValue);
        }

        System.out.println(sb);


    }

    static boolean binarySearch(int alLowIndex, int alHighIndex, int ph) {

        // 양수인데, 절대값이 이전 것보다 더 크면 더 작은 값을 더해야함
        // 음수인데, 절대값이 이전 것보다 더 크면 덜 작은 값을 더해야함

        while (alLowIndex <= alHighIndex) {
            int mid = (alLowIndex + alHighIndex) / 2;

            int sum = al.get(mid) + ph;

            if (Math.abs(sum) > Math.abs(closestToZero)) {
                if (sum > 0) {  // 넘어온 ph가 크다 -> 더 작은 음수를 더해도 된다.
                    alHighIndex = mid - 1;
                } else {  // al 이 더 작은 음수값이다. -> 더 0에 가까운 음수를 더해야한다.
                    alLowIndex = mid + 1;
                }
            } else { // 같거나 작다면
                if (sum > 0) {  // ph의 절대값이 al의 절대값에 비해 더 큰 상황 -> 더 작은 음수를 더해봐도 됨
                    alHighIndex = mid - 1;
                    closestToZero = sum;
                    firstValue = al.get(mid);
                    secondValue = ph;
                } else if (sum < 0) {  // ph의 절대값이 al의 절대값에 비해 더 작은 상황 -> 더 0에 가까운 음수를 더해야함
                    alLowIndex = mid + 1;
                    closestToZero = sum;
                    firstValue = al.get(mid);
                    secondValue = ph;
                } else {  // 0 이 되는 경우
                    firstValue = al.get(mid);
                    secondValue = ph;
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        solution();
    }

}







