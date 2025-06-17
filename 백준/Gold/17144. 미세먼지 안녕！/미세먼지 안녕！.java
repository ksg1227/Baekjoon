import java.io.*;
import java.util.*;


public class Main {
	
	static int R;
	static int C;
	static int T;
	
	static int[][] map;
	
	static int cleanerTopX;
	static int cleanerBottomX;
	
	//위쪽 공기청정기 이동 방향 
	static int[] topDx = {0, -1, 0, 1};
	static int[] topDy = {1, 0, -1, 0};
	
	// 아래쪽 공기청정기 이동 방향 
	static int[] bottomDx = {0, 1, 0, -1};
	static int[] bottomDy = {1, 0, -1, 0};
	
	// 각 초마다 변경사항 저장 
	static int[][] change;
	
	// 확산되는 것으로 먼지가 사라질 수는 없음
	
	// 해당 좌표에 대해 얼만큼의 +, - 변동사항이 생기는 지를 추적한 후에 새롭게 갱신
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		
		boolean flag = true;
		
		for(int i=0;i<R;i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=0;j<C;j++) {
				int num = Integer.parseInt(st.nextToken());
				
				if(num  == -1) {
					if(flag) {
						cleanerTopX = i;
						flag = false;
					} else {
						cleanerBottomX = i;
					}
				}
				
				map[i][j] = num;
			}
		}
		
		
		for(int i=1;i<=T;i++) {
	
			spread();
			
			operateTopCleaner();
			
			operateBottomCleaner();
		
		}
		
		int result = 0;
		
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(map[i][j] != -1) {
					result += map[i][j];
				}
			}
		}
		
		System.out.println(result);
		
		
		
	}
	
	static void spread() {
		
		change = new int[R][C];
		
		for(int i=0;i<R;i++)  {
			for(int j=0;j<C;j++) {
				if(map[i][j] != 0 && map[i][j] != -1) {
					
					int count = 0;
					
					for(int k=0;k<4;k++) {
						int nextX = i + topDx[k];
						int nextY = j + topDy[k];
						
						if(nextX < 0 || nextX >= R || nextY < 0 || nextY >= C || map[nextX][nextY] == -1) {
							continue;
						}
						
						change[nextX][nextY] += map[i][j] / 5;
						count++;
					}
					
					change[i][j] -= (map[i][j] / 5) * count;
					
				}
			}
		}
		
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				map[i][j] += change[i][j];
			}
		}
		
		
	}
	
	
	static void operateTopCleaner() {
		
		int currentX = cleanerTopX;
		int currentY = 1;
		
		int currentDust = map[currentX][currentY];
		map[currentX][currentY] = 0;
		
		int direction = 0;
		
		while(true) {
			if(currentX == cleanerTopX-1 && currentY == 0) {
				return;
			}
			
			if((currentX == cleanerTopX && currentY == C-1) || (currentX == 0 && currentY == C-1) || (currentX == 0 && currentY == 0)) {
				direction++;
			}
			
			int nextX = currentX + topDx[direction];
			int nextY = currentY + topDy[direction];
			
			int nextDust = map[nextX][nextY];
			
			map[nextX][nextY] = currentDust;
			
			currentX = nextX;
			currentY = nextY;
			currentDust = nextDust;
		}
		
	}
	
	static void operateBottomCleaner() {
		int currentX = cleanerBottomX;
		int currentY = 1;
		
		int currentDust = map[currentX][currentY];
		map[currentX][currentY] = 0;
		
		int direction = 0;
		
		while(true) {
			if(currentX == cleanerBottomX+1 && currentY == 0) {
				return;
			}
			
			if((currentX == cleanerBottomX && currentY == C-1) || (currentX == R-1 && currentY == C-1) || (currentX == R-1 && currentY == 0)) {
				direction++;
			}
			
			int nextX = currentX + bottomDx[direction];
			int nextY = currentY + bottomDy[direction];
			
			int nextDust = map[nextX][nextY];
			
			map[nextX][nextY] = currentDust;
			
			currentX = nextX;
			currentY = nextY;
			currentDust = nextDust;
		}
	}
	
	static void print() {
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
