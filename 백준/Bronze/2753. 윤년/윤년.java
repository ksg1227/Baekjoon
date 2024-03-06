import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
    단계별로 풀어보기
    조건문
    2753번 문제: 윤년
*/

public class Main{

    static void solution() throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int year = Integer.parseInt(br.readLine());

        int result = 0;

        if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0){
            result = 1;
        }

        System.out.println(result);
    }

    public static void main(String args[]) throws Exception {
        new Main().solution();
    }
}