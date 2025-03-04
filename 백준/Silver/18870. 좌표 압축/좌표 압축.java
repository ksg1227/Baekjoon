import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
    solved.ac
    class3
    18870번 문제 : 좌표 압축
 */

public class Main {

    // nlogn + n + n = nlogn
    // 정렬, 작은 것 부터

    static int N;

    static int[] original;
    static int[] sort;
    static Map<Integer, Integer> map = new HashMap<>();

    static int count = 0;

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        original = new int[N];
        sort = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());

            original[i] = num;
            sort[i] = num;
        }

        Arrays.sort(sort);

        for (int i = 0; i < N; i++) {
            if(!map.containsKey(sort[i])) {
                map.put(sort[i], count++);
            }
        }

        for(int i=0;i<N;i++) {
            int key = original[i];

            sb.append(map.get(key)).append(" ");
        }

        System.out.println(sb);
    }


    public static void main(String[] args) throws Exception {
        Main.solution();
    }
}
