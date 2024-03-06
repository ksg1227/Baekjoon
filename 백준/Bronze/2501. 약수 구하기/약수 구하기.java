import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;


/*
    단계별로 풀어보기
    약수,배수와 소수
    2501번 문제: 약수 구하기
*/

public class Main {

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            if(N % i == 0){
                arr.add(i);
            }
        }

        if(arr.size() < K){
            System.out.println(0);
        }
        else{
            System.out.println(arr.get(K-1));
        }



    }

    public static void main(String args[]) throws Exception {
        new Main().solution();
    }
}
