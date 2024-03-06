import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    단계별로 풀어보기
    심화 1단계
    2941번 문제: 크로아티아 알파벳
*/

public class Main {

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'c') {
                if (i + 1 <= str.length() - 1) {
                    if (str.charAt(i + 1) == '=' || str.charAt(i + 1) == '-') {
                        i++;
                    }
                }
            }
            else if (str.charAt(i) == 'd') {
                if (i + 1 <= str.length() - 1) {
                    if (i + 2 <= str.length() - 1) {
                        if (str.charAt(i + 1) == 'z' && str.charAt(i + 2) == '=') {
                            i += 2;
                            count++;
                            continue;
                        }
                    }
                    if (str.charAt(i + 1) == '-') {
                        i++;
                    }
                }
            }
            else if (str.charAt(i) == 'l' || str.charAt(i) == 'n') {
                if (i + 1 <= str.length() - 1) {
                    if (str.charAt(i + 1) == 'j') {
                        i++;
                    }
                }
            }
            else if(str.charAt(i) == 's' || str.charAt(i) == 'z'){
                if(i+1 <= str.length() - 1){
                    if(str.charAt(i+1) == '='){
                        i++;
                    }
                }
            }


            count++;
        }

        System.out.println(count);


    }

    public static void main(String args[]) throws Exception {
        new Main().solution();
    }
}





