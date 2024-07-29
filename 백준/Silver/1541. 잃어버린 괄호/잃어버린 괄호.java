import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
    solved.ac
    class3
    1541번 문제 : 잃어버린 괄호
 */

public class Main {

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), "-");

        ArrayList<Integer> list = new ArrayList<>();

        while (st.hasMoreTokens()) {
            String partialFormula = st.nextToken();

            String num = "";

            int result = 0;

            for (int i = 0; i < partialFormula.length(); i++) {

                String token = String.valueOf(partialFormula.charAt(i));

                if (token.equals("+")) {
                    result += Integer.parseInt(num);
                    num = "";
                } else {
                    num += token;

                    if (i == partialFormula.length() - 1) {
                        result += Integer.parseInt(num);
                    }
                }
            }

            list.add(result);
        }

        int totalResult = list.get(0);

        for (int i = 1; i < list.size(); i++) {
            totalResult -= list.get(i);
        }

        System.out.println(totalResult);

    }


    public static void main(String[] args) throws Exception {
        Main.solution();
    }
}
