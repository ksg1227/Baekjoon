import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/*
    단계별로 풀어보기
    집합과 맵
    1764번 문제: 듣보잡
*/

public class Main {
    public static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<String> set = new HashSet<>();

        for(int i=0;i<N;i++){
            String hearPerson = br.readLine();

            set.add(hearPerson);
        }

        int count = 0;

        ArrayList<String> list = new ArrayList<>();

        for(int i=0;i<M;i++){
            String seePerson = br.readLine();

            if(set.contains(seePerson)){
                count++;
                list.add(seePerson);
            }
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();

        sb.append(count).append("\n");

        for(int i=0;i<list.size();i++){
            sb.append(list.get(i)).append("\n");
        }

        System.out.println(sb);

    }

    public static void main(String args[]) throws Exception {
        Main.solution();
    }
}
