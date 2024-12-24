import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
    단계별로 풀어보기
    그리디
    1541번 : 잃어버린 괄호
*/

public class Main {

    // 첫번째 - 이전의 값들은 다 더하고, 첫번째 - 이후의 값은 다 빼면 됨

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String formula = br.readLine();

        int result = 0;
        String tempNum = "";
        int tempSum = 0;

        boolean isFirstMinus = true;

        int minusCount = 0;


        for (int i = 0; i < formula.length(); i++) {
            if (formula.charAt(i) == '-') {
                minusCount++;

                if (isFirstMinus) {
                    isFirstMinus = false;
                    result += Integer.parseInt(tempNum);
                    tempNum = "";
                    continue;
                }

                result -= Integer.parseInt(tempNum);
                tempNum = "";

            } else if(formula.charAt(i) == '+') {
                if(minusCount == 0) {
                    result += Integer.parseInt(tempNum);
                } else{
                    result -= Integer.parseInt(tempNum);
                }
                tempNum = "";
            } else{
                tempNum += formula.charAt(i);

                if(i == formula.length() - 1) {
                    if(minusCount == 0) {
                        result += Integer.parseInt(tempNum);
                    } else{
                        result -= Integer.parseInt(tempNum);
                    }
                }
            }
        }

        System.out.println(result);


    }


    public static void main(String args[]) throws Exception {
        Main.solution();
    }
}

