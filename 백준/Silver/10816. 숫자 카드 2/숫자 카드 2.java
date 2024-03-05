import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;


/*
    단계별로 풀어보기
    집합과 맵
    10816번 문제: 숫자 카드2
*/

public class Main {
    public static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<N;i++){
            int key = Integer.parseInt(st.nextToken());

            if(!map.containsKey(key)){
                map.put(key,1);
            }
            else{
                int value = map.get(key) + 1;

                map.remove(key);

                map.put(key, value);
            }
        }

        int M = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        for(int i=0;i<M;i++){
            int resultKey = Integer.parseInt(st.nextToken());

            if(!map.containsKey(resultKey)){
                sb.append(0).append(" ");
            }else {
                sb.append(map.get(resultKey)).append(" ");
            }
        }

        System.out.println(sb);

    }

    public static void main(String args[]) throws Exception{
        Main.solution();
    }
}
