import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;


/*
    단계별로 풀어보기
    1차원 배열
    5597번 문제: 과제 안 내신 분..?
*/

public class Main {

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[30];

        for (int i = 1; i <= 30; i++) {
            arr[i-1] = i;
        }

        for(int i=0;i<28;i++){
            int num = Integer.parseInt(br.readLine());

            for(int j=0;j<30;j++){
                if(arr[j] == num){
                    arr[j] = 31;
                }
            }
        }

        Arrays.sort(arr);

        System.out.println(arr[0]);
        System.out.println(arr[1]);


    }

    public static void main(String args[]) throws Exception {
        new Main().solution();
    }
}
