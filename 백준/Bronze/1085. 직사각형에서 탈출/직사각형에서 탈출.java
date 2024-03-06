import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    단계별로 풀어보기
    문자열
    1085번 문제: 직사각형
*/

public class Main {

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        
        int left = 0, right = 0, top = 0, bottom = 0;
        
        left = x;
        right = w - x;
        top = h - y;
        bottom = y;
        
        int min = Math.min(left, right);
        min = Math.min(min, top);
        min = Math.min(min, bottom);

        System.out.println(min);
        
        
    }

    public static void main(String args[]) throws Exception{
        Main.solution();
    }
}
