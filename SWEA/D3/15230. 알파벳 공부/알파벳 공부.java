import java.io.*;

public class Solution {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=1;i<=T;i++) {
			String input = br.readLine();
			
			int count = 0;
			
			for(int j=0;j<input.length();j++) {
				
				char c = input.charAt(j);
				
				if(c - 'a' != j) {
					break;
				}
				
				count++;
			}
			
			sb.append("#" + i + " " + count).append("\n");
		}
		
		System.out.println(sb);
	}

}
