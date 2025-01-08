import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
    단계별로 풀어보기
    백트래킹
    15650번 문제: N과 M(2)
*/

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    static boolean[] visit;

    static int M;
    static int N;

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        visit = new boolean[N];

        dfs(0);

        System.out.println(sb);

    }

    static void dfs(int length) {
        if (length == M) {
            if (checkAscending(arr)) {
                for (int i = 0; i < M; i++) {
                    sb.append(arr[i] + " ");
                }
                sb.append("\n");
            }
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visit[i - 1]) {
                visit[i - 1] = true;
                arr[length] = i;
                dfs(length + 1);
                visit[i - 1] = false;
            }
        }
    }

    static boolean checkAscending(int[] arr) {
        boolean isAscending = true;
        int before = arr[0];

        for (int i = 1; i < M; i++) {
            if (arr[i] < before) {
                isAscending = false;
                break;
            }
            before = arr[i];
        }

        return isAscending;
    }


    public static void main(String[] args) throws Exception {
        Main.solution();
    }
}



