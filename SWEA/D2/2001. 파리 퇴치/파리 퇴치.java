import java.io.*;
import java.util.*;

public class Solution {
	
	static int[][] map;
	
	static int N;
	static int M;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=1;i<=T;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			
			for(int j=0;j<N;j++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0;k<N;k++) {
					map[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			
			int result = 0;
			
			for(int j=0;j<N-M+1;j++) {
				for(int k=0;k<N-M+1;k++) {
					int sum = calculateSum(j, k);
					
					result = Math.max(sum, result);
				}
			}
			
			sb.append("#" + i + " " + result).append("\n");
			
			
		}
		
		System.out.println(sb);
	}
	
	static int calculateSum(int x, int y) {
		int sum = 0;
		
		for(int i=x;i<x+M;i++) {
			for(int j=y;j<y+M;j++) {
				sum += map[i][j];
			}
		}
		
		return sum;
	}
}
