import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    단계별로 풀어보기
    조건문
    2480번 문제: 주사위 세 개 
*/

public class Main {

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int first = Integer.parseInt(st.nextToken());
        int second = Integer.parseInt(st.nextToken());
        int third = Integer.parseInt(st.nextToken());
        
        int result = 0;
        
        if(first == second && first == third ){
            result = 10000 + first * 1000;
        }
        else if(first == second && first != third){ // 1 2번 동일
            result = 1000 + first * 100;
        }
        else if(first != second && first == third){ // 1 3번 동일
            result = 1000 + first * 100;
        }
        else if(first != second && second == third){ // 2 3번 동일
            result = 1000 + second * 100;
        }
        else{
            int max = Math.max(first,second);
            max = Math.max(max, third);
            result = max * 100;
        }

        System.out.println(result);

    }

    public static void main(String args[]) throws Exception {
        new Main().solution();
    }
}




