import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
    solved.ac
    class2
    7568번 문제 : 덩치
 */

public class Main {

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        //0 : 몸무게, 1 : 키
        int[][] arr = new int[N][2];

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int weight = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());

            arr[i][0] = weight;
            arr[i][1] = height;
        }

        for (int i = 0; i < N; i++) {
            int count = 1;
            for (int j = 0; j < N; j++) {
                if (i != j) {
                    if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]){
                        count++;
                    }
                }
            }
            sb.append(count).append(" ");
        }

        System.out.println(sb);

    }


    public static void main(String[] args) throws Exception {
        Main.solution();
    }
}
