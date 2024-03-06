import java.io.*;
import java.util.*;


/*  
    단계별로 풀어보기
    정렬
    2751번 문제: 수 정렬하기2
*/

public class Main {

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[10001];

        for(int i=0;i<10001;i++){
            arr[i] = 0;
        }

        for(int i=0;i<N;i++){
            int index = Integer.parseInt(br.readLine());
            arr[index]++;
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<10001;i++){
            if(arr[i] != 0){
                for(int j=0;j<arr[i];j++){
                    sb.append(i).append("\n");
                }
            }
        }

        System.out.println(sb);

    }
    public static void main(String args[]) throws Exception {
        new Main().solution();
    }
}

