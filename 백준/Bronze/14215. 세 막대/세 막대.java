import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
    단계별로 풀어보기
    문자열
    1085번 문제: 직사각형
*/

public class Main {

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[3];

        for(int i=0;i<3;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        if(arr[2] >= arr[0] + arr[1]) {
            arr[2] = arr[0] + arr[1] - 1;
        }

        System.out.println(arr[0] + arr[1] + arr[2]);
    }

    public static void main(String args[]) throws Exception{
        Main.solution();
    }
}
