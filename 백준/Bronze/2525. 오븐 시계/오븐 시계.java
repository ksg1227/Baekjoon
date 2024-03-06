import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
    단계별로 풀어보기
    조건문
    2525번 문제: 오븐 시계
*/

public class Main {

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int time = Integer.parseInt(br.readLine());

        int plusH = time / 60;
        int plusM = time % 60;

        if(M + plusM >= 60){
            if(H == 23){
                H = 0;
            }
            else{
                H++;
            }
            M = M + plusM - 60;
        }
        else{
            M += plusM;
        }

        for (int i = 0; i < plusH; i++) {   
            if (H == 23) {
                H = 0;
            } else {
                H++;
            }
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




