import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
    solved.ac
    class3
    30804번 문제 : 과일 탕후루
 */

public class Main {

    static int N;

    static int[] fruits;
    static Map<Integer, Integer> map = new HashMap<>();

    static int result = Integer.MIN_VALUE;

    static int left = 0;
    static int right = 0;

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        fruits = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            fruits[i] = num;
        }

        twoPointer();

        System.out.println(result);


    }

    static void twoPointer() {

        for (int i = 0; i < N; i++) {
            right = i;

            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);

            if (map.size() <= 2) {
                result = Math.max(right - left + 1, result);
            } else {
                while (map.size() > 2) {
                    if (map.get(fruits[left]) == 1) {
                        map.remove(fruits[left]);
                    } else {
                        map.put(fruits[left], map.get(fruits[left]) - 1);
                    }
                    left++;
                }
            }
        }

    }


    public static void main(String[] args) throws Exception {
        Main.solution();
    }
}
