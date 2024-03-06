import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[9];

        int total = 0;

        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
            total += arr[i];
        }

        int[] indexarr = new int[2];

        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if(total - arr[i] - arr[j] == 100){
                    indexarr[0] = arr[i];
                    indexarr[1] = arr[j];
                }
            }
        }

        for(int i=0;i<9;i++){
            if(arr[i] == indexarr[0] || arr[i] == indexarr[1]){
                continue;
            }
            System.out.println(arr[i]);
        }
    }
}
