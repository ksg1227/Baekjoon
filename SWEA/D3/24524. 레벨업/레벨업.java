import java.io.*;
import java.util.*;

public class Solution {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0;i<T;i++) {
			int N = Integer.parseInt(br.readLine());
			
			int[] checkPoint = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j=0;j<N;j++) {
				checkPoint[j] = Integer.parseInt(st.nextToken());
			}
			
			int result = Integer.MAX_VALUE;
			
			
			// j : 방문하지 않을 좌표 
			for(int j=1;j<N-1;j++) {
				
				int sum = 0;
				
				//
				for(int k=0;k<N-1;k++) {
					if(k != j) {
						if(k+1 == j) {
							sum += Math.abs(checkPoint[k+2] - checkPoint[k]);
						} else {
							sum += Math.abs(checkPoint[k+1] - checkPoint[k]);
						}
					}
				}
				
				result = Math.min(result, sum);
				
			}
			
			sb.append(result).append("\n");
			
			
		}
		
		System.out.println(sb);
		
	}

}
