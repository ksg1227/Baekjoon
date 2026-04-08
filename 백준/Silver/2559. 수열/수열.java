import java.io.*;
import java.util.*;

public class Main {
	
	static int N, K;
	static int[] nums;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		nums = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<N;i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int sum = 0;
		for(int i=0;i<K;i++) {
			sum += nums[i];
		}
		
		int result = sum;
		
		for(int i=1;i<=N-K;i++) {
			int next = sum - nums[i-1] + nums[i + K - 1];
			
			result = Math.max(result,  next);
			sum = next;
		}
		
		System.out.println(result);
		
		
	}

}
