import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 싸피 코테 준비
 * D3 - 2805
 * 2805 - 농작물 수확하기
 */
class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(br.readLine());

            int[][] map = new int[N][N];

            for (int j = 0; j < N; j++) {
                String line = br.readLine();
                for (int k = 0; k < line.length(); k++) {
                    map[j][k] = line.charAt(k) - '0';
                }
            }

            int total = 0;

            int startIndex = N / 2;
            int size = 1;
            for (int j = 0; j < N; j++) {
                for (int k = startIndex; k < startIndex + size;k++) {
                    total += map[j][k];
                }
                if (j >= N / 2) {
                    size -= 2;
                    startIndex += 1;
                } else {
                    size += 2;
                    startIndex -= 1;
                }
            }

            sb.append("#" + i + " " + total + "\n");

        }

        System.out.println(sb);

    }


}



