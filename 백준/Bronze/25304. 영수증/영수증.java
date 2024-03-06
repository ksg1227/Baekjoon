import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
    단계별로 풀어보기
    반복문
    10950번 문제: A + B -3
*/

public class Main {

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());

        int N = Integer.parseInt(br.readLine());

        int sum = 0;
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            sum += a * b;
        }
        
        if(X == sum){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }


    }

    public static void main(String args[]) throws Exception {
        new Main().solution();
    }
}
