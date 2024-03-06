import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
    단계별로 풀어보기
    조건문
    2884번 문제: 알람 시계
*/

public class Main{

    static void solution() throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        if(M < 45) {
            if(H == 0) {
                H = 23;
            }
            else{
                H--;
            }
            M = 60 - (45 - M);
        }
        else{
            M = M - 45;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(H);
        sb.append(" ");
        sb.append(M);

        System.out.println(sb);
    }

    public static void main(String args[]) throws Exception {
        new Main().solution();
    }
}




