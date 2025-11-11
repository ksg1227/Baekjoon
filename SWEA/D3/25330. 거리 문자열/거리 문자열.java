import java.io.*;
import java.util.*;

public class Solution {
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 숫자 하나가 등장하면 Map 에 숫자와 인덱스를 저장하는 거 하나 
		// 숫자가 등장하면 그 숫자의 빈도를 저장하는 거 하나 
		// 인덱스가 정확히 차이가 난다면 인덱스를 저장하는 건 삭제하자. 
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0;i<T;i++) {
			String input = br.readLine();
			
			Map<Integer, Integer> frequency = new HashMap<>();
			Map<Integer, Integer> distance = new HashMap<>();
			
			for(int j=0;j<input.length();j++) {
				int num = input.charAt(j) - '0';
				
				// 빈도 추적 
				frequency.put(num, frequency.getOrDefault(num, 0) + 1);
				
				// 거리 추적 
				distance.put(num, j - distance.getOrDefault(num, 0));
			}
			
			boolean flag = true;
			for(int key : frequency.keySet()) {
				int count = frequency.get(key);
				int currentDist = distance.get(key);
				
				if(count != 2) {
					flag = false;
					break;
				}
				
				if(currentDist - 1 != key) {
					flag = false;
					break;
				}
			}
			
			if(flag) {
				sb.append("yes").append("\n");
			} else {
				sb.append("no").append("\n");
			}
		}
		
		System.out.println(sb);
	}

}
