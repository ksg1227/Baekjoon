import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[42];

        for(int i=0;i<42;i++){
            arr[i] = 0;
        }

        for(int i=0;i<10;i++){
            int num = Integer.parseInt(br.readLine());

            arr[num % 42] += 1;
        }

        int count = 0;

        for(int j=0;j<42;j++){
            if(arr[j] != 0){
                count++;
            }
        }

        System.out.println(count);
    }

    public static void main(String args[]) throws Exception {
        Main.solution();
    }
}
