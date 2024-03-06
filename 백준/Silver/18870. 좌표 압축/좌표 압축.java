import java.io.*;
import java.util.*;


/*
    단계별로 풀어보기
    정렬
    18870번 문제: 좌표 압축
*/

public class Main {

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] origin = new int[N];
        int[] sorted = new int[N];

        HashMap<Integer, Integer> rankingMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            origin[i] = num;
            sorted[i] = num;
        }

        Arrays.sort(sorted);

        int rank = 0;

        for (int i = 0; i < N; i++) {
            if(!rankingMap.containsKey(sorted[i])){
                rankingMap.put(sorted[i],rank);
                rank++;
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<N;i++){
            sb.append(rankingMap.get(origin[i])).append(" ");
        }

        System.out.println(sb);




    }

    public static void main(String args[]) throws Exception {
        new Main().solution();
    }
}

