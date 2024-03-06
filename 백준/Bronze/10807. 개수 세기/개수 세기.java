import java.io.*;
import java.util.StringTokenizer;


/*     
    단계별로 풀어보기
    1차원 배열
    10807번 문제: 개수 세기
*/

public class Main {

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] arr = new int[N];
        
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int v = Integer.parseInt(br.readLine());
        
        int count = 0;
        
        for(int i=0;i<N;i++){
            if(arr[i] == v){
                count++;
            }
        }

        System.out.println(count);

    }

    public static void main(String args[]) throws Exception {
        new Main().solution();
    }
}
