import java.io.*;
import java.util.*;


/*  *********** 2차원 배열 정렬
    일반적인 bubble sort 방식으로는 java를 활용해서 풀 수 없다.
    따라서 Arrays.sort를 통해 람다식, 혹은 Comparator를 활용한다.
    https://st-lab.tistory.com/110 -> 이 페이지 참조
    https://velog.io/@lifeisbeautiful/Java-%EB%B0%B1%EC%A4%80-11650%EB%B2%88-%EC%A2%8C%ED%91%9C%EC%A0%95%EB%A0%AC%ED%95%98%EA%B8%B0-%EC%9E%90%EB%B0%94
    -> 이 페이지도 낫배드
    Comparator 공부하기
    단계별로 풀어보기
    정렬
    11650번 문제: 좌표 정렬하기
*/

public class Main {

    static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        int[][] arr = new int[N][2];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[i][0] = x;
            arr[i][1] = y;
        }

        /* 방법 1
        Arrays.sort(arr, (arr1, arr2) -> {

            if(arr1[0] == arr2[0]){
                return arr1[1] - arr2[1];
            }
            else{
                return arr1[0] - arr2[0];
            }
        });
        */


        //return되는 값이 음수일 경우 : 위치를 바꾸지 않음
        //return되는 값이 양수일 경우 : 위치를 바꿈

        //즉 o1[0] - o2[0] 이 양수일 경우 o1[0] > o2[0] 이라는 의미이므로
        //앞에 존재하는 좌표의 x좌표가 더 크다고 할 수 있다. 따라서 더 큰 값을 뒤로 보내기 위해 자리를 바꾼다.

        //마찬가지로 o1[1] - o2[1] 이 양수일 경우 o1[1] > o2[1] 이라는 의미이므로
        //앞에 존재하는 좌표의 y좌표가 더 크다고 할 수 있다. 따라서 위치를 바꾸게된다.

        //방법 2
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){  //x좌표가 같으면
                    return o1[1] - o2[1]; //y좌표 순으로
                }
                else{ //x좌표가 다르면
                    return o1[0] - o2[0]; //y좌표 순으로
                }
            }
        });

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<N;i++){
            sb.append(arr[i][0] + " " + arr[i][1]).append("\n");
        }

        System.out.println(sb);




    }

    public static void main(String args[]) throws Exception {
        new Main().solution();
    }
}



