import java.io.*;
import java.util.StringTokenizer;


/*
    단계별로 풀어보기
    일반 수학1
    2903번 문제: 중앙 이동 알고리즘
*/

public class Main {

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        //1 2 9 22 41 66 (1, 7, 13, 19, 25 씩 증가)
        //1 3 11 25 45 (2, 8, 14, 20 씩 증가)
        //1 4 13 28 49 (3, 9, 15, 21 씩 증가)
        //1 5 15 31 53 (4, 10, 16, 22 씩 증가)
        //1 6 17 34 57 (5, 11, 17, 23 씩 증가)
        //1 7 19 37 61 (6, 12, 18, 24 씩 증가)


        int increaseRate = 6;
        int num = 1;
        int count = 1;


        while(true){
            if(N == 1){
                break;
            }
            if(N >= num + 1 && N <= num + increaseRate * count){
                count++;
                break;
            }
            else{
                num += increaseRate * count;
                count++;
            }
        }

        System.out.println(count);



    }

    public static void main(String args[]) throws Exception {
        new Main().solution();
    }
}
