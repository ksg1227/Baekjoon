import java.io.*;
import java.util.*;


public class Solution {
	
	// 각 지점까지의 최장 거리를 저장.
	// 나 이전의 지점을 확인하면서 나보다 값이 작으면서 가장 거리가 긴 애를 선택 후 그것 + 1 한 것을 나의 최장 거리로 설정 
	// 이러면 N^2 이라 100만회임
	
	static int[] nums;
	static int[] maxDistance;
	static int result;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=1;i<=T;i++) {
			int N = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			nums = new int[N];
			maxDistance = new int[N];
			result = 0;
			
			for(int j=0;j<N;j++) {
				int num = Integer.parseInt(st.nextToken());
				nums[j] = num;
			}
			
			for(int j=0;j<N;j++) {
				maxDistance[j] = currentMaxDistance(j);
				result = Math.max(result,  maxDistance[j]);
			}
			
			
			sb.append("#" + i + " " + result).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static int currentMaxDistance(int index) {
		
		int max = 1;
		
		for(int i = index-1;i>=0;i--) {
			if(nums[i] <= nums[index]) {
				max = Math.max(max, maxDistance[i] + 1);
			}
		}
		
		return max;
	}

}
