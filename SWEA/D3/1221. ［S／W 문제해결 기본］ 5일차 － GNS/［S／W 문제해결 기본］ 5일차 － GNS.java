import java.io.*;
import java.util.*;

public class Solution {
	
	static String[] keys = {"ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=1;i<=T;i++) {
			st = new StringTokenizer(br.readLine());
			
			String test = st.nextToken();
			
			int N = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			
			Map<String, Integer> rank = new HashMap<>();
			
			for(int j=0;j<=9;j++) {
				rank.put(keys[j], 0);
			}
			
			for(int j=0;j<N;j++) {
				String word = st.nextToken();
				
				rank.put(word, rank.get(word) + 1); 
			}
			
			sb.append(test).append(" ");
			
			for(int j=0;j<=9;j++) {
				String key = keys[j];
				
				int count = rank.get(key);
				
				for(int k=0;k<count;k++) {
					sb.append(key).append(" ");
				}
				
			}
			sb.append("\n");
			
		}
		System.out.println(sb);
	}

}
