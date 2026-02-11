import java.util.*;
import java.io.*;

public class Solution {

    static int N;
    static int B;

    // 이 높이를 만들 수 있는지
    static boolean[][] canMake;
    static int[] heights;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(100);
        int T = Integer.parseInt(br.readLine());

        for(int i=1;i<=T;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            N = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            heights = new int[N+1];

            int S = 0;
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=1;j<=N;j++) {
                int height = Integer.parseInt(st.nextToken());
                heights[j] = height;
                S += height;
            }

            canMake = new boolean[N+1][S+1];

            int result = Integer.MAX_VALUE;

            for(int j=1;j<=N;j++) {
                int height = heights[j];

                for(int k=0;k<=S;k++) {
                    if(canMake[j-1][k]) {
                        canMake[j][k] = true;
                    }

                    if(height == k) {
                        canMake[j][k] = true;
                        if(k >= B) {
                            result = Math.min(result, k - B);
                        }
                    }

                    if(k - height >= 0 && canMake[j-1][k - height]) {
                        canMake[j][k] = true;
                        if(k >= B) {
                            result = Math.min(result, k - B);
                        }
                    }
                }
            }

            sb.append("#" + i + " " + result).append("\n");

        }

        System.out.println(sb);
    }
}
