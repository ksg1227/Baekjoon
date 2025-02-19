import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 스터디 7주차
 * 그리디
 * 백준 1931번 : 회의실 배정
 */

public class Main {

    static int N;

    // 시작 시간을 기준으로 정렬.
    // 그 다음에 종료 시간을 기준으로 정렬

    // 시작 시간이 종료시점보다 앞이어야하고, 동시에 종료 시점이 기존의 종료시점보다 빨라야함
    // 그러면 최적 경우로 갱신

    static int[][] arr;

    static int bestEnd = Integer.MAX_VALUE;

    static int count = 0;

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]);

        Arrays.sort(arr, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return 0;
        });

        int index = 0;

        while (index != -1) {
            count++;

            for (int i = index; i < N; i++) {
                int start = arr[i][0];
                int end = arr[i][1];

                if (start >= bestEnd) {
                    break;
                }

                if (end <= bestEnd) {
                    bestEnd = end;
                    index = i;
                }
            }

            index = nextIndex(index, bestEnd);

            if (index != -1) {
                bestEnd = arr[index][1];
            }

        }

        System.out.println(count);


    }

    static int nextIndex(int index, int end) {
        for (int i = index + 1; i < N; i++) {
            if (arr[i][0] >= end) {
                return i;
            }
        }

        return -1;
    }


    public static void main(String[] args) throws IOException {
        solution();
    }

}








