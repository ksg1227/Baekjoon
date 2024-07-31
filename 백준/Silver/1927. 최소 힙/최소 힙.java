import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

/*
    solved.ac
    class3
    1927번 문제 : 최소 힙
 */

public class Main {

    //이 아래 방식은 시간 초과가 날 걸 알지만 일단 풀어본 것 -> N이 100,000 보다 작거나 같은데 2중 for문을 돌리니 연산이 수 억회가 됨.
    //우선순위 큐를 사용해야하는 문제라는데 내가 아직 우선순위 큐를 풀 줄 몰랐음

//    static int N;
//    static ArrayList<Integer> list = new ArrayList<>();
//
//    static void solution() throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//
//        N = Integer.parseInt(br.readLine());
//
//        for (int i = 0; i < N; i++) {
//            int num = Integer.parseInt(br.readLine());
//
//            if (num == 0) {
//                if (list.isEmpty()) {
//                    sb.append(0).append("\n");
//                } else {
//                    sb.append(list.remove(0)).append("\n");
//                }
//            } else {
//
//                if (list.isEmpty()) {
//                    list.add(num);
//                } else {
//                    for (int j = 0; j < list.size(); j++) {
//                        if (num >= list.get(j)) {
//                            if (j == list.size() - 1) {
//                                list.add(num);
//                                break;
//                            } else {
//                                continue;
//                            }
//                        } else {
//                            list.add(j, num);
//                            break;
//                        }
//                    }
//                }
//            }
//        }
//
//        System.out.println(sb);
//
//    }

    static int N;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if(num == 0){
                if(pq.isEmpty()){
                    sb.append(0).append("\n");
                } else{
                    sb.append(pq.poll()).append("\n");
                }
            } else{
                pq.add(num);
            }
        }

        System.out.println(sb);
    }


    public static void main(String[] args) throws Exception {
        Main.solution();
    }
}
