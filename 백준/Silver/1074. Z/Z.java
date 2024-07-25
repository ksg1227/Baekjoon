import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * solved.ac
 * class 3
 * 1074번 문제 : Z
 */

public class Main {

    static int N;
    static int r;
    static int c;
    static int count = 0;

    static int size;


    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        size = (int) Math.pow(2, N);

        find(r, c, size);

        System.out.println(count);

    }

    static void find(int r, int c, int size) {
        if (size == 1) {
            return;
        }

        if (r < size / 2 && c < size / 2) {   //왼쪽 위
            find(r, c, size / 2);
        } else if (r < size / 2 && c >= size / 2) {  //오른쪽 위
            count += size * size / 4;
            find(r, c - size / 2, size / 2);
        } else if (r >= size / 2 && c < size / 2) {  //왼쪽 아래
            count += (size * size / 4) * 2;
            find(r - size / 2, c, size / 2);
        } else {  //오른쪽 아래
            count += (size * size / 4) * 3;
            find(r - size / 2, c - size / 2, size / 2);
        }
    }


    public static void main(String[] args) throws Exception {
        Main.solution();
    }
}
