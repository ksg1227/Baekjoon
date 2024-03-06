import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/*
    단계별로 풀어보기
    심화 1단계
    1157번 문제: 단어 공부
*/

public class Main {

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[26];

        for (int i = 0; i < 26; i++) {
            arr[i] = 0;
        }

        String str = br.readLine();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 'a') {
                arr[str.charAt(i) - 'a']++;
            } else {
                arr[str.charAt(i) - 'A']++;
            }
        }

        int max = 0;
        int index = 0;
        int count = 0;

        for (int i = 0; i < 26; i++) {
            if(max == arr[i]){
                count++;
            }
            else if(max < arr[i]){
                max = arr[i];
                index = i;
                count = 0;
            }
        }

        if(count != 0){
            System.out.println("?");
        }
        else{
            char c = (char) ('A' + index);
            System.out.println(c);
        }


    }

    public static void main(String args[]) throws Exception {
        new Main().solution();
    }
}





