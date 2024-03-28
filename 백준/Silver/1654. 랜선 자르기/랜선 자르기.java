import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


/*
    solved.ac
    class2
    1654번 문제 : 랜선 자르기
 */

public class Main {

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //N개보다 많이 만드는 것도 N개를 만드는 것에 포함된다??

        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        ArrayList<Long> list = new ArrayList<>();

        long max = Integer.MIN_VALUE;

        for (int i = 0; i < K; i++) {
            long num = Long.parseLong(br.readLine());
            list.add(num);

            max = Math.max(max, num);
        }

        long count;

        long right = max;
        long left = 1;

        if(N == 1){
            System.out.println(max);
        }else {
            while(left <= right){
                count = 0;
                long mid = (left + right) / 2;

                for(long num : list){
                    count += (num / mid);
                }

                if(count >= N){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }

            System.out.println(right);
        }

    }

    public static void main(String[] args) throws Exception {
        Main.solution();
    }
}
