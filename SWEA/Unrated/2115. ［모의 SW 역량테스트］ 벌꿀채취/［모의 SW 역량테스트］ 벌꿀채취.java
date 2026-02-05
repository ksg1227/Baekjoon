import java.io.*;
import java.util.*;

public class Solution {

    static int[][] map;
    static int N, M, C;

    static int[] first, second;

    static int firstMax, secondMax;

    static int result;

    // 첫번째 사람이 선택한 꿀통의 x, y 좌표
    // 두 번째 사람은 그거의 y + M 에서부터 시작함.
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int i=1;i<=T;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            map = new int[N][N];

            result = -1;

            for(int j=0;j<N;j++) {
                st = new StringTokenizer(br.readLine(), " ");

                for(int k=0;k<N;k++) {
                    map[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            first = new int[M];
            second = new int[M];

            // N - 1
            // N - 1 - M +
            for(int j = 0;j<N;j++) {
                firstMax = -1;
                for(int k=0;k<=N-M;k++) {
                    int firstX = j;  // 첫번째 일꾼의 좌표
                    int firstY = k; // 두번째 일꾼의 좌표
                    // 이 좌표부터 M칸 선택 가능

                    secondMax = -1;

                    for(int l=0;l<M;l++) {
                        first[l] = map[firstX][firstY + l];
                    }

                    calculateMax(0, 0, 0, 0, 1);
                    
                    int secondSameRowStart = firstY + M;

                    // 첫 번째 일꾼과 같은 행에서, 범위를 벗어나지 않는 경우
                    for(int l = secondSameRowStart;l<=N-M;l++) {
                        int secondX = j;
                        int secondY = l;

                        // 각각 계산하기
                        for(int m=0;m<M;m++) {
                            second[m] = map[secondX][secondY + m];
                        }

                        calculateMax(0, 0, 0, 0, 0);
                    }

                    // 다른 행
                    for(int l=j+1;l<N;l++) {
                        for(int m=0;m<=N-M;m++) {
                            int secondX = l;
                            int secondY = m;

                            // 각각 계산하기
                            for(int n=0;n<M;n++) {
                                second[n] = map[secondX][secondY + n];
                            }

                            calculateMax(0, 0, 0, 0, 0);
                        }
                    }

                    result = Math.max(result, firstMax + secondMax);

                }
            }

            sb.append("#" + i + " " + result).append("\n");
        }

        System.out.println(sb);

    }

    static void calculateMax(int start, int size, int amount, int powSum, int type) {
        if(amount > C) {
            return;
        }

        if(type == 1) {
            firstMax = Math.max(firstMax, powSum);
        } else {
            secondMax = Math.max(secondMax, powSum);
        }

        if(size == M) {
            return;
        }

        for(int i=start;i<M;i++) {
            if(type == 1) {
                calculateMax(i+1, size+1, amount + first[i], powSum + (int)Math.pow(first[i], 2), 1);
            } else {
                calculateMax(i+1, size+1, amount + second[i], powSum + (int)Math.pow(second[i], 2), 0);
            }

        }
    }
}
