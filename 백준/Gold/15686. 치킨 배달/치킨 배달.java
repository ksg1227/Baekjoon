import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 스터디 10주차
 * DP
 * 백준 15686번 : 치킨 배달
 */

public class Main {

    // M 개를 골라서 각각의 집들에 대해서 백트래킹
    static int N;
    static int M;

    static int[][] map;

    static Position[] alive;

    static List<Position> chickens = new ArrayList<>();
    static List<Position> houses = new ArrayList<>();

    static int totalChickens = 0;

    static int minDistance = Integer.MAX_VALUE;

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 2) {
                    chickens.add(new Position(i, j));
                    totalChickens++;
                }

                if (num == 1) {
                    houses.add(new Position(i, j));
                }

                map[i][j] = num;
            }
        }

        alive = new Position[M];

        backTracking(0, 0);

        System.out.println(minDistance);
    }

    static void backTracking(int start, int count) {

        if (count == M) {
            minDistance = Math.min(minDistance, chickenDistance());
            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            alive[count] = chickens.get(i);
            backTracking(i + 1, count + 1);
        }

    }

    static int chickenDistance() {
        int chickenDistance = 0;

        for (int i = 0; i < houses.size(); i++) {
            Position house = houses.get(i);

            int tempMin = Integer.MAX_VALUE;

            for (int j = 0; j < M; j++) {
                Position chicken = alive[j];

                tempMin = Math.min(tempMin, Math.abs(house.x - chicken.x) + Math.abs(house.y - chicken.y));
            }

            chickenDistance += tempMin;
        }

        return chickenDistance;
    }

    static void copyMap(int[][] temp) {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                temp[i][j] = map[i][j];
            }
        }
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








