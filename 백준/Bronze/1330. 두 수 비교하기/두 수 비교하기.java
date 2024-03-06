import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
    단계별로 풀어보기
    if문
    1330번 문제: 두 수 비교하기
*/

public class Main{

    static void solution() throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        String result = "";
        
        if(A > B)
            result = ">";
        else if(A == B)
            result = "==";
        else 
            result = "<";

        System.out.println(result);
    }
    
    public static void main(String args[]) throws Exception {
        new Main().solution();
    }
}