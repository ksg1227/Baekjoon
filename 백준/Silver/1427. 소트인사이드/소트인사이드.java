import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


/*
    단계별로 풀어보기
    정렬
    1427번 문제: 소트인사이드
*/

public class Main {

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String N = br.readLine();

        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < N.length(); i++) {
            arr.add(Character.getNumericValue(N.charAt(i)));
        }

        Collections.sort(arr);

        StringBuilder sb = new StringBuilder();

        for (int i = arr.size()-1;i>=0;i--){
            sb.append(arr.get(i));
        }

        System.out.println(sb);


    }

    public static void main(String args[]) throws Exception {
        new Main().solution();
    }
}

