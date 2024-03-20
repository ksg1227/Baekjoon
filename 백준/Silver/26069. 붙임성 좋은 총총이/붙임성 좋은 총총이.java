import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
    단계별로 풀어보기
    심화 2
    26069번 문제: 붙임성 좋은 총총이
*/

public class Main {

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        HashSet<String> set = new HashSet<>();

        set.add("ChongChong");

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String firstPerson = st.nextToken();
            String secondPerson = st.nextToken();

            if(set.contains(firstPerson) || set.contains(secondPerson)){
                set.add(firstPerson);
                set.add(secondPerson);
            }
        }

        System.out.println(set.size());

    }

    public static void main(String args[]) throws Exception {
        Main.solution();

    }

}








