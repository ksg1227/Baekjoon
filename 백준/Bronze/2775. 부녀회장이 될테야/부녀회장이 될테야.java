import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*
    solved.ac
    class2
    2775번 문제 : 부녀회장이 될테야
 */

public class Main {

    static int[][] apart = new int[15][15];

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int i=0;i<15;i++){
            for(int j=0;j<15;j++){
                apart[i][j] = 0;
            }
        }

        for (int i = 0; i < 15; i++) {
            apart[0][i] = i;
        }

        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());


            sb.append(apartValue(k,n)).append("\n");
        }

        System.out.println(sb);

    }

    static int apartValue(int k, int n) {
        if (k == 0) {
            return apart[k][n];
        } else{
            int result = 0;
            for (int i = 1; i <= n; i++) {
                result += apartValue(k - 1, i);
            }

            return result;
        }

    }


    public static void main(String[] args) throws Exception {
        Main.solution();
    }
}
