import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
    단계별로 풀어보기
    심화 2
    26069번 문제: 붙임성 좋은 총총이
*/

public class Main {

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        double firstResult = 0.0;

        HashMap<Integer, Integer> map = new HashMap<>();

        ArrayList<Integer> list = new ArrayList<>();

        int maxCount = 1;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                int value = map.get(num);
                map.replace(num, value + 1);

                maxCount = Math.max(maxCount, value + 1);
            }

            list.add(num);
            firstResult += num;
        }


        Collections.sort(list);

        //산술 평균
        sb.append(Math.round(firstResult/N)).append("\n");

        //중앙값
        int middle = list.get(list.size() / 2);
        sb.append(middle).append("\n");


        //최빈값
        ArrayList<Integer> maxList = new ArrayList<>();

        for (Map.Entry<Integer, Integer> mp : map.entrySet()) {
            if(mp.getValue().equals(maxCount)){
                maxList.add(mp.getKey());
            }
        }

        Collections.sort(maxList);

        if(maxList.size() >= 2){
            sb.append(maxList.get(1)).append("\n");
        }else{
            sb.append(maxList.get(0)).append("\n");
        }

        //범위
        int first = list.get(0);
        int last = list.get(list.size() - 1);

        sb.append(last - first).append("\n");


        System.out.println(sb);

    }

    public static void main(String args[]) throws Exception {
        Main.solution();

    }

}








