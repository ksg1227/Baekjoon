import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;

    static ArrayList<Integer>[] friend;

    static boolean[] isFriend;

    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // n 번째 사람이 k 번째 사람이랑 친구인지 추적
        friend = new ArrayList[N];
        isFriend = new boolean[N];

        for (int i = 0; i < N; i++) {
            friend[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            friend[a].add(b);
            friend[b].add(a);
        }

        for (int i = 0; i < N; i++) {
            isFriend[i] = true;
            check(i, 1);
            isFriend[i] = false;
        }

        System.out.println(result);

    }

    static void check(int current, int count) {

        if (result == 1) {
            return;
        }

        if (count == 5) {
            result = 1;
            return;
        }

        for (int i = 0; i < friend[current].size(); i++) {
            int peer = friend[current].get(i);

            if (!isFriend[peer]) {
                isFriend[peer] = true;
                check(peer, count + 1);
                isFriend[peer] = false;
            }
        }
    }

    static void print() {
        for (int i = 0; i < N; i++) {
            System.out.print(isFriend[i]);
        }
        System.out.println();
    }
}
