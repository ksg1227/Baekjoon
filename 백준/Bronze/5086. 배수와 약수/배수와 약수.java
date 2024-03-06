import java.io.*;
import java.util.StringTokenizer;


/*
    단계별로 풀어보기
    약수,배수와 소수
    5086번 문제: 배수와 약수
*/

public class Main {

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = "";
        while(!"0 0".equals(str = br.readLine())){
            StringTokenizer st = new StringTokenizer(str);

            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            if(second % first == 0){
                System.out.println("factor");
            }
            else if(first % second == 0){
                System.out.println("multiple");
            }
            else{
                System.out.println("neither");
            }
        }


    }

    public static void main(String args[]) throws Exception {
        new Main().solution();
    }
}
