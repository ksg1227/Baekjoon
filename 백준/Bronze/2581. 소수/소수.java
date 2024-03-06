import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;


/*
    단계별로 풀어보기
    약수,배수와 소수
    2581번 문제: 소수
*/

public class Main {

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = M; i <= N; i++) {
            if(i == 1){
                continue;
            }

            boolean flag = true;

            for (int j = 2; j < i; j++) {
                if(i % j == 0){
                    flag = false;
                }
            }

            if(flag){
                arr.add(i);
            }

        }

        int sum = 0;

        for(int i=0;i<arr.size();i++){
            sum += arr.get(i);
        }

        if(sum == 0){
            System.out.println(-1);
        }
        else {
            System.out.println(sum);
            System.out.println(arr.get(0));
        }
    }

    public static void main(String args[]) throws Exception {
        new Main().solution();
    }
}
