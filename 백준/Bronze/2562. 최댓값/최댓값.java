import java.io.*;
import java.util.StringTokenizer;


/*
    단계별로 풀어보기
    1차원 배열
    2562번 문제: 최댓값
*/

public class Main {

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int max = 0;
        int index = 0;
        for(int i=0;i<9;i++){
            int num = Integer.parseInt(br.readLine());

            max = Math.max(max, num);

            if(max == num){
                index = i;
            }
        }

        System.out.println(max);
        System.out.println(index+1);


    }

    public static void main(String args[]) throws Exception {
        new Main().solution();
    }
}
