import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
    solved.ac
    class3
    2630번 문제 : 색종이 만들기
 */

public class Main {

    static int N;

    static int[][] map;

    static int whiteCount = 0;
    static int blueCount = 0;


    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recur(N, 0, 0);

        System.out.println(whiteCount);
        System.out.println(blueCount);
    }

    static void recur(int size, int x, int y) {
        if (size == 1) {
            if(map[x][y] == 0) {
                whiteCount++;
            } else{
                blueCount++;
            }

            return;
        }

        boolean flag;

        if(map[x][y] == 0) {
            flag = checkColor(size, x, y, 1);
        } else {
            flag = checkColor(size, x, y, 0);
        }

        if (flag) {
            if(map[x][y] == 0) {
                whiteCount++;
            } else{
                blueCount++;
            }
        } else {
            recur(size / 2, x, y);
            recur(size / 2, x + size / 2, y);
            recur(size / 2, x, y + size / 2);
            recur(size / 2, x + size / 2, y + size / 2);
        }
    }

    private static boolean checkColor(int size, int x, int y, int color) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (map[i][j] == color) {
                    return false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) throws Exception {
        Main.solution();
    }
}
