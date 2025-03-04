import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
    solved.ac
    class3
    2447번 문제 : 별 찍기 - 10
 */

public class Main {

    static char[][] star;

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        star = new char[N][N];

        printStar(0, 0, N);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(star[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

    static void printStar(int x, int y, int size) {
        if (size == 1) {
            star[x][y] = '*';
            return;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) {
                    printBlank(x + (i * size / 3), y + (j * size / 3), size / 3);
                } else {
                    printStar(x + (i * size / 3), y + (j * size / 3), size / 3);
                }
            }
        }
    }

    static void printBlank(int x, int y, int size) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                star[i][j] = ' ';
            }
        }
    }


    public static void main(String[] args) throws Exception {
        Main.solution();
    }
}
