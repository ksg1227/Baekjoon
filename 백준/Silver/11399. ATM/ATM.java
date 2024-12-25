import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
    단계별로 풀어보기
    그리디
    11399번 : ATM
*/

public class Main {

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(list);

        int temp = 0;
        int result = 0;

        for (int i = 0; i < list.size(); i++) {
            temp += list.get(i);

            result += temp;
        }

        System.out.println(result);


    }

    public static void main(String args[]) throws Exception {
        solution();
    }
}

