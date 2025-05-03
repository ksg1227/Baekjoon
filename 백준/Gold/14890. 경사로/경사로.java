import java.io.*;
import java.util.*;

public class Main {

    // 해당 방향으로 가다가 나보다 높이가 1 작은 애를 만나면 그 방향으로 높이가 1 작은 애가 L개 이어져있는지 확인함.
    // 만약 L개 이어져 있다면 경사로를 깔면 됨. 만약 L개 이어져있지 않다면 해당 길을 지나다닐 수 없음. 또한 만약 경사로가 이미 깔려있다면 패스

    // 반대로 해당 방향으로 가다가 나보다 높이가 1 큰 애를 만나면 나 포함 반대방향으로 나랑 같은 높이를 갖는 애가 L개 이어져있는지 확인함.
    // 만약 L개 이어져있다면 경사로를 깔면 됨. 만약 L개 이어져있지 않다면 해당 길을 지나다닐 수 없음만약 경사로가 이미 깔려있다면 패스.

    static boolean[][] slide;
    static int[][] map;

    static int N;
    static int L;

    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        slide = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            int[] horizontalRoad = map[i];

            // 로직 구현
            if (canPassHorizontal(horizontalRoad, i)) {  // i행
                count++;
            }

            for (int j = 0; j < N; j++) {
                slide[i][j] = false;
            }

        }

        int[] verticalRoad = new int[N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                verticalRoad[j] = map[j][i];
            }

            // 로직 구현
            if (canPassVertical(verticalRoad, i)) {  // i 열
                count++;
            }

            for (int j = 0; j < N; j++) {
                slide[j][i] = false;
            }
        }


        System.out.println(count);
    }


    static boolean canPassVertical(int[] road, int col) { // 열에 대한 체크
        int beforeHeight = road[0];

        for (int i = 1; i < N; i++) {

            if (Math.abs(beforeHeight - road[i]) >= 2) { // 이전이랑 높이 차이가 2 이상인 경우
                return false;
            }

            // 이전이랑 높이 차이가 1만 나는 경우
            if (beforeHeight < road[i]) { // 이전보다 지금이 높이가 더 큰 경우 - 이전 방향으로 경사로를 깔아야함

                for (int j = i - 1; j >= i - L; j--) {
                    if (j < 0 || slide[j][col] || road[j] != beforeHeight) {  // 경사로가 깔려있거나, 경사로가 범위를 벗어나거나, 높이가 다르거나
                        return false;
                    }
                }

                for (int j = i - 1; j >= i - L; j--) {
                    slide[j][col] = true;
                }
            }

            if (beforeHeight > road[i]) { // 이전보다 높이가 더 작은 경우
                for (int j = i; j <= i + L - 1; j++) {
                    if (j >= N || slide[j][col] || road[j] != road[i]) {  // 경사로가 깔려있거나, 경사로가 범위를 벗어나거나, 높이가 다르거나
                        return false;
                    }
                }

                for (int j = i; j <= i + L - 1; j++) {
                    slide[j][col] = true;
                }

                i += L - 1;
            }

            beforeHeight = road[i];
        }

        return true;
    }

    static boolean canPassHorizontal(int[] road, int row) { // 행에 대한 체크
        int beforeHeight = road[0];

        for (int i = 1; i < N; i++) {

            if (Math.abs(beforeHeight - road[i]) >= 2) { // 이전이랑 높이 차이가 2 이상인 경우
                return false;
            }

            // 이전이랑 높이 차이가 1만 나는 경우
            if (beforeHeight < road[i]) { // 이전보다 지금이 높이가 더 큰 경우 - 이전 방향으로 경사로를 깔아야함
                for (int j = i - 1; j >= i - L; j--) {
                    if (j < 0 || slide[row][j] || road[j] != beforeHeight) {  // 경사로가 깔려있거나, 경사로가 범위를 벗어나거나, 높이가 다르거나
                        return false;
                    }
                }

                for (int j = i - 1; j >= i - L; j--) {
                    slide[row][j] = true;
                }
            }

            if (beforeHeight > road[i]) { // 이전보다 높이가 더 작은 경우
                for (int j = i; j <= i + L - 1; j++) {
                    if (j >= N || slide[row][j] || road[j] != road[i]) {  // 경사로가 깔려있거나, 경사로가 범위를 벗어나거나, 높이가 다르거나
                        return false;
                    }
                }

                for (int j = i; j <= i + L - 1; j++) {
                    slide[row][j] = true;
                }

                i += L - 1;
            }

            beforeHeight = road[i];
        }

        return true;
    }
}
