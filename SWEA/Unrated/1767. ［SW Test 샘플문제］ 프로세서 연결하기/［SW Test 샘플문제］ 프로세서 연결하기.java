import java.io.*;
import java.util.*;

public class Solution {
	
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static List<Point> cores;
	
	// 북 동 남 
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	static int result;
	
	static int[] combination;
	static boolean[] isAlreadyCombination;
	
	// 모서리에 닿아있는 애들은 고려할 필요가 없음.
	// 즉 그냥 미리 visited 처리해두면 
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=1;i<=T;i++) {
			N = Integer.parseInt(br.readLine());
			
			map = new int[N][N];
			visited = new boolean[N][N];
			
			cores = new ArrayList<>();
			
			result = Integer.MAX_VALUE;
			
			for(int j=0;j<N;j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int k=0;k<N;k++) {
					int num = Integer.parseInt(st.nextToken());
					
					if(num == 1) {
						
						visited[j][k] = true;
						
						// 테두리 
						if(j != 0 && j != N-1 && k != 0 && k != N-1) {
							cores.add(new Point(j, k));
						}
						
					}
				}
				
			}
			
			
			for(int j=cores.size();j>=1;j--) {
				isAlreadyCombination = new boolean[cores.size()];
				
				combination = new int[j];
				makeCombination(0, j, 0);
				
				if(result != Integer.MAX_VALUE) {
					break;
				}
			}
			
			sb.append("#" + i + " " + result).append("\n");
			
		}
		
		System.out.println(sb);
		
	}
	
	static void makeCombination(int start, int size, int index) {
		if(index == size) {
			dfs(0, 0, size, 0);
			return;
		}
		
		for(int i=start;i<cores.size();i++) {
			if(!isAlreadyCombination[i]) {
				isAlreadyCombination[i] = true;
				combination[index] = i;
				makeCombination(i+1, size, index+1);
				isAlreadyCombination[i] = false;
			}
		}
	}
	
	// 전체를 다 돌리지 말고, 최대 개수부터 뽑아내서 체크 
	
	// length : 전원의 길이의 합 
	// count : 전원에 연결된 core 의 개수 
	static void dfs(int length, int count, int size, int index) {
		
		if(count == size) {
			result = Math.min(length, result);
			return;
		}
		
		for(int i=index;i<combination.length;i++) {
				
			Point currentPoint = cores.get(combination[i]);
			
			// 각 방향으로 선 연결 
			for(int j=0;j<4;j++) {
				
				if(canPowerOn(currentPoint.x, currentPoint.y, j)) {
					// 연결
					int lineLength = connectPower(currentPoint.x, currentPoint.y, j, true);
					
					// dfs
					dfs(length + lineLength, count+1, size, i+1);
					
					// 연결 해제 
					connectPower(currentPoint.x, currentPoint.y, j, false);
				}
				
			}
		
		}
		
	}
	
	// 전원과 연결할 수 있는 경우 
	static boolean canPowerOn(int x, int y, int direction) {
		
		while(x < N-1 && y < N-1 && x > 0 && y > 0) {
			x += dx[direction];
			y += dy[direction];
			
			if(visited[x][y]) {
				return false;
			}
		}
		
		return true;
	}
	
	static int connectPower(int x, int y, int direction, boolean flag) {
		
		int count = 0;
		
		while(x < N-1 && y < N-1 && x > 0 && y > 0) {
			x += dx[direction];
			y += dy[direction];
			
			visited[x][y] = flag;
			
			count++;
		}
		
		return count;
	}
	
	static void printMap() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(visited[i][j]) {
					System.out.print("1 ");
				} else {
					System.out.print("0 ");
				}
			}
			System.out.println();
		}
	}
	
	static class Point{
		int x;
		int y;
		
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	

}
