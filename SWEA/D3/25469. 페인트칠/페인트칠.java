import java.io.*;
import java.util.*;

// 이미 한 줄이 칠해진 행, 열은 추적하

public class Solution {
	
	static char[][] map;
	static int H;
	static int W;
	
	// 현재 행이 색칠이 이미 되어있는지 
	static char[][] check;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0;i<T;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
			map = new char[H][W];
			check = new char[H][W];
			
			int answer = 0;
			
			for(int j=0;j<H;j++) {
				String input = br.readLine();
				
				for(int k=0;k<W;k++) {
					char c = input.charAt(k);
					map[j][k] = c;
					check[j][k] = '.';
				}
			}
			
			for(int j=0;j<H;j++) {
				if(targetIsBlackRow(j) && !checkCurrentRowIsBlack(j)) {
					fillBlackRow(j);
					answer++;
				}
			}
			
			if(answer == H) {
				sb.append(Math.min(W,  H)).append("\n");
				continue;
			}
			
			for(int j=0;j<W;j++) {
				if(targetIsBlackCol(j) && !checkCurrentColIsBlack(j)) {
					fillBlackCol(j);
					answer++;
				}
			}
			
			sb.append(answer).append("\n");
			
		}
		
		System.out.println(sb);
	}
	
	// x : 행 
	static boolean targetIsBlackRow(int x) {
		for(int i=0;i<W;i++) {
			if(map[x][i] == '.') {
				return false;
			}
		}
		
		return true;
	}
	
	// y : 열 
	static boolean targetIsBlackCol(int y) {
		for(int i=0;i<H;i++) {
			if(map[i][y] == '.') {
				return false;
			}
		}
		
		return true;
	}
	
	static boolean checkCurrentRowIsBlack(int x) {
		for(int i=0;i<W;i++) {
			if(check[x][i] == '.') {
				return false;
			}
		}
		
		return true;
	}
	
	static boolean checkCurrentColIsBlack(int y) {
		for(int i=0;i<H;i++) {
			if(check[i][y] == '.') {
				return false;
			}
		}
		
		return true;
	}
	
	static void fillBlackRow(int x) {
		for(int i=0;i<W;i++) {
			check[x][i] = '#';
		}
	}
	
	static void fillBlackCol(int y) {
		for(int i=0;i<H;i++) {
			check[i][y] = '#';
		}
	}
	

}
