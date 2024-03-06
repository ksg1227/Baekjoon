import java.io.*;

/*
    단계별로 풀어보기
    문자열
    10809번 문제: 알파벳 찾기
*/

public class Main {

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();

        //26개

        StringBuilder sb = new StringBuilder();
        for (char i = 'a'; i <= 'z'; i++) {
            boolean flag = false;
            for (int j = 0; j < S.length(); j++) {
                if(S.charAt(j) == i){
                    sb.append(j).append(" ");
                    flag = true;
                    break;
                }
            }
            if(!flag){
                sb.append(-1).append(" ");
            }
        }

        System.out.println(sb);



    }

    public static void main(String args[]) throws Exception {
        new Main().solution();
    }
}

