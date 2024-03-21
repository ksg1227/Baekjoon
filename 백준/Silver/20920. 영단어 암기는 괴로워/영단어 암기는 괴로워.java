import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/*
    단계별로 풀어보기
    심화 2
    26069번 문제: 붙임성 좋은 총총이
*/

public class Main {

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map = new HashMap<>();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String word = br.readLine();

            if (word.length() >= M) {
                if (!map.containsKey(word)) {
                    map.put(word, 1);
                } else {
                    int value = map.get(word);
                    map.replace(word, value + 1);
                }
            }
        }

        Set<Map.Entry<String, Integer>> entry = map.entrySet();

        List<Map.Entry<String, Integer>> list = new ArrayList<>(entry);

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if ((o1.getValue() > o2.getValue()) || (o1.getValue() < o2.getValue())) {
                    return o2.getValue() - o1.getValue();
                } else if ((o1.getKey().length() > o2.getKey().length()) || (o1.getKey().length() < o2.getKey().length())) {
                    return o2.getKey().length() - o1.getKey().length();
                } else {
                    return o1.getKey().compareTo(o2.getKey());
                }
            }
        });

        for (Map.Entry<String, Integer> stringIntegerEntry : list) {
            sb.append(stringIntegerEntry.getKey()).append("\n");
        }

        System.out.println(sb);

    }

    public static void main(String[] args) throws Exception {
        Main.solution();

    }

}








