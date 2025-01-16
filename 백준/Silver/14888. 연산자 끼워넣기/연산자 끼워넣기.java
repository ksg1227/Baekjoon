import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 스터디 1주차
 * 백트래킹
 * 백준 14888번 : 연산자 끼워넣기
 */

public class Main {

    static int[] numbers;
    static int N;
    static int plusCount = 0;
    static int minusCount = 0;
    static int mulCount = 0;
    static int divCount = 0;

    static int maxResult = Integer.MIN_VALUE;
    static int minResult = Integer.MAX_VALUE;

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        plusCount = Integer.parseInt(st.nextToken());
        minusCount = Integer.parseInt(st.nextToken());
        mulCount = Integer.parseInt(st.nextToken());
        divCount = Integer.parseInt(st.nextToken());

        backTracking(numbers[0], 0);

        sb.append(maxResult).append("\n");
        sb.append(minResult).append("\n");
        System.out.println(sb);


    }

    static void backTracking(int result, int count) {
        if (count == N - 1) {
            maxResult = Math.max(maxResult, result);
            minResult = Math.min(minResult, result);
            return;
        }

        for (int j = 0; j < 4; j++) {
            if (j == 0) {
                if (plusCount > 0) {
                    plusCount--;
                    backTracking(result + numbers[count + 1], count + 1);
                    plusCount++;
                }
            } else if (j == 1) {
                if (minusCount > 0) {
                    minusCount--;
                    backTracking(result - numbers[count + 1], count + 1);
                    minusCount++;
                }
            } else if (j == 2) {
                if (mulCount > 0) {
                    mulCount--;
                    backTracking(result * numbers[count+1], count + 1);
                    mulCount++;
                }
            } else {
                if (divCount > 0) {
                    divCount--;
                    backTracking(result / numbers[count+1], count + 1);
                    divCount++;
                }
            }


        }

    }

    public static void main(String[] args) throws IOException {
        solution();
    }

}







