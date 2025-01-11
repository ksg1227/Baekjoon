import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 싸피 코테 준비
 * D1 - 2071
 * 평균값 구하기
 */
class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            st = new StringTokenizer(br.readLine());

            double sum = 0;

            for (int j = 0; j < 10; j++) {
                sum += Integer.parseInt(st.nextToken());
            }

            int result = (int) Math.round(sum / 10);

            sb.append("#" + i + " " + result + "\n");
        }

        System.out.println(sb);

    }
}
