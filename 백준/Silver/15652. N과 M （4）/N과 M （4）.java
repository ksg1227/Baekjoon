import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;


/*
    단계별로 풀어보기
    백트래킹
    15650번 문제: N과 M(2)
*/

public class Main {

    //값을 담을 배열
    static int[] arr;

    static StringBuilder sb = new StringBuilder();

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        dfs(N, M, 0);

        System.out.println(sb);

    }

    static void dfs(int N, int M, int depth) {
        if (depth == M) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int val : arr) {
                list.add(val);
            }
            if (checkAscending(list)) {
                for (int val : list) {
                    sb.append(val).append(" ");
                }
                sb.append("\n");
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            arr[depth] = i + 1;
            dfs(N, M, depth + 1);
        }
    }

    static boolean checkAscending(ArrayList<Integer> list) {

        int maxN = Integer.MIN_VALUE;

        boolean check = true;

        for (int num : list) {
            maxN = Math.max(maxN, num);

            if (maxN != num) {
                check = false;
            }
        }

        return check;
    }


    public static void main(String[] args) throws Exception {
        Main.solution();
    }
}



