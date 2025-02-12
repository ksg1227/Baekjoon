import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 싸피 코테 준비
 * D3 - 1206
 * 1206 - [S/W 문제해결 기본] 1일차 - View
 */
class Solution {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int count = 0;
            String input = br.readLine();
            char[] arr = input.toCharArray();
            
            char current = '0';

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == '1' && current == '0') {
                    count++;
                    current = '1';
                } else if(arr[i] == '0' && current == '1') {
                    count++;
                    current = '0';
                }
            }

            sb.append("#" + tc + " " + count).append("\n");

        }

        System.out.println(sb);
    }


}



