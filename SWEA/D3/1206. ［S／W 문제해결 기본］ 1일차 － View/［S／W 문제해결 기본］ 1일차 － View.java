import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 싸피 코테 준비
 * D3 - 1206
 * 1206 - [S/W 문제해결 기본] 1일차 - View
 */
class Solution {

    static int[] buildings;
    static int N;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= 10; i++) {
            N = Integer.parseInt(br.readLine());
            buildings = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                buildings[j] = Integer.parseInt(st.nextToken());
            }

            sb.append("#" + i + " " + countView() + "\n");
        }

        System.out.println(sb);

    }

    static int countView() {

        int count = 0;

        // 가장 왼쪽
        if (buildings[0] > buildings[1] && buildings[0] > buildings[2]) {
            // 작은 애들 중에 가장 큰 것
            int maxHeight = Math.max(buildings[1], buildings[2]);
            count += buildings[0] - maxHeight;
        }

        // 그 다음 왼쪽
        if (buildings[1] > buildings[0] && buildings[1] > buildings[2] && buildings[1] > buildings[3]) {
            int maxHeight = Math.max(buildings[0], buildings[2]);
            maxHeight = Math.max(maxHeight, buildings[3]);
            count += buildings[1] - maxHeight;
        }

        // 가장 오른쪽
        if (buildings[N - 1] > buildings[N - 2] && buildings[N - 1] > buildings[N - 3]) {
            int maxHeight = Math.max(buildings[N - 2], buildings[N - 3]);
            count += buildings[N - 1] - maxHeight;
        }

        // 그 직전 오른쪽
        if (buildings[N - 2] > buildings[N - 1] && buildings[N - 2] > buildings[N - 3] && buildings[N - 2] > buildings[N - 4]) {
            int maxHeight = Math.max(buildings[N - 3], buildings[N - 4]);
            maxHeight = Math.max(maxHeight, buildings[N - 1]);
            count += buildings[N - 2] - maxHeight;
        }

        for (int i = 2; i < N - 2; i++) {
            if (buildings[i] > buildings[i - 1] && buildings[i] > buildings[i - 2] && buildings[i] > buildings[i + 1] && buildings[i] > buildings[i + 2]) {
                int maxHeight = findMax(i);
                count += buildings[i] - maxHeight;
            }
        }

        return count;
    }

    static int findMax(int index) {

        int max = 0;

        for (int i = index - 2; i <= index + 2; i++) {
            if (i != index) {
                max = Math.max(max, buildings[i]);
            }
        }

        return max;
    }


}



