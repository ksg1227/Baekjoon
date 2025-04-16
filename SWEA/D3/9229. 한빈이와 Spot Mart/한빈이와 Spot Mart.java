import java.io.*;
import java.util.*;

/**
 * D3 - 9229
 * 
 * 이진 탐
 */

public class Solution {
	
	static int N;
	static int M;
	
	static int[] weight;
	
	static int maxWeight;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=1;i<=T;i++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			weight = new int[N];
			maxWeight = -1;
			
			st = new StringTokenizer(br.readLine());
			
			for(int j=0;j<N;j++) {
				weight[j] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(weight);
			
			for(int j=0;j<N-1;j++) {
				binarySearch(j+1, N-1, weight[j]);
			}
			
			sb.append("#" + i + " ").append(maxWeight).append("\n");
			
		}
		
		System.out.println(sb);
	}
	
	static void binarySearch(int low, int high, int currentWeight) {
		
		while(low <= high) {
			int mid = (low + high) / 2;
			
			int newWeight = weight[mid];
			
			int sum = currentWeight + newWeight;
			
			if(sum < M) {
				low = mid + 1;
				maxWeight = Math.max(maxWeight, sum);
			} else if(sum == M) {
				maxWeight = M;
				return;
			} else {
				high = mid - 1;
			}
			
		}
	}

}
