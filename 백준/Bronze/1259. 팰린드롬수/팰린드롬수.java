import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*
    solved.ac
    class2
    1259번 문제 : 펠린드롬수
 */
public class Main {

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = "";

        while (!(str = br.readLine()).equals("0")) {
            String reverseStr = "";
            for (int i = str.length() - 1; i >= 0; i--) {
                reverseStr += str.charAt(i);
            }
            
            if(str.equals(reverseStr)){
                System.out.println("yes");
            }else{
                System.out.println("no");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Main.solution();
    }
}
