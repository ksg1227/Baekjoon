import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;


/*
    단계별로 풀어보기
    집합과 맵
    14425번 문제: 문자열 집합
*/

public class Main {
    public static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<String> set = new HashSet<>();

        for(int i=0;i<N;i++){
            set.add(br.readLine());
        }

        int count = 0;

        for(int i=0;i<M;i++){
            String str = br.readLine();
            
            if(set.contains(str)){
                count++;
            }
        }

        System.out.println(count);
    }

    public static void main(String args[]) throws Exception{
        Main.solution();
    }
}
