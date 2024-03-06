import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String args[]) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(bf.readLine());

        ArrayList<String> arr = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            arr.add(bf.readLine());
        }


        for (int i = 0; i < arr.size(); i++) {
            int total = 0;
            for (int j = 0; j < arr.get(i).length(); j++) {
                int count = 0;
                if (arr.get(i).charAt(j) == 'O') {
                    for (int k = j; k >= 0; k--) {
                        if(arr.get(i).charAt(k) == 'O'){
                            count++;
                        }else{
                            break;
                        }
                    }
                }
                total += count;
            }
            System.out.println(total);
        }
    }
}
