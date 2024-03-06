import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


/*
    단계별로 풀어보기
    정렬
    11651번 문제: 좌표 정렬하기2
*/

public class Main {

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2];

        StringTokenizer st;

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (arr1, arr2)->{
            if(arr1[1] == arr2[1]){
                return arr1[0] - arr2[0];
            }
            else{
                return arr1[1] - arr2[1];
            }
        });

        for(int i=0;i<N;i++){
            sb.append(arr[i][0] + " " + arr[i][1]).append("\n");
        }

        System.out.println(sb);

    }

    public static void main(String args[]) throws Exception {
        new Main().solution();
    }
}

