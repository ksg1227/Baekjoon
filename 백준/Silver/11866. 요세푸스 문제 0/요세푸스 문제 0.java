import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

/*
    단계별로 풀어보기
    스택, 큐, 덱
    11866번 문제: 요세푸스 문제0
 */

public class Main {

    public static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int K = Integer.parseInt(st.nextToken());

        ArrayList<Integer> list = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        sb.append("<");

        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        int currentIndex = -1;

        for (int i = 0; i < N; i++) {
            if (currentIndex + K > list.size() - 1) {

                int temp = K;

                while (temp > 0) {
                    if (currentIndex == list.size() - 1) {
                        currentIndex = 0;
                    } else {
                        currentIndex++;
                    }
                    temp--;
                }

                sb.append(list.remove(currentIndex));
                currentIndex--;
            } else {
                if (currentIndex + K > list.size() - 1) {

                    int temp = K;

                    while (temp > 0) {
                        if (currentIndex == list.size() - 1) {
                            currentIndex = 0;
                        } else {
                            currentIndex++;
                        }
                        temp--;
                    }
                } else {
                    currentIndex += K;
                }

                sb.append(list.remove(currentIndex));
                currentIndex--;

            }
            if (i != N - 1) {
                sb.append(", ");
            } else {
                sb.append(">");
            }
        }

        System.out.println(sb);
    }

    public static void main(String args[]) throws Exception {
        Main.solution();
    }
}
