import java.io.*;
import java.util.StringTokenizer;

/*
    단계별로 풀어보기
    문자열
    5622번 문제: 다이얼
*/

public class Main {


    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int total = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c == 'A' || c == 'B' || c == 'C') {
                total += 3;
            } else if (c == 'D' || c == 'E' || c == 'F') {
                total += 4;
            } else if (c == 'G' || c == 'H' || c == 'I') {
                total += 5;
            } else if (c == 'J' || c == 'K' || c == 'L') {
                total += 6;
            } else if (c == 'M' || c == 'N' || c == 'O') {
                total += 7;
            } else if (c == 'P' || c == 'Q' || c == 'R' || c == 'S') {
                total += 8;
            } else if (c == 'T' || c == 'U' || c == 'V') {
                total += 9;
            } else if (c == 'W' || c == 'X' || c == 'Y' || c == 'Z') {
                total += 10;
            }
        }

        System.out.println(total);

    }

    public static void main(String args[]) throws Exception {
        new Main().solution();
    }
}

