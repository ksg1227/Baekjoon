import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 스터디 1주차
 * 백트래킹
 * 백준 17136번 : 색종이 붙이기
 */

public class Main {

    // 색종이가 이미 붙어있으면 2로 설정

    static int[][] map = new int[10][10];
    static int[] count = new int[]{5, 5, 5, 5, 5};
    static List<int[]> list = new ArrayList<>();
    static int minPaperCount = Integer.MAX_VALUE;
    static boolean isPossible = false;

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1) {
                    list.add(new int[]{i, j});
                }
                map[i][j] = num;
            }
        }

        if (!list.isEmpty()) {
            int[] start = list.get(0);
            backTracking(start[0], start[1], 0, 0);

            if (isPossible) {
                System.out.println(minPaperCount);
            } else {
                System.out.println(-1);
            }
        } else {
            System.out.println(0);
        }


    }

    static void backTracking(int x, int y, int paperCount, int index) {

        for (int i = 5; i >= 1; i--) {
            int size = i;
            if (count[size - 1] > 0) {
                if (canAttach(x, y, size)) {
                    attach(x, y, size);
                    count[size - 1]--;

                    if (checkNoOne()) {
                        isPossible = true;
                        minPaperCount = Math.min(minPaperCount, paperCount + 1);
                        detach(x, y, size);
                        count[size - 1]++;
                        return;
                    }

                    for (int j = index; j < list.size(); j++) {
                        if (map[list.get(j)[0]][list.get(j)[1]] == 1) {
                            backTracking(list.get(j)[0], list.get(j)[1], paperCount + 1, j + 1);
                            break;
                        }
                    }
                    detach(x, y, size);
                    count[size - 1]++;
                }
            }
        }
    }


    // 색종이를 더 붙일 수 없는지
    static boolean checkNoOne() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (map[i][j] == 1) {
                    return false;
                }
            }
        }

        return true;
    }

    // 색종이 붙일 수 있는지 체크
    static boolean canAttach(int x, int y, int size) {
        if (x + size > 10 || y + size > 10) {
            return false;
        }

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (map[i][j] == 0 || map[i][j] == 2) {
                    return false;
                }
            }
        }

        return true;
    }

    // 색종이 붙이기
    static void attach(int x, int y, int size) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                map[i][j] = 2;
            }
        }
    }

    // 색종이 떼기
    static void detach(int x, int y, int size) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                map[i][j] = 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        solution();
    }

}







