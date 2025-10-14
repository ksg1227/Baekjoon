import java.io.*;
import java.util.*;

public class Solution {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=1;i<=T;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			String bin = decimalToBinary("", M);
			
			boolean flag = false;
			
			if(bin.length() < N) {
				flag = true;
			} else {
				for(int j=0;j<N;j++) {
					if(bin.charAt(bin.length() - 1 - j) != '1') {
						flag = true;
					} 
				}
			}
			
			if(flag) {
				sb.append("#" + i + " OFF");
			} else {
				sb.append("#" + i + " ON");
			}
			
			sb.append("\n");
			
		}
		
		System.out.println(sb);
	}
	
	static String decimalToBinary(String current, int num) {
		if(num == 0) {
			return current;
		}
		
		current = String.valueOf(num % 2) + current;
		
		return decimalToBinary(current, num / 2);
		
		
	}

}
