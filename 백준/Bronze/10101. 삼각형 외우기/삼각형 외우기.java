import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    단계별로 풀어보기
    문자열
    10101번 문제: 삼각형 외우기
*/

public class Main {

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int first = Integer.parseInt(br.readLine());
        int second = Integer.parseInt(br.readLine());
        int third = Integer.parseInt(br.readLine());

        if(first == 60 && second == 60 && third == 60){
            System.out.println("Equilateral");
        }
        else if(first + second + third == 180 && (first == second || first == third  || second == third )){
            System.out.println("Isosceles");
        }
        else if(first + second + third == 180 && first != second && first != third && second != third){
            System.out.println("Scalene");
        }
        else if(first + second + third != 180){
            System.out.println("Error");
        }

    }

    public static void main(String args[]) throws Exception{
        Main.solution();
    }
}
