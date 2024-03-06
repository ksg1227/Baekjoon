import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;


/*
    단계별로 풀어보기
    집합과 맵
    11478번 문제: 서로 다른 부분 문자열의 개수
*/

public class Main {
    public static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < str.length(); i++) {

            String tempStr = Character.toString(str.charAt(i));

            set.add(tempStr);

            for (int j = i + 1; j < str.length(); j++) {
                tempStr = tempStr + str.charAt(j);

                set.add(tempStr);
            }
        }

        System.out.println(set.size());
    }

    public static void main(String args[]) throws Exception {
        Main.solution();
    }
}
