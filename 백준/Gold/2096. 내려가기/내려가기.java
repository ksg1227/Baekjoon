import java.io.*;
import java.util.*;

public class Main {

    static int N;

    static int[] maxDp = new int[3];
    static int[] minDp = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 3; i++) {
            int num = Integer.parseInt(st.nextToken());
            maxDp[i] = num;
            minDp[i] = num;
        }

        for (int i = 1; i <= N - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            int third = Integer.parseInt(st.nextToken());

            int newMaxFirst = first + Math.max(maxDp[0], maxDp[1]);
            int newMaxSecond = second + Math.max(Math.max(maxDp[0], maxDp[1]), maxDp[2]);
            int newMaxThird = third + Math.max(maxDp[1], maxDp[2]);

            int newMinFirst = first + Math.min(minDp[0], minDp[1]);
            int newMinSecond = second + Math.min(Math.min(minDp[0], minDp[1]), minDp[2]);
            int newMinThird = third + Math.min(minDp[1], minDp[2]);

            maxDp[0] = newMaxFirst;
            maxDp[1] = newMaxSecond;
            maxDp[2] = newMaxThird;

            minDp[0] = newMinFirst;
            minDp[1] = newMinSecond;
            minDp[2] = newMinThird;

        }

        int max = Math.max(Math.max(maxDp[0], maxDp[1]), maxDp[2]);
        int min = Math.min(Math.min(minDp[0], minDp[1]), minDp[2]);

        System.out.println(max + " " + min);

    }


}
