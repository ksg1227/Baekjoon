import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
    단계별로 풀어보기
    조건문
    14681번 문제: 사분면 고르기
*/

public class Main{

    static void solution() throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());
        
        int result = 0;
        
        if(x > 0 && y > 0)
            result = 1;
        else if(x > 0 && y < 0)
            result = 4;
        else if(x < 0 && y > 0)
            result = 2;
        else if(x < 0 && y < 0)
            result = 3;

        System.out.println(result);
        
        
    }

    public static void main(String args[]) throws Exception {
        new Main().solution();
    }
}