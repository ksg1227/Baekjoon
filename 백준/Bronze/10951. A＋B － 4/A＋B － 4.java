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

        while(true){
            String str = br.readLine();
            if(str == null){
                break;
            }
            else{
                StringTokenizer st = new StringTokenizer(str);
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                System.out.println(A+B);
            }
        }



    }

    public static void main(String args[]) throws Exception {
        new Main().solution();
    }
}
