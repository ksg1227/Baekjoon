import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


///*
//    solved.ac
//    class2
//    28702번 문제 : FizzBuzz
//*/
public class Main {

    static void solution() throws IOException {
        StringBuilder sb = new StringBuilder();

        //99999999이하

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int lastNum = 3;
        String result = "";

        for (int i = 0; i < 3; i++) {
            String str = br.readLine();

            if(!str.equals("Fizz") && !str.equals("Buzz") && !str.equals("FizzBuzz")) {
                lastNum = Integer.parseInt(str) + 3 - i;
            }
        }

        if(lastNum % 3 == 0 && lastNum % 5 == 0) {
            result = "FizzBuzz";
        } else if(lastNum % 3 == 0 && lastNum % 5 != 0) {
            result = "Fizz";
        } else if (lastNum % 3 != 0 && lastNum % 5 == 0) {
            result = "Buzz";
        } else if(lastNum % 3 != 0 && lastNum % 5 != 0) {
            result = Integer.toString(lastNum);
        } else{
            result = "Fizz";
        }

        System.out.println(result);
    }


    public static void main(String[] args) throws Exception {
        Main.solution();
    }
}




