import java.io.*;
import java.util.*;


/*
    단계별로 풀어보기
    정렬
    1181번 문제: 단어 정렬
*/

public class Main {

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        ArrayList<String> arr = new ArrayList<>();

        for(int i=0;i<N;i++){
            arr.add(br.readLine());
        }

        Collections.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()){
                    return o1.compareTo(o2);
                }
                else{
                    return o1.length() - o2.length();
                }
            }
        });

        sb.append(arr.get(0)).append("\n");

        for(int i=1;i<arr.size();i++){
            if(!arr.get(i).equals(arr.get(i-1))){
                sb.append(arr.get(i)).append("\n");
            }
        }

        System.out.println(sb);

    }

    public static void main(String args[]) throws Exception {
        new Main().solution();
    }
}

