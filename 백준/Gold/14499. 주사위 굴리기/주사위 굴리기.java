import java.io.*;
import java.util.*;

public class Main {


    static int top = 1;
    static int bottom = 6;
    static int right = 3;
    static int left = 4;
    static int front = 5;
    static int back = 2;

    static int[] dice = new int[7];
    static int[] instructions;

    static int[][] map;
    static int N;
    static int M;
    static int x;
    static int y;
    static int K;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        instructions = new int[K];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < K; i++) {
            instructions[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < K; i++) {
            int instruction = instructions[i];

            if (!check(instruction)) {
                continue;
            }

            int currentTop = top;
            int currentRight = right;
            int currentLeft = left;
            int currentBottom = bottom;
            int currentFront = front;
            int currentBack = back;

            if(instruction == 1) { // 동
                y += 1;
                top = currentLeft;
                right = currentTop;
                left = currentBottom;
                bottom = currentRight;

            } else if(instruction == 2) { // 서
                y -= 1;

                top = currentRight;
                right = currentBottom;
                left = currentTop;
                bottom = currentLeft;

            } else if(instruction == 3) { // 북
                x -= 1;
                top = currentFront;
                bottom = currentBack;
                front = currentBottom;
                back = currentTop;

            } else { // 남
                x += 1;
                top = currentBack;
                bottom = currentFront;
                front = currentTop;
                back = currentBottom;
            }

            if (map[x][y] == 0) {
                map[x][y] = dice[bottom];
            } else {
                dice[bottom] = map[x][y];
                map[x][y] = 0;
            }

            sb.append(dice[top]).append("\n");
        }

        System.out.println(sb);
    }

    static boolean check(int instruction) {
        int nextX = x;
        int nextY = y;
        if (instruction == 1) {
            nextY += 1;
        } else if (instruction == 2) {
            nextY -= 1;
        } else if (instruction == 3) {
            nextX -= 1;
        } else {
            nextX += 1;
        }

        if (nextX >= N || nextX < 0 || nextY >= M || nextY < 0) {
            return false;
        }

        return true;
    }
}
