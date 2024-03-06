import java.io.*;
import java.util.StringTokenizer;


/*
    단계별로 풀어보기
    일반 수학1
    2720번 문제: 세탁소 사장 동혁
*/

public class Main {

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int[] C = new int[T];

        int[] num = new int[4];


        for (int i = 0; i < T; i++) {
            C[i] = Integer.parseInt(br.readLine());
        }


        for (int i = 0; i < T; i++) {

            for(int j=0;j<4;j++){
                num[j] = 0;
            }

            int count = 0;
            while(count < 4){
                if(C[i] >= 25){
                    num[0] += C[i] / 25;
                    C[i] %= 25;
                }
                else if(C[i] >=10 && C[i] < 25){
                    num[1] += C[i] / 10;
                    C[i] %= 10;
                }
                else if(C[i] >= 5 && C[i] < 10){
                    num[2] += C[i] / 5;
                    C[i] %= 5;
                }
                else{
                    num[3] += C[i] / 1;
                    C[i] %= 1;
                }
                count++;
            }

            System.out.println(num[0] + " " + num[1] + " " + num[2] + " " + num[3]);


        }


    }

    public static void main(String args[]) throws Exception {
        new Main().solution();
    }
}
