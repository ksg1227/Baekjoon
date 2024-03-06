import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*
    단계별로 풀어보기
    시간 복잡도
    24265번 문제: 알고리즘 수업 - 알고리즘의 수행 시간4
*/

public class Main {

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Integer.parseInt(br.readLine());

        System.out.println((n * (n - 1) / 2));
        System.out.println(2);
    }

    public static void main(String args[]) throws Exception {
        new Main().solution();
    }
}

