import java.io.*;
import java.util.StringTokenizer;


/*     !!!틀렸음!!!
    단계별로 풀어보기
    일반 수학1
    1193번 문제: 분수찾기
*/

public class Main {

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());

        int n = 1;
        int groupnum = 0;

       while(true){
           if((n-1)*(n)/2 < X && n*(n+1)/2 >= X){
               groupnum = n;
               break;
           }
           n++;
       }

       int left = 0;
       int right = 0;

       if(groupnum % 2 == 0){  //아래에서부터
           int x = X - groupnum*(groupnum - 1) / 2;
           left = 1 + (x-1);
           right = groupnum - (x-1);
       }  //위에서부터
       else{
           int x = X - groupnum*(groupnum - 1) / 2;
           left = groupnum - (x-1);
           right = 1 + (x-1);
       }

        System.out.println(left + "/" + right);


    }

    public static void main(String args[]) throws Exception {
        new Main().solution();
    }
}
