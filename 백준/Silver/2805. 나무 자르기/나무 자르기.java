import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
    solved.ac
    class3
    2805번 문제 : 나무 자르기

    이진 탐색 쓸래
 */

public class Main {

    static int N;
    static int M;

    static int[] tree;

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        tree = new int[N];

        st = new StringTokenizer(br.readLine());

        int max = Integer.MIN_VALUE;
        int min = 0;

        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());

            max = Math.max(max, tree[i]);
        }

        int result = Integer.MIN_VALUE;


        while (min <= max) {

            int mid = (max + min) / 2;

            long treeHeightSum = 0;

            for (int i = 0; i < N; i++) {
                if (tree[i] > mid) {
                    treeHeightSum += tree[i] - mid;
                }
            }

            if (treeHeightSum > M) {
                min = mid + 1;
                result = Math.max(result, mid);
            } else if (treeHeightSum < M) {
                max = mid - 1;
            } else {
                result = mid;
                break;
            }
        }

        System.out.println(result);


    }


    public static void main(String[] args) throws Exception {
        Main.solution();
    }
}
