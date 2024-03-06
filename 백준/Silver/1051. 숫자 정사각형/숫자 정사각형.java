import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws IOException {
        int N, M;

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = bf.readLine().split(" ");
        N = Integer.parseInt(arr[0]);
        M = Integer.parseInt(arr[1]);

        int[][] rec = new int[N][M];

        for (int i = 0; i < N; i++) {
            String temp = bf.readLine();
            for (int j = 0; j < M; j++) {
                rec[i][j] = Character.getNumericValue(temp.charAt(j));
            }
        }

        int count = 1;

        int num = Math.min(N, M);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 1; k < num; k++) {
                    if(i + k >= N || j + k >= M){
                        break;
                    }
                    if (rec[i][j] == rec[i][j+k] && rec[i][j] == rec[i+k][j] && rec[i][j] == rec[i+k][j+k]) {
                        count = Math.max(count, k + 1);
                    }
                }

            }
        }
        System.out.println(count * count);
    }
}
