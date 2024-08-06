import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/*
    단계별로 풀어보기
    재귀
    11729번 문제: 하노이 탑 이동 순서
    
    방식을 몰라서 풀이를 참고함
*/

public class Main {

    static StringBuilder sb = new StringBuilder();

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        sb.append(countHanoi(N)).append("\n");

        printHanoi(N, 1, 2, 3);

        System.out.println(sb);


    }

    static void printHanoi(int n, int start, int mid, int to) {

        if (n == 1) {
            sb.append(start + " " + to + "\n");
            return;
        }

        printHanoi(n - 1, start, to, mid);

        sb.append(start + " " + to + "\n");

        printHanoi(n - 1, mid, start, to);
    }

    static int countHanoi(int n) {
        if (n == 1) {
            return 1;
        } else {
            return 2 * countHanoi(n - 1) + 1;
        }
    }

    public static void main(String[] args) throws Exception {
        Main.solution();

    }

}








