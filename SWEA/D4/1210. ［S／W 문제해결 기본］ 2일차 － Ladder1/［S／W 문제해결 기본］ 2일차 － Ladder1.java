import java.io.*;
import java.util.*;

public class Solution {
	
	static int[][] data;
	
	static boolean[][] visited;
	
	// 좌, 우, 상 방향만 따라가면 됨 => 좌, 우로 이동이 불가능한 경우 윗방향으로 이동 
	static int[] dx = {0, 0, -1};
	static int[] dy = {-1, 1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int i=1;i<=10;i++) {
			int T = Integer.parseInt(br.readLine());
			
			data = new int[100][100];
			visited = new boolean[100][100];
			
			int currentX = 99;
			int currentY = 0;
			
			for(int j=0;j<100;j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				for(int k=0;k<100;k++) {
					int num = Integer.parseInt(st.nextToken());
					data[j][k] = num;
					
					if(num == 2) {
						currentY = k;
					}
				}
			}
			
			while(currentX > 0) {
				
				for(int j=0;j<3;j++) {
					int nextX = currentX + dx[j];
					int nextY = currentY + dy[j];
					
					if(nextX >= 0 && nextY < 100 && nextY >= 0 && data[nextX][nextY] == 1 && !visited[nextX][nextY]) {
						visited[nextX][nextY] = true;
						currentX = nextX;
						currentY = nextY;
						
//						System.out.println("currentX : " + currentX + " currentY : " + currentY);
						continue;
					}
				}
			}
			
			sb.append("#" + T + " " + currentY).append("\n");
		
			
		}
		
		System.out.println(sb);
	}
	
	

}
