import java.io.*;

public class Solution {
	
	static int result = 0;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0;i<T;i++) {
			String input = br.readLine();
			
			int result = 0;
			
			int LPoint = 0;
			int RPoint = 0;
			
			for(int j=0;j<input.length();j++) {
				
				if(input.charAt(j) == 'L') {
					LPoint--;
					RPoint--;
				} else if(input.charAt(j) == 'R') {
					LPoint++;
					RPoint++;
				} else {
					LPoint--;
					RPoint++;
				}
				
				result = Math.max(Math.abs(LPoint), Math.max(Math.abs(RPoint), result));
				
			}
			
			sb.append(result).append("\n");
		}
		
		System.out.println(sb);
	}
	
	// L, R 각각으로 다 해보
	

}
