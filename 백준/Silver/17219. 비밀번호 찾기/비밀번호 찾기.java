import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
    solved.ac
    class3
    17219번 문제 : 비밀번호 찾기
 */

public class Main {

    static int N;
    static int M;

    static Map<String, String> map = new HashMap<>();

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String url = st.nextToken();
            String password = st.nextToken();
            map.put(url, password);
        }

        for (int i = 0; i < M; i++) {
            String url = br.readLine();
            sb.append(map.get(url)).append("\n");
        }

        System.out.println(sb);


    }


    public static void main(String[] args) throws Exception {
        Main.solution();
    }
}
