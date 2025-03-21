import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 스터디 11주차
 * 그리디
 * 백준 2012번 : 등수 매기기
 */

public class Main {

    static long result;
    static int N;
    static List<Integer> nums = new ArrayList<>();

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            nums.add(num);
        }

        Collections.sort(nums);

        int rank = 1;

        for (int i = 0; i < nums.size(); i++) {
            result += Math.abs(nums.get(i) - rank);
            rank++;
        }

        System.out.println(result);
    }


    public static void main(String[] args) throws IOException {
        solution();
    }

}








