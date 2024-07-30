import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
    solved.ac
    class3
    1764번 문제 : 듣보잡
 */

public class Main {

    static int N;
    static int M;

    static Set<String> set = new HashSet<>();
    static ArrayList<String> list = new ArrayList<>();

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String hearPerson = br.readLine();

            set.add(hearPerson);
        }

        for (int i = 0; i < M; i++) {
            String seePerson = br.readLine();

            if (set.contains(seePerson)) {
                list.add(seePerson);
            }
        }

        Collections.sort(list);

        sb.append(list.size()).append("\n");

        for (String s : list) {
            sb.append(s).append("\n");
        }

        System.out.println(sb);

    }


    public static void main(String[] args) throws Exception {
        Main.solution();
    }
}
