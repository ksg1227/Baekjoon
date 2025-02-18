import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 스터디 7주차
 * 그리디
 * 백준 2839번 : 설탕 배달
 */

public class Main {

    static int N;

    static int result = 0;

    static PriorityQueue<Integer> queue = new PriorityQueue<>();

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            queue.add(num);
        }


        if (N >= 2) {
            while (!queue.isEmpty()) {
                int firstMin = queue.poll();

                if (queue.isEmpty()) {  // 더이상 데이터가 없을 때
                    break;
                }

                int secondMin = queue.poll();

                int sum = firstMin + secondMin;

                result += sum;

                queue.add(sum);
            }

            System.out.println(result);
        } else {
            System.out.println(0);
        }


    }


    public static void main(String[] args) throws IOException {
        solution();
    }

}








