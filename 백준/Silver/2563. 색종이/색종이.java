import java.io.*;
import java.util.StringTokenizer;


/*
    단계별로 풀어보기
    2차원 배열
    2563번 문제: 색종이
*/

public class Main {

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        boolean[][] arr = new boolean[101][101];

        int count = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int leftd = Integer.parseInt(st.nextToken());
            int bottomd = Integer.parseInt(st.nextToken());

            for (int j = bottomd; j < bottomd + 10; j++) {
                for (int k = leftd; k < leftd + 10; k++) {
                    if(arr[j][k] == true){
                        continue;
                    }
                    arr[j][k] = true;
                    count++;
                }
            }

        }

        System.out.println(count);

    }

    public static void main(String args[]) throws Exception {
        new Main().solution();
    }
}

