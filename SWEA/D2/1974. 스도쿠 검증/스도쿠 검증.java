import java.io.*;
import java.util.*;

public class Solution {
	
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=1;i<=T;i++) {
			
			map = new int[9][9];
			
			for(int j=0;j<9;j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
			
				for(int k=0;k<9;k++) {
					int num = Integer.parseInt(st.nextToken());
					map[j][k] = num;
					
				}
			}
			
			boolean flag = true;
			
			boolean breakLoopFlag = false;
			
			for(int j=0;j<9;j++) {
				for(int k=0;k<9;k++) {
					
					if(checkHorizon(j, map[j][k], k) == false || checkVertical(k, map[j][k], j) == false || checkArea(j, k, map[j][k]) == false) {
						flag = false;
						breakLoopFlag = true;
						break;
					}
					
				}
				
				if(breakLoopFlag) {
					break;
				}
			}
			
			if(flag) {
				sb.append("#" + i + " 1" ).append("\n");
			} else {
				sb.append("#" + i + " 0" ).append("\n");
			}
		}
		
		System.out.println(sb);
	}
	
	
	static boolean checkHorizon(int x, int num, int index) {
		for(int i=0;i<9;i++) {
			if(i != index) {
				if(map[x][i] == num) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	static boolean checkVertical(int y, int num, int index) {
		for(int i=0;i<9;i++) {
			if(i != index) {
				if(map[i][y] == num) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	
	// 몇 번째 칸에 위치하는 지 계산하는 공식 => (x / 3) * 3,  (y / 3) * 3 => 이게 각 칸의 첫번째 
	static boolean checkArea(int x, int y, int num) {
		
		int startX = (x / 3) * 3;
		int startY = (y / 3) * 3;
		
		
		for(int i=startX;i<startX+3;i++) {
			for(int j=startY;j<startY+3;j++) {
				if(i != x || j != y) {
					if(map[i][j] == num) {
						return false;
					}
				}
			}
		}
		
		return true;
		
	}

}
