import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;


/*
    단계별로 풀어보기
    약수,배수와 소수
    9506번 문제: 약수들의 합
*/

public class Main {

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = 0;

        while (-1 != (n = Integer.parseInt(br.readLine()))) {
            ArrayList<Integer> arr = new ArrayList<>();

            int sum = 0;
            for (int i = 1; i < n; i++) {
                if(n % i == 0){
                    arr.add(i);
                    sum += i;
                }
            }

            if(sum == n){
                StringBuilder sb = new StringBuilder();
                sb.append(n).append(" = ");
                for(int i=0;i<arr.size();i++){
                    sb.append(arr.get(i));
                    if(i != arr.size()-1){
                        sb.append(" + ");
                    }
                }
                System.out.println(sb);
            }
            else{
                System.out.println(n + " is NOT perfect.");
            }


        }


    }

    public static void main(String args[]) throws Exception {
        new Main().solution();
    }
}
