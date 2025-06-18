import java.io.*;
import java.util.*;

public class Solution {
	
	static int N;
	static int M;
	
	// i번째 주차공간의 단위 무게당 요금 
	static int[] pricePerWeight;
	
	// 차량의 무게 
	static int[] weight;
	
	// 각 칸이 비어있는지
	static boolean[] isVacant;
	
	// 각 차량이 몇 번 칸에 위치해있는지
	static int[] carPosition;
	
	static Queue<Integer> waiting = new LinkedList<>();
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=1;i<=T;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			pricePerWeight = new int[N+1];
			weight = new int[M+1];
			isVacant = new boolean[N+1];
			carPosition = new int[M+1];
			
			
			int result = 0;
			
			Arrays.fill(isVacant, true);
			
			for(int j=1;j<=N;j++) {
				pricePerWeight[j] = Integer.parseInt(br.readLine());
			}
			
			for(int j=1;j<=M;j++) {
				weight[j] = Integer.parseInt(br.readLine());
			}
			
			for(int j=0;j<2*M;j++) {
				int carNumber = Integer.parseInt(br.readLine());
				
				// 들어오는 경우 
				if(carNumber > 0) {
					int minParkingLot = findMinParkingLot();
					
					if(minParkingLot == -1) {
						waiting.offer(carNumber);
						continue;
					}
					
					carPosition[carNumber] = minParkingLot;
					isVacant[minParkingLot] = false;
					
					result += pricePerWeight[minParkingLot] * weight[carNumber];
					
				} else {  // 나가는 경우 
					
					int newVacantPosition = carPosition[Math.abs(carNumber)];
					
					isVacant[newVacantPosition] = true;
					
					if(!waiting.isEmpty()) {
						int newCarNumber = waiting.poll();
						
						isVacant[newVacantPosition] = false;
						carPosition[newCarNumber] = newVacantPosition;
						
						result += pricePerWeight[newVacantPosition] * weight[newCarNumber];
					}
					
					
				}
			}
			
			sb.append("#" + i + " " + result).append("\n");
			
		}
		
		System.out.println(sb);
		
	}
	
	static int findMinParkingLot() {
		for(int i=1;i<=N;i++) {
			if(isVacant[i]) {
				return i;
			}
		}
		
		return -1;
	}
}
