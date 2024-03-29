import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/*
    solved.ac
    class2
    1929번 문제 : 소수 찾기
 */

public class Main {

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Queue<int[]> q = new LinkedList<>();

            //현재 큐에 자기보다 더 높은 prio가 존재하는지 확인하기 위해서
            ArrayList<Integer> list = new ArrayList<>();

            st = new StringTokenizer(br.readLine());

            //원래 몇 번째에 있던 애인지, 중요도는 몇인지

            for (int j = 0; j < N; j++) {
                int prio = Integer.parseInt(st.nextToken());

                int[] arr = new int[2];

                //각 값의 원래 처음 위치
                //중요도
                arr[0] = j;
                arr[1] = prio;

                q.add(arr);
                list.add(prio);
            }

            list.sort((o1, o2) ->{
                return o2 - o1;
            });

            int count = 0;

            while (true) {
                if (!q.isEmpty()) {
                    if(q.peek()[1] >= list.get(0)){
                        if(q.peek()[0] == M){
                            count++;
                            break;
                        }else{
                            q.poll();
                            list.remove(0);
                            count++;
                        }
                    }else{
                        q.add(q.poll());
                    }
                }
            }

            sb.append(count).append("\n");

        }

        System.out.println(sb);


    }


    public static void main(String[] args) throws Exception {
        Main.solution();
    }
}
