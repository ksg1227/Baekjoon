import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/*
    단계별로 풀어보기
    문자열
    9063번 문제: 대지
*/

public class Main {

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> arrx = new ArrayList<>();
        ArrayList<Integer> arry = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arrx.add(Integer.parseInt(st.nextToken()));
            arry.add(Integer.parseInt(st.nextToken()));
        }

        if(arrx.size() == 1){
            System.out.println(0);
        }else {
            Collections.sort(arrx);
            Collections.sort(arry);

            System.out.println((arrx.get(arrx.size() - 1) - arrx.get(0)) * (arry.get(arry.size() - 1) - arry.get(0)));
        }
    }

    public static void main(String args[]) throws Exception {
        Main.solution();
    }
}
