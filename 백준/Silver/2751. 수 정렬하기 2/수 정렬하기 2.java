import java.io.*;
import java.util.*;


/*  ***************** 매우 중요
    https://st-lab.tistory.com/106 사이트 참조
    단계별로 풀어보기
    정렬
    2751번 문제: 수 정렬하기2
*/

public class Main {

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[2000001];

        for(int i=0;i<2000001;i++){
            arr[i] = 0;
        }

        for(int i=0;i<N;i++){
            int num = Integer.parseInt(br.readLine());
            arr[num + 1000000]++;
        }

        //-100000부터 0번째 index
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<2000001;i++){
            if(arr[i] == 1){
                sb.append(i-1000000).append("\n");
            }
        }

        System.out.println(sb);

    }



    public static void main(String args[]) throws Exception {
        new Main().solution();
    }
}

