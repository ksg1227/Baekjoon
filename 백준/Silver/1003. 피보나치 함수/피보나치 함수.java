import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[][] arr = new int[41][2];

        arr[0][0] = 1;
        arr[0][1] = 0;

        arr[1][0] = 0;
        arr[1][1] = 1;

        for (int i = 2; i < 41; i++) {  //O(n)
            arr[i][0] = arr[i - 1][0] + arr[i - 2][0];
            arr[i][1] = arr[i - 1][1] + arr[i - 2][1];
        }

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int input = Integer.parseInt(br.readLine());

            sb.append(arr[input][0]).append(" ").append(arr[input][1]).append("\n");
        }

        System.out.println(sb);
    }


    public static void main(String[] args) throws Exception {
        Main.solution();
    }
}
