import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


/*
    단계별로 풀어보기
    정렬
    10814번 문제: 나이순 정렬
*/

public class Main {

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[][] arr = new String[N][2];

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());

            arr[i][0] = st.nextToken();
            arr[i][1] = st.nextToken();
        }

        Arrays.sort(arr, (arr1, arr2) -> {
           int age1 = Integer.parseInt(arr1[0]);
           int age2 = Integer.parseInt(arr2[0]);

           return age1 - age2;
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

