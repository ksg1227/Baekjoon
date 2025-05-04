import java.io.*;
import java.util.*;

public class Main {

    // 회전한다. 라는 개념 자체를 Deque 로 표현 가능
    // 근데 동쪽, 서쪽을 표현하려면 LinkedList 가 좀 더 나을 듯. 매번 추적하는 건 귀찮음

    // 맨 앞 - 12시 방향 -> 시계 방향으로
    // 만약 시계 방향으로 회전하면 -> 맨 뒤에 것이 맨 앞으로 오는 것임
    // 만약 반시계 방향으로 회전하면 -> 맨 앞의 것이 맨 뒤로 가는 것임

    // 차례대로 전파되는 형태
    // 만약 극이 같으면 현재 톱니바퀴와 반대 방향으로 돔
    // 만약 극이 다르면 전파됨

    // dfs 로 풀 수 있을 듯 - 왼쪽 방향으로 dfs, 오른쪽 방향으로 dfs

    // N 극 : 0, S 극 : 1
    // 시계 방향 : 1, 반시계 방향 : -1

    static List<List<Integer>> wheels = new ArrayList<>();

    static List<Integer> first = new LinkedList<>();
    static List<Integer> second = new LinkedList<>();
    static List<Integer> third = new LinkedList<>();
    static List<Integer> fourth = new LinkedList<>();

    static int K;

    static int sum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        wheels.add(first);
        wheels.add(second);
        wheels.add(third);
        wheels.add(fourth);

        for (int i = 0; i < 4; i++) {
            String input = br.readLine();
            for (int j = 0; j < input.length(); j++) {
                int ch = input.charAt(j) - '0';

                wheels.get(i).add(ch);
            }
        }

        K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int index = Integer.parseInt(st.nextToken()) - 1;
            int direction = Integer.parseInt(st.nextToken());

            // 우선 현재꺼를 먼저 돌림
            List<Integer> currentWheel = wheels.get(index);

            // 왼쪽 극
            int leftMagnet = currentWheel.get(6);

            // 오른쪽 극
            int rightMagnet = currentWheel.get(2);

            rotate(index, direction);

            rotateLeft(index, direction, leftMagnet);
            rotateRight(index, direction, rightMagnet);

        }

        for (int i = 0; i < 4; i++) {
            if (wheels.get(i).get(0) == 1) { // S극
                if (i == 0) {
                    sum += 1;
                } else if (i == 1) {
                    sum += 2;
                } else if (i == 2) {
                    sum += 4;
                } else {
                    sum += 8;
                }
            }
        }

        System.out.println(sum);


    }

    // magnet - 극
    // direction - 회전 방향
    static void rotateLeft(int index, int direction, int magnet) {

        if (index == 0) {  // 첫번째가 돈 경우라면 그냥 바로 종료
            return;
        }

        // 왼쪽 톱니와 극이 다른 경우
        if (magnet != wheels.get(index - 1).get(2)) {
            int leftMagnet = wheels.get(index - 1).get(6);

            rotate(index - 1, direction * -1);
            rotateLeft(index - 1, direction * -1, leftMagnet);
        }

    }

    static void rotateRight(int index, int direction, int magnet) {

        if (index == 3) { // 맨 마지막 톱니가 돈 경우라면 그냥 바로 종료
            return;
        }

        // 오른쪽 톱니와 극이 다른 경우
        if (magnet != wheels.get(index + 1).get(6)) {
            int rightMagnet = wheels.get(index + 1).get(2);

            rotate(index + 1, direction * -1);
            rotateRight(index + 1, direction * -1, rightMagnet);
        }
    }

    static void rotate(int index, int direction) {
        List<Integer> wheel = wheels.get(index);

        if (direction == 1) { // 시계
            int num = wheel.remove(7);
            wheel.add(0, num);
        } else { // 반시계
            int num = wheel.remove(0);
            wheel.add(num);
        }
    }


}
