import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String args[]) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = bf.readLine().split(" ");

        int N = Integer.parseInt(arr[0]);
        int C = Integer.parseInt(arr[1]);

        int[] stdarr = new int[N];

        int total = 0;
        for (int i = 0; i < N; i++) {
            stdarr[i] = Integer.parseInt(bf.readLine());

        }

        for (int i = 0; i <= C; i++) {
            for (int j = 0; j < N; j++) {
                if (i % stdarr[j] == 0 && i != 0) {
                    total++;
                    break;
                }
            }
        }

        System.out.println(total);


    }
}
