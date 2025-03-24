import java.io.*;
import java.util.*;

public class Main {

    // 자릿수가 높으면서 빈도가 높은 것들에 우선순위 부여

    static int N;

    static int rank = 9;

    static Map<Character, Integer> frequency = new HashMap<>();

    static PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.reverseOrder());

    static List<String> inputs = new ArrayList<>();

    static int result = 0;

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            inputs.add(line);

            char[] arr = line.toCharArray();

            int digit = 0;
            for (int j = arr.length - 1; j >= 0; j--) {
                frequency.put(arr[j], frequency.getOrDefault(arr[j], 0) + (int) Math.pow(10, digit));
                digit++;
            }
        }

        for (Character c : frequency.keySet()) {
            pq.offer(new Node(c, frequency.get(c)));
        }

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            frequency.put(node.alphabet, rank--);
        }

        for (int i = 0; i < inputs.size(); i++) {
            result += stringToInt(inputs.get(i));
        }

        System.out.println(result);

    }

    static class Node implements Comparable<Node> {
        Character alphabet;
        int value;

        public Node(Character alphabet, int value) {
            this.alphabet = alphabet;
            this.value = value;
        }

        @Override
        public int compareTo(Node node) {
            return this.value - node.value;
        }
    }

    static int stringToInt(String input) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            sb.append(frequency.get(input.charAt(i)));
        }

        return Integer.parseInt(sb.toString());
    }


    public static void main(String[] args) throws IOException {
        solution();
    }
}
