import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;


/*
    단계별로 풀어보기
    집합과 맵
    7785번 문제: 회사에 있는 사람
*/

public class Main {
    public static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        HashSet<String> set = new HashSet<>();

        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            String worker = st.nextToken();

            String log = st.nextToken();

            if (log.equals("enter")) {
                set.add(worker);
            } else if (log.equals("leave")) {
                set.remove(worker);
            }
        }

        String[] workerArr = new String[set.size()];

        set.toArray(workerArr);

        Arrays.sort(workerArr);

        for (int i = workerArr.length - 1; i >= 0; i--) {
            System.out.println(workerArr[i]);
        }
    }

    public static void main(String args[]) throws Exception {
        Main.solution();
    }
}
