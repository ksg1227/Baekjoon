import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;


/*
    단계별로 풀어보기
    백트래킹
    15649번 문제: N과 M
*/

public class Main {

    static int N;
    static int M;
    static StringBuilder sb = new StringBuilder();

    //값을 담을 배열
    static int[] arr;

    //방문 여부 확인할 배열
    static boolean[] visit;

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

    public static void dfs(int length) {
        if (length == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
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


    public static void main(String[] args) throws Exception {
        Main.solution();
    }
}



