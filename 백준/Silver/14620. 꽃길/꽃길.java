import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 스터디 10주차
 * DP
 * 백준 14620번 : 꽃길
 */

public class Main {

    static int[] dx = {0, 1, 0, -1, 0};
    static int[] dy = {0, 0, 1, 0, -1};

    // N X N 크기의 격자가 존재한다면 그 중 N-1, N-1 범위 내에서 3개의 지점을 골라야함.
    static int N;
    static int[][] map;

    static int result = Integer.MAX_VALUE;

    static Position[] arr = new Position[3];

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backTracking(0, 0, 0);

        System.out.println(result);

    }

    // 3개의 지점을 추적해야함
    static void backTracking(int start, int count, int index) {
        if (count == 3) {
            if (checkPossible()) {
                int sum = calculateSum();
                result = Math.min(sum, result);
            }
            return;
        }

        for (int i = start; i < N * N; i++) {
            int x = i / N;
            int y = i % N;

            if (x != N - 1 && y != N - 1 && x != 0 && y != 0) {
                arr[index] = new Position(x, y);
                backTracking(i + 1, count + 1, index + 1);
            }
        }
    }

    // 거리가 2이하면 불가
    static boolean checkPossible() {

        Position firstPosition = arr[0];

        Position secondPosition = arr[1];

        Position thirdPosition = arr[2];

        if (Math.abs(firstPosition.x - secondPosition.x) + Math.abs(firstPosition.y - secondPosition.y) <= 2) {
            return false;
        }

        if (Math.abs(firstPosition.x - thirdPosition.x) + Math.abs(firstPosition.y - thirdPosition.y) <= 2) {
            return false;
        }

        if (Math.abs(secondPosition.x - thirdPosition.x) + Math.abs(secondPosition.y - thirdPosition.y) <= 2) {
            return false;
        }

        return true;

    }

    static int calculateSum() {
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            for(int j=0;j<5;j++) {
                int nextX = arr[i].x + dx[j];
                int nextY = arr[i].y + dy[j];

                sum += map[nextX][nextY];
            }
        }

        return sum;
    }

    static class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        solution();
    }

}








