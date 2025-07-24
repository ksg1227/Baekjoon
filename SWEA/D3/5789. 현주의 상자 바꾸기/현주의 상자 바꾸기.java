import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		
		for(int i=1;i<=T;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int Q= Integer.parseInt(st.nextToken());
			
			int[] arr = new int[N+1];
			
			for(int j=1;j<=Q;j++) {
				st = new StringTokenizer(br.readLine());
				
				int L = Integer.parseInt(st.nextToken());
				int R = Integer.parseInt(st.nextToken());
				
				for(int k=L;k<=R;k++) {
					arr[k] = j;
				}
			}
			
			sb.append("#" + i + " ");
			
			for(int j=1;j<=N;j++) {
				sb.append(arr[j] + " ");
			}
			
			sb.append("\n");
			
		}
		
		System.out.println(sb);
		
		
	}
}
