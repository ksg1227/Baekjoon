import java.io.*;
import java.util.ArrayList;
import java.util.Collections;


/*
    solved.ac
    class2
    18110번 문제 : solved.ac
 */

public class Main {

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[31];

        for (int i = 0; i < 31; i++) {
            arr[i] = 0;
        }

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[num] += 1;
        }

        int exceptNum = (int) Math.round(n * 0.15);

        int traceBig = 30;
        int traceLittle = 1;

        for (int i = 0; i < exceptNum; i++) {
            while(arr[traceBig] == 0){
                traceBig--;
            }
            arr[traceBig]--;

            while (arr[traceLittle] == 0) {
                traceLittle++;
            }

            arr[traceLittle]--;
        }


        double result = 0.0;

        for (int i = 1; i < 31; i++) {
            result += arr[i] * i;
        }

        System.out.println(Math.round(result / (n - exceptNum * 2)));


    }


    public static void main(String[] args) throws Exception {
        Main.solution();
    }
}
