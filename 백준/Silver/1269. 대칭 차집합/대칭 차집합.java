import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;


/*
    단계별로 풀어보기
    집합과 맵
    1269번 문제: 대칭 차집합
*/

public class Main {
    public static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        HashSet<Integer> set = new HashSet<Integer>();

        st = new StringTokenizer(br.readLine());

        for(int i=0;i<A;i++){
            int num = Integer.parseInt(st.nextToken());
            set.add(num);
        }
        
        st = new StringTokenizer(br.readLine());

        for(int i=0;i<B;i++){
            int num = Integer.parseInt(st.nextToken());

            if(set.contains(num)){
                set.remove(num);
            }
            else{
                set.add(num);
            }
        }

        System.out.println(set.size());

    }

    public static void main(String args[]) throws Exception {
        Main.solution();
    }
}
