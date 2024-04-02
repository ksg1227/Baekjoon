import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
    solved.ac
    class2
    18111번 문제 : 마인크래프트
 */

public class Main {

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //1번 작업 = 2초 -> O(2N)
        //2번 작업 = 1초 -> O(N)
        //인벤토리에는 B개의 블록이 들어있음

        //가장 큰 약수를 구해야함

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = 0;
        int M = 0;
        int B = 0; //64 * 10^6 = 20^6


        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;

                min = Math.min(num, min);
                max = Math.max(num, max);
            }
        }


        int time = Integer.MAX_VALUE;
        int height = Integer.MIN_VALUE;

        for (int i = min; i <= max; i++) {

            int tempTime = 0;
            int storeB = B;

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (arr[j][k] >= i) {
                        storeB += (arr[j][k] - i);
                        tempTime += 2 * (arr[j][k] - i);
                    }else{
                        storeB -= (i - arr[j][k]);

                        tempTime += (i - arr[j][k]);

                    }
                }
            }

            if(storeB < 0){
                continue;
            }

            time = Math.min(time, tempTime);

            if(time == tempTime){
                height = Math.max(height, i);
            }
        }

        System.out.println(time + " " + height);


    }

    public static void main(String[] args) throws Exception {
        Main.solution();
    }
}
