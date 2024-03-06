import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = new String[2];

        arr[0] = br.readLine();
        arr[1] = br.readLine();

        int mainNum = Integer.parseInt(arr[0]);
        int subNum = Integer.parseInt(arr[1]);
        int firsttk = subNum % 10;
        int secondtk = (subNum % 100) / 10;
        int thirdtk = subNum / 100;

        System.out.println(mainNum * firsttk);
        System.out.println(mainNum * secondtk);
        System.out.println(mainNum * thirdtk);
        System.out.println(mainNum * subNum);
    }

    public static void main(String args[]) throws Exception {
        new Main().solution();
    }
}