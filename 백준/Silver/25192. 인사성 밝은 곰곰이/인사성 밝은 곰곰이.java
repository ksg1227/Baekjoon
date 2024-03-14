import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
    단계별로 풀어보기
    심화 2
    25192번 문제: 인사성 밝은 곰곰이
*/

public class Main {

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        HashSet<String> set = new HashSet<>();

        int count = 0;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            if(str.equals("ENTER")){
                set.clear();
            }else {
                if (!set.contains(str)) {
                    set.add(str);
                    count++;
                }
            }
        }

        System.out.println(count);

    }

    public static void main(String args[]) throws Exception {
        Main.solution();

    }

}








