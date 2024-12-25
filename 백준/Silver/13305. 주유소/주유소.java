import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
    단계별로 풀어보기
    그리디
    13305번 : 주유소
*/

public class Main {

    // 원 안에 있는 숫자 : 해당 도시의 리터당 기름 가격
    // 도로 위의 숫자 : 도로의 길이

    // 만약 현재 도시의 기름이 가장 싸지 않다면, 자기보다 싼 주유소의 위치까지의 거리만큼 필요한 기름은 자기 위치에서 다 구매하면 됨
    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long totalMoney = 0;

        int N = Integer.parseInt(br.readLine());

        long[] distances = new long[N - 1];
        long[] fuels = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N - 1; i++) {
            distances[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            fuels[i] = Integer.parseInt(st.nextToken());
        }

        // 다음 주유소의 가격이 현재 주유소보다 싸다면, 다음 주유소까지의 거리만 결제
        // 다음 주유소의 가격이 현재 주유소보다 비싸다면, 우선 다음 주유소까지의 거리 + 그 다음 주유소의 가격도 확인
        long minimumFuel = fuels[0];
        for (int i = 0; i < N - 1; i++) {
            if (minimumFuel > fuels[i]) {
                minimumFuel = fuels[i];
                totalMoney += minimumFuel * distances[i];
            } else {
                totalMoney += minimumFuel * distances[i];
            }
        }

        System.out.println(totalMoney);


    }

    public static void main(String args[]) throws Exception {
        solution();
    }
}

