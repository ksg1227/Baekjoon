import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    단계별로 풀어보기
    심화 1단계
    25206번 문제: 너의 평점은
*/

public class Main {

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double sum = 0, total = 0;
        //sum = 학점 * 과목평점
        //total = 학점의 총합


        for (int i = 0; i < 20; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String major = st.nextToken();
            double myscore = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();

            total += myscore;

            switch(grade) {
                case "A+":
                    sum += myscore * 4.5;
                    break;
                case "A0":
                    sum += myscore * 4.0;
                    break;
                case "B+":
                    sum += myscore * 3.5;
                    break;
                case "B0":
                    sum += myscore * 3.0;
                    break;
                case "C+":
                    sum += myscore * 2.5;
                    break;
                case "C0":
                    sum += myscore * 2.0;
                    break;
                case "D+":
                    sum += myscore * 1.5;
                    break;
                case "D0":
                    sum += myscore * 1.0;
                    break;
                case "F":
                    sum += myscore * 0;
                    break;
                case "P":
                    total -= myscore;
                    break;
            }
        }

        System.out.println(sum / total);

    }

    public static void main(String args[]) throws Exception {
        new Main().solution();
    }
}





