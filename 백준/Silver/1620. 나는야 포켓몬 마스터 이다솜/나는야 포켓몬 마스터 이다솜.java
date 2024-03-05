import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;


/*
    단계별로 풀어보기
    집합과 맵
    1620번 문제: 나는야 포켓몬 마스터 이다솜
*/

public class Main {
    public static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, String> map = new HashMap<>();

        for(int i=0;i<N;i++){
            String pocketMonName = br.readLine();
            String pocketMonNum = Integer.toString(i+1);

            map.put(pocketMonName, pocketMonNum);
            map.put(pocketMonNum, pocketMonName);
        }

        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<M;i++){
            String str = br.readLine();

            sb.append(map.get(str)).append("\n");
        }

        System.out.println(sb);

//        HashMap<String, Integer> map1 = new HashMap<>();
//        HashMap<Integer, String> map2 = new HashMap<>();
//
//        for(int i=1;i<=N;i++){
//            String pocketMonName = br.readLine();
//            map1.put(pocketMonName, i);
//            map2.put(i, pocketMonName);
//        }
//
//        for(int i=0;i<M;i++){
//
//            String str = "";
//
//            try{
//                str = br.readLine();
//                int num = Integer.parseInt(str);
//
//                System.out.println(map2.get(num));
//            } catch (NumberFormatException e) {
//                System.out.println(map1.get(str));
//            }
//
//        }

    }

    public static void main(String args[]) throws Exception{
        Main.solution();
    }
}
