import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int[] money;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int result = Integer.MAX_VALUE;

        money = new int[N];

        int temp = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            money[i] = num;
            temp = Math.max(num, temp);
        }

        int high = 10000 * 100000;
        int low = temp;

        // M 보다 더 적은 횟수로 생활이 가능하면 얼마든지 횟수는 늘릴 수 있음
        // 즉 M 보다 작으면 high 를 그 k-1 로 낮추면 됨.
        // M 보다 크면 low 를 k + 1 로 높이면 됨.

        while (low <= high) {
            int k = (low + high) / 2;

            int currentMoney = 0;

            int count = 0;

            for (int i = 0; i < N; i++) {
                if (currentMoney >= money[i]) {
                    currentMoney -= money[i];
                } else { // 인출하는 경우
                    currentMoney = k - money[i]; // 인출 후 생활비 내야함
                    count ++;
                }
            }


            if(count <= M) {
                result = Math.min(k, result);
                high = k - 1;
            } else {
                low = k + 1;
            }
        }

        System.out.println(result);



    }
}
