import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
    단계별로 풀어보기
    조건문
    9498번 문제: 시험 성적
*/

public class Main{

    static void solution() throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int score = Integer.parseInt(br.readLine());

        String result = "";
        if(score >= 90 && score <= 100)
            result = "A";
        else if(score >= 80 && score <= 89)
            result = "B";
        else if(score >= 70 && score <= 79)
            result = "C";
        else if(score >= 60 && score <= 69)
            result = "D";
        else
            result = "F";

        System.out.println(result);
    }

    public static void main(String args[]) throws Exception {
        new Main().solution();
    }
}