import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


/*
    solved.ac
    class2
    4153번 문제 : 직각삼각형
 */

public class Main {

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str;
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (!(str = br.readLine()).equals("0 0 0")) {
            ArrayList<Integer> list = new ArrayList<>();

            st = new StringTokenizer(str);

            for (int i = 0; i < 3; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            Collections.sort(list);


            int a = list.get(0);
            int b = list.get(1);
            int c = list.get(2);

            if(Math.pow(c,2) == Math.pow(a,2) + Math.pow(b,2)){
                sb.append("right").append("\n");
            }else{
                sb.append("wrong").append("\n");
            }

        }

        System.out.println(sb);


    }


    public static void main(String[] args) throws Exception {
        Main.solution();
    }
}
