import java.io.*;
import java.util.*;

public class Solution {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=1;i<=N;i++) {
			String num = String.valueOf(i);
			
			if(num.contains("3") || num.contains("6") || num.contains("9")) {
				for(int j=0;j<num.length();j++) {
					char c = num.charAt(j);
					
					if(c == '3' || c == '6' || c == '9') {
						sb.append("-");
					}
				}
			} else {
				sb.append(i);
			}
			
			sb.append(" ");
		}
		
		System.out.println(sb);
	}

}
