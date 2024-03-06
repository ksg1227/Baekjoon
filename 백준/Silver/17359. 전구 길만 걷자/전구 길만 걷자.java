import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    int N;
    int[][] arr2;
    boolean[] v;
    int minCnt = 1001;

    private void recursion(int idx, int last, int cnt){
        if(idx == N){
            if(minCnt > cnt)
                minCnt = cnt;
            return;
        }

        for(int i=0;i<N;i++){
            if(v[i]) continue;
            v[i] = true;
            recursion(idx+1, arr2[i][1],cnt+(last != arr2[i][0] ? 1 : 0));
            v[i] = false;
        }
    }

    public void solution() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(bf.readLine());

        String[] arr1 = new String[N];
        arr2 = new int[N][2];
        v = new boolean[N];

        int count = 0;

        for (int i = 0; i < N; i++) {
            arr1[i] = bf.readLine();

            arr2[i][0] = Character.getNumericValue(arr1[i].charAt(0));
            arr2[i][1] = Character.getNumericValue(arr1[i].charAt(arr1[i].length() - 1));

            for (int j = 0; j < arr1[i].length() - 1; j++) {
                int num = Character.getNumericValue(arr1[i].charAt(j));

                int nextNum = Character.getNumericValue(arr1[i].charAt(j + 1));

                if (num == 1) {
                    if (nextNum == 0) {
                        count++;
                    }
                } else if (num == 0) {
                    if (nextNum == 1) {
                        count++;
                    }
                }
            }
        }
        recursion(0, -1, -1);
        System.out.println(count + minCnt);

    }

    public static void main(String args[]) throws Exception {
        new Main().solution();
    }
}
