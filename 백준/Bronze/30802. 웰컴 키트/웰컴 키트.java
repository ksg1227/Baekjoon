import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] size = new int[6];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 6; i++) {
            size[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        int T = 0;
        int P = 0;

        for (int i = 0; i < 2; i++) {
            if (i == 0) {
                T = Integer.parseInt(st.nextToken());
            } else {
                P = Integer.parseInt(st.nextToken());
            }
        }

        long totalTshirt = 0;
        for (int i = 0; i < 6; i++) {
            totalTshirt += size[i] / T + 1;

            if(size[i] % T == 0) {
                totalTshirt--;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(totalTshirt).append("\n");
        sb.append(N / P).append(" ").append(N % P);

        System.out.println(sb);

    }

    public static void main(String[] args) throws IOException {
        Main.solution();

    }
}
