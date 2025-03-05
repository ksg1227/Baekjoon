import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
    solved.ac
    class3
    17626번 문제 : Four Squares
 */

public class Main {

    // 1개로 되는지
    // 2개로 되는지
    // 3개로 되는지
    // 안되면 4 반환

    static int n;

    static int max;

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        max = (int) Math.sqrt(n);

        System.out.println(check());
    }

    static boolean findCombination1() {
        for (int i = 1; i <= max; i++) {
            if ((int) Math.pow(i, 2) == n) {
                return true;
            }
        }

        return false;
    }

    static boolean findCombination2() {
        for (int i = 1; i <= max; i++) {
            int first = (int) Math.pow(i, 2);

            if (first > n) {
                return false;
            }
            for (int j = 1; j <= max; j++) {
                int second = (int) Math.pow(j, 2);

                if (second > n) {
                    break;
                }

                if (first + second == n) {
                    return true;
                }
            }
        }

        return false;
    }

    static boolean findCombination3() {
        for (int i = 1; i <= max; i++) {
            int first = (int) Math.pow(i, 2);

            if(first > n) {
                return false;
            }
            for (int j = 1; j <= max; j++) {
                int second = (int) Math.pow(j, 2);

                if(second > n) {
                    break;
                }
                for (int k = 1; k <= max; k++) {
                    int third = (int) Math.pow(k, 2);

                    if(third > n) {
                        break;
                    }

                    if (first + second + third == n) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    static int check() {
        if(findCombination1()) {
            return 1;
        };

        if(findCombination2()) {
            return 2;
        }

        if(findCombination3()) {
            return 3;
        }

        return 4;
    }


    public static void main(String[] args) throws Exception {
        Main.solution();
    }
}
