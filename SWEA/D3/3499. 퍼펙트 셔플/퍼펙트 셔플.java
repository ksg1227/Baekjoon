import java.io.*;
import java.util.*;

public class Solution {
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=1;i<=T;i++) {
			int N = Integer.parseInt(br.readLine());
			
			List<String> first = new ArrayList<>();
			List<String> second = new ArrayList<>();
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			if(N % 2 == 0) {
				for(int j=0;j<N;j++) {
					
					if(j < N/2) {
						first.add(st.nextToken());
					} else {
						second.add(st.nextToken());
					}
				}
			} else {
				for(int j=0;j<N;j++) {
					if(j <= N/2) {
						first.add(st.nextToken());
					} else {
						second.add(st.nextToken());
					}
				}
				
			}
			
			sb.append("#" + i + " ");
			
			for(int j=0;j<N/2;j++) {
				sb.append(first.get(j)).append(" ");
				sb.append(second.get(j)).append(" ");
			}
			
			if(N % 2 == 1) {
				sb.append(first.get(N/2)).append("\n");
			} else {
				sb.append("\n");
			}
		
		}
		
		System.out.println(sb);
	}
	

}
