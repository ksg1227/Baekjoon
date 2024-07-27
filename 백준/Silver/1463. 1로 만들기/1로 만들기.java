import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
    solved.ac
    class3
    1463번 문제 : 1로 만들기
 */

public class Main {

    static int[] remember;

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        remember = new int[num + 1];

        for (int i = 0; i < num + 1; i++) {
            remember[i] = -1;
        }

        remember[0] = 0;
        remember[1] = 0;


        System.out.println(calculateMinDfs(num));
    }

    static int calculateMinDfs(int n) {

        if (remember[n] == -1) {
            if (n % 6 == 0) {
                remember[n] = Math.min(Math.min(calculateMinDfs(n / 3), calculateMinDfs(n / 2)), calculateMinDfs(n - 1)) + 1;
            } else if (n % 3 == 0) {
                remember[n] = Math.min(calculateMinDfs(n / 3), calculateMinDfs(n - 1)) + 1;
            } else if (n % 2 == 0) {
                remember[n] = Math.min(calculateMinDfs(n / 2), calculateMinDfs(n - 1)) + 1;
            } else {
                remember[n] = calculateMinDfs(n - 1) + 1;
            }
        }

        return remember[n];
    }


    public static void main(String[] args) throws Exception {
        Main.solution();
    }
}
