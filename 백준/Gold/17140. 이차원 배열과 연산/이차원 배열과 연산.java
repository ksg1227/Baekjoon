import java.io.*;
import java.util.*;

public class Main {

    // 다 가변이어야함
    // List를 요소로 갖는 List


    static int r;
    static int c;
    static int k;

    static int result;

    // 모든 행이나 열에서, 서로 다른 숫자의 개수 * 2 가 길이임

    // 최대 길이를 구해두고, 일단 채운 이후에 그 뒤를 다 0으로 채우기


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken()) - 1;
        c = Integer.parseInt(st.nextToken()) - 1;
        k = Integer.parseInt(st.nextToken());

        int[][] arr = new int[3][3];

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        findMin(arr, 3, 3, 0);

        System.out.println(result);


    }

    // r 하는 경우, c 하는 경우
    static void findMin(int[][] arr, int rowSize, int colSize, int time) {
        if (time > 100) {
            result = -1;
            return;
        }

        if (check(arr, rowSize, colSize)) {
            result = time;
            return;
        }

        if (rowSize >= colSize) {
            R(arr, rowSize, colSize, time);
        } else {
            C(arr, rowSize, colSize, time);
        }

    }

    static void R(int[][] arr, int rowSize, int colSize, int time) {

        Map<Integer, Integer> frequency = new HashMap<>();

        PriorityQueue<Node> pq = new PriorityQueue<>();

        // 값들을 저장해둘 리스트 배열
        List<Integer>[] list = new ArrayList[rowSize];

        for (int i = 0; i < rowSize; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < rowSize; i++) {


            for (int j = 0; j < colSize; j++) {
                if (arr[i][j] != 0) {
                    frequency.put(arr[i][j], frequency.getOrDefault(arr[i][j], 0) + 1);
                }
            }

            for (int key : frequency.keySet()) {
                pq.offer(new Node(key, frequency.get(key)));
            }

            int size = 0;
            while (!pq.isEmpty()) {

                if (size == 100) {
                    break;
                }

                Node node = pq.poll();

                int value = node.value;
                int count = node.count;

                list[i].add(value);
                list[i].add(count);

                size += 2;
            }

            frequency.clear();

        }

        int maxColSize = 0;
        for (int i = 0; i < rowSize; i++) {
            maxColSize = Math.max(maxColSize, list[i].size());
        }

        int[][] sortMap = new int[rowSize][maxColSize];

        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < list[i].size(); j++) {
                sortMap[i][j] = list[i].get(j);
            }

            for (int j = list[i].size(); j < maxColSize; j++) {
                sortMap[i][j] = 0;
            }
        }

        findMin(sortMap, rowSize, maxColSize, time + 1);

    }


    static void C(int[][] arr, int rowSize, int colSize, int time) {
        Map<Integer, Integer> frequency = new HashMap<>();

        PriorityQueue<Node> pq = new PriorityQueue<>();

        // 값들을 저장해둘 리스트 배열
        List<Integer>[] list = new ArrayList[colSize];

        for (int i = 0; i < colSize; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < colSize; i++) {


            for (int j = 0; j < rowSize; j++) {
                if (arr[j][i] != 0) {
                    frequency.put(arr[j][i], frequency.getOrDefault(arr[j][i], 0) + 1);
                }
            }

            for (int key : frequency.keySet()) {
                pq.offer(new Node(key, frequency.get(key)));
            }

            int size = 0;
            while (!pq.isEmpty()) {

                if (size == 100) {
                    break;
                }

                Node node = pq.poll();

                int value = node.value;
                int count = node.count;

                list[i].add(value);
                list[i].add(count);

                size += 2;
            }

            frequency.clear();

        }

        int maxRowSize = 0;
        for (int i = 0; i < colSize; i++) {
            maxRowSize = Math.max(maxRowSize, list[i].size());
        }

        int[][] sortMap = new int[maxRowSize][colSize];

        for (int i = 0; i < colSize; i++) {
            for (int j = 0; j < list[i].size(); j++) {
                sortMap[j][i] = list[i].get(j);
            }

            for (int j = list[i].size(); j < maxRowSize; j++) {
                sortMap[j][i] = 0;
            }
        }

        findMin(sortMap, maxRowSize, colSize, time + 1);
    }


    static boolean check(int[][] arr, int rowSize, int colSize) {

        if (rowSize - 1 < r || colSize - 1 < c) {
            return false;
        }

        if (arr[r][c] == k) {
            return true;
        }

        return false;
    }


    static class Node implements Comparable<Node> {
        int value;
        int count;

        Node(int value, int count) {
            this.value = value;
            this.count = count;
        }

        public int compareTo(Node o) {
            if (this.count == o.count) {
                return this.value - o.value;
            }

            return this.count - o.count;
        }

    }

}

