import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    단계별로 풀어보기
    심화 1단계
    1316번 문제: 그룹 단어 체커
*/

public class Main {

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[26];

        int count = 0;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            for (int k = 0; k < 26; k++) {
                arr[k] = -1;
            }

            boolean flag = true;

            for (int j = 0; j < str.length(); j++) {
                int temp = arr[str.charAt(j) - 'a'];
                arr[str.charAt(j) - 'a'] = j;

                if(temp != -1){
                    if(arr[str.charAt(j) - 'a'] - temp != 1){
                        flag = false;
                    }
                }

            }

            if(flag){
                count++;
            }

        }

        System.out.println(count);


    }

    public static void main(String args[]) throws Exception {
        new Main().solution();
    }
}





