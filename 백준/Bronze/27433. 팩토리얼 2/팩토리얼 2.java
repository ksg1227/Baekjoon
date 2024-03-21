import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/*
    단계별로 풀어보기
    재귀
    27433번 문제: 팩토리얼 2
*/

public class Main {

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Integer.parseInt(br.readLine());

        if(N == 0){
            System.out.println(1);
        }else {
            System.out.println(fac(N));
        }

    }

    static long fac(long n){
        if(n == 1){
            return n;
        }else{
            return n * fac(n-1);
        }
    }

    public static void main(String[] args) throws Exception {
        Main.solution();

    }

}








