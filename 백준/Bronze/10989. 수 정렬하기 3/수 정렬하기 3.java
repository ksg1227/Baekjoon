import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/*
    solved.ac
    class2
    10989번 문제 : 수 정렬하기 3
 */

public class Main {

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[10001];

        for(int i=0;i<N;i++){
            int num = Integer.parseInt(br.readLine());
            arr[num] += 1;
        }

        for(int i=0;i<10001;i++){
            if(arr[i] > 0){
                for(int j=0;j<arr[i];j++){
                    sb.append(i).append("\n");
                }
            }
        }

        System.out.println(sb);


    }


    public static void main(String[] args) throws Exception {
        Main.solution();
    }
}
