import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
    단계별로 풀어보기
    브루트포스
    1018번 문제: 체스판 다시 칠하기
*/

public class Main {

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] arr = new String[N];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        int min = N * M;


        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {

                int wcount = 0;
                int bcount = 0;

                for (int k = i + 1; k < i + 9; k++) {
                    for (int l = j + 1; l < j + 9; l++) {
                        for (int m = 0; m < 2; m++) {
                            if ((k % 2 == 1 && l % 2 == 1) || (k % 2 == 0 && l % 2 == 0)) {
                                if (m == 0) {
                                    if (arr[k - 1].charAt(l - 1) == 'B') {
                                        wcount++;
                                    }
                                } else {
                                    if (arr[k - 1].charAt(l - 1) == 'W') {
                                        bcount++;
                                    }
                                }
                            } else if ((k % 2 == 1 && l % 2 == 0) || (k % 2 == 0 && l % 2 == 1)) {
                                if (m == 0) {
                                    if (arr[k - 1].charAt(l - 1) == 'W') {
                                        wcount++;
                                    }
                                } else {
                                    if (arr[k - 1].charAt(l - 1) == 'B') {
                                        bcount++;
                                    }
                                }
                            }

                        }
                    }
                }

                int tempMin = Math.min(wcount, bcount);
                min = Math.min(tempMin, min);
            }
        }

        System.out.println(min);


    }

    public static void main(String args[]) throws Exception {
        new Main().solution();
    }
}


