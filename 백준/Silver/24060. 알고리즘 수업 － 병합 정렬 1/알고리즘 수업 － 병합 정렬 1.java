import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    단계별로 풀어보기
    재귀
    24060번 문제: 알고리즘 수업 - 병합 정렬 1
*/

public class Main {

    static int N;
    static int K;
    static int[] resultArr;
    static int[] temp;
    static int count = 0;
    static int result = 0;

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        resultArr = new int[N];
        temp = new int[N];

        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            resultArr[i] = num;
        }

        merge_sort(resultArr, 0, N - 1);

        if(result == 0){
            System.out.println(-1);
        }
        else {
            System.out.println(result);
        }

    }

    static void merge_sort(int[] arr, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            merge_sort(arr, p, q);
            merge_sort(arr, q + 1, r);
            merge(arr, p, q, r);
        }
    }

    static void merge(int[] arr, int p, int q, int r) {
        int i = p;
        int j = q + 1;
        int t = 0;

        while (i <= q && j <= r) {
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t++;
                i++;
            } else {
                temp[t] = arr[j];
                t++;
                j++;
            }
        }

        while (i <= q) {
            temp[t] = arr[i];
            t++;
            i++;
        }

        while (j <= r) {
            temp[t] = arr[j];
            t++;
            j++;
        }

        i = p;
        t = 0;

        while (i <= r) {
            arr[i] = temp[t];
            count++;
            if(count == K){
                result = temp[t];
            }
            i++;
            t++;
        }
    }


    public static void main(String[] args) throws Exception {
        Main.solution();

    }

}








