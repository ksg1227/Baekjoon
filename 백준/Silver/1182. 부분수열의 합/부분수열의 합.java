import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 스터디 5주차
 * 완전 탐색 - 브루트포스
 * 백준 1128번 : 부분 수열의 합
 */

public class Main {

    // 부분 수열은 연속할 필요가 없나봄

    static int N;
    static int S;

    static int[] value;

    static int result = 0;

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        value = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            value[i] = Integer.parseInt(st.nextToken());
        }

        backTracking(0, 0, 0, false);

        System.out.println(result);

    }


    // index == 이번에 더해야하는 값의 index
    static void backTracking(int sum, int length, int index, boolean add) {

        if (length != 0 && sum == S && add) {
            result++;
        }

        if (index == N) {
            return;
        }

        backTracking(sum + value[index], length + 1, index + 1, true);  // 더하는 경우

        backTracking(sum, length, index + 1, false); // 더하지 않는 경우 이 경우는 기존이랑 겹치면 더해주면 안됨


    }


    public static void main(String[] args) throws IOException {
        solution();
    }

}








