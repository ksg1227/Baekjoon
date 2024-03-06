import java.io.*;
import java.util.StringTokenizer;


/*
    단계별로 풀어보기
    2차원 배열
    10798번 문제: 세로읽기
*/

public class Main {

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[][] arr = new char[5][15];

        for(int i=0;i<5;i++){
            for(int j=0;j<15;j++){
                arr[i][j] = '*';
            }
        }

        for (int i = 0; i < 5; i++) {
            String str = br.readLine();
            for(int j=0;j<str.length();j++){
                arr[i][j] = str.charAt(j);
            }
        }


        StringBuilder sb = new StringBuilder();

        for(int i=0;i<15;i++){
            for(int j=0;j<5;j++){
                if(arr[j][i] != '*'){
                    sb.append(arr[j][i]);
                }
            }
        }

        System.out.println(sb);

    }

    public static void main(String args[]) throws Exception {
        new Main().solution();
    }
}

