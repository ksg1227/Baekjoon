import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 스터디 10주차
 * 백트래킹
 * 백준 14620번 : 꽃길
 */

public class Main {

    static int N;
    static int M;

    // 감시되는 영역은 -1로 표시
    static int[][] office;
    static List<Position> cctv = new ArrayList<>();

    static int minBlindSpot = Integer.MAX_VALUE;

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        office = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());

                if (num >= 1 && num <= 5) {
                    cctv.add(new Position(i, j));
                }

                office[i][j] = num;
            }
        }

        backTracking(0);

        System.out.println(minBlindSpot);


    }

    static void backTracking(int start) {

        minBlindSpot = Math.min(countBlindSpot(), minBlindSpot);

        for (int i = start; i < cctv.size(); i++) {
            Position position = cctv.get(i);

            int[][] original = new int[N][M];
            copyMap(office, original);

            if (office[position.x][position.y] == 1) {

                for (int j = 0; j < 4; j++) {
                    if (j == 0) { // 오른쪽
                        fillRight(position.x, position.y);
                    } else if (j == 1) { // 위쪽
                        fillTop(position.x, position.y);
                    } else if (j == 2) { // 왼쪽
                        fillLeft(position.x, position.y);
                    } else { // 아래쪽
                        fillBottom(position.x, position.y);
                    }

                    backTracking(i + 1);

                    // 원상복구
                    copyMap(original, office);
                }
            } else if (office[position.x][position.y] == 2) {

                for (int j = 0; j < 2; j++) {
                    if (j == 0) { // 가로
                        fillRight(position.x, position.y);
                        fillLeft(position.x, position.y);
                    } else { // 세로
                        fillTop(position.x, position.y);
                        fillBottom(position.x, position.y);
                    }

                    backTracking(i + 1);

                    // 원상복구
                    copyMap(original, office);
                }
            } else if (office[position.x][position.y] == 3) {

                for (int j = 0; j < 4; j++) {
                    if (j == 0) { // 위쪽 & 오른쪽
                        fillTop(position.x, position.y);
                        fillRight(position.x, position.y);
                    } else if (j == 1) { // 위쪽 & 왼쪽
                        fillTop(position.x, position.y);
                        fillLeft(position.x, position.y);
                    } else if (j == 2) { // 아래쪽 & 오른쪽
                        fillBottom(position.x, position.y);
                        fillRight(position.x, position.y);
                    } else { // 아래쪽 & 왼쪽
                        fillBottom(position.x, position.y);
                        fillLeft(position.x, position.y);
                    }

                    backTracking(i + 1);

                    // 원상복구
                    copyMap(original, office);
                }
            } else if (office[position.x][position.y] == 4) {

                for (int j = 0; j < 4; j++) {
                    if (j == 0) { // 위쪽 & 가로
                        fillTop(position.x, position.y);
                        fillRight(position.x, position.y);
                        fillLeft(position.x, position.y);
                    } else if (j == 1) { // 아래쪽 & 가로
                        fillBottom(position.x, position.y);
                        fillRight(position.x, position.y);
                        fillLeft(position.x, position.y);
                    } else if (j == 2) { // 왼쪽 & 세로
                        fillLeft(position.x, position.y);
                        fillBottom(position.x, position.y);
                        fillTop(position.x, position.y);
                    } else { // 오른쪽 & 세로
                        fillRight(position.x, position.y);
                        fillBottom(position.x, position.y);
                        fillTop(position.x, position.y);
                    }

                    backTracking(i + 1);

                    // 원상복구
                    copyMap(original, office);
                }
            } else {
                
                // 채우기
                fillLeft(position.x, position.y);
                fillTop(position.x, position.y);
                fillRight(position.x, position.y);
                fillBottom(position.x, position.y);

                backTracking(i + 1);

                // 원상복구
                copyMap(original, office);
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

    static void fillRight(int x, int y) {
        for (int i = y + 1; i < M; i++) {
            if (office[x][i] == 6) {
                return;
            }

            if (office[x][i] == 0) {
                office[x][i] = -1;
                continue;
            }
        }
    }

    static void fillTop(int x, int y) {
        for (int i = x - 1; i >= 0; i--) {
            if (office[i][y] == 6) {
                return;
            }

            if (office[i][y] == 0) {
                office[i][y] = -1;
            }
        }
    }

    static void fillLeft(int x, int y) {
        for (int i = y - 1; i >= 0; i--) {
            if (office[x][i] == 6) {
                return;
            }

            if (office[x][i] == 0) {
                office[x][i] = -1;
            }
        }
    }

    static void fillBottom(int x, int y) {
        for (int i = x + 1; i < N; i++) {
            if (office[i][y] == 6) {
                return;
            }

            if (office[i][y] == 0) {
                office[i][y] = -1;
            }
        }
    }

    static int countBlindSpot() {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (office[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    static void copyMap(int[][] src, int[][] dest) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dest[i][j] = src[i][j];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        solution();
    }

}








