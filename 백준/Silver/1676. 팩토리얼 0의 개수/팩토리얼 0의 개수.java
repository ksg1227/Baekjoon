import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*
    solved.ac
    class2
    1676번 문제 : 팩토리얼 0의 개수
 */

public class Main {

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int countTwo = 0;
        int countFive = 0;

        //앞에 뭐가 곱해지던지에 상관 없이 10^n 에서 n만 구하면 됨
        //10의 약수 = 2와 5
        //즉 2의 개수와 5의 개수중 더 작은 값이 10의 지수임

        for (int i = 1; i <= N; i++) {

            int tempNum = i;

            while(tempNum % 5 == 0){
                tempNum /= 5;
                countFive++;
            }

            while(tempNum % 2 == 0){
                tempNum /= 2;
                countTwo++;
            }
        }

        System.out.println(Math.min(countFive, countTwo));
    }

    public static void main(String[] args) throws Exception {
        Main.solution();
    }
}
