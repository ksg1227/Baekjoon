import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
    단계별로 풀어보기
    브루트포스
    1436번 문제: 영화감독 숌
*/

public class Main {

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int count = 0;
        int num = 666;
        String str = "";
        while(true){
            str = Integer.toString(num);

            if(str.contains("666")){
                count++;
            }

            if(count == N){
                break;
            }

            num++;
        }

        System.out.println(str);


    }

    public static void main(String args[]) throws Exception {
        new Main().solution();
    }
}


