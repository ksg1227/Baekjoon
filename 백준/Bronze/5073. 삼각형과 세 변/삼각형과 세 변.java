import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
    단계별로 풀어보기
    문자열
    5073번 문제: 삼각형과 세 변
*/

public class Main {

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = "";
        while(!(str = br.readLine()).equals("0 0 0")){
            StringTokenizer st = new StringTokenizer(str);

            int[] arr = new int[3];



            for(int i=0;i<3;i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            if(arr[2] >= arr[0] + arr[1]){
                System.out.println("Invalid");
            }
            else {
                if (arr[0] == arr[1] && arr[0] == arr[2] && arr[1] == arr[2]) {
                    System.out.println("Equilateral");
                } else if ((arr[0] == arr[1] && arr[0] != arr[2]) || (arr[0] == arr[2] && arr[0] != arr[1]) || (arr[1] == arr[2] && arr[0] != arr[1])) {
                    System.out.println("Isosceles");
                } else if (arr[0] != arr[1] && arr[0] != arr[2] && arr[1] != arr[2]) {
                    System.out.println("Scalene");
                }
            }
        }

    }

    public static void main(String args[]) throws Exception{
        Main.solution();
    }
}
