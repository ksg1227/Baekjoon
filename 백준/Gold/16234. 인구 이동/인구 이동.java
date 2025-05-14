import java.io.*;
import java.util.*;

public class Main {
	
	// 각각의 칸의 인구 수를 추적하는 배열
	static int[][] map;
	
	static boolean[][] visited;
	
	// 각각의 칸에 어떤 방향의 국경이 열려있는지 체크하는 배열 
	// 0 -> 동
	// 1 -> 남 
	// 2 -> 서 
	// 3 -> 북 
	static List<Integer>[][] border;
	
	
	// 연합의 수와 해당 연합에 속한 좌표들 추적
	static Map<Integer, List<Position>> federation = new HashMap<>();

	
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	static int N;
	static int L;
	static int R;
	
	static int result = 0;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		border = new ArrayList[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				border[i][j] = new ArrayList<>();
			}
		}
		
		migration();
		
		System.out.println(result);
		
		
	}
	
	static void migration() {
		
		while(true) {
			
			// 더 이상 이동이 없는 경우 
			if(noMoreMigrate()) {
				return;
			}
			
			// 이동이 존재하는 경우 우선 국경을 열어
			openBorder();
			
			visited = new boolean[N][N];
			
			int federationNum = 1;
			
			// 연합 구성 
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(!visited[i][j]) {
						visited[i][j] = true;
						
						List<Position> list = new ArrayList<>();
						list.add(new Position(i, j));
						
						federation.put(federationNum, list);
						
						dfs(i, j, federationNum++);
					}
				}
			}
			
			for(int num : federation.keySet()) {
				List<Position> list = federation.get(num);
				
				int count = list.size();
				
				int sum = 0;
				
				for(int i=0;i<count;i++) {
					Position currentPosition = list.get(i);
					
					sum += map[currentPosition.x][currentPosition.y];
				}
				
				int population = sum / count;
				
				for(int i=0;i<count;i++) {
					Position currentPosition = list.get(i);
					
					map[currentPosition.x][currentPosition.y] = population;
				}
				
			}
			
			
			// 국경 닫기 
			closeBorder();
			
			// 연합 추적 초기화 
			federation.clear();
			
			result++;
		}
	}
	
	
	static void dfs(int x, int y, int federationNum) {
		
		for(int i=0;i<border[x][y].size();i++) {
			int nextX = x + dx[border[x][y].get(i)];
			int nextY = y + dy[border[x][y].get(i)];
			
			// 유효한 경우 
			if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
				if(!visited[nextX][nextY]) {
					visited[nextX][nextY] = true;
					federation.get(federationNum).add(new Position(nextX, nextY));
					dfs(nextX, nextY, federationNum);
				}
			}
		}
		
	}
	
	
	// 현재 좌표 기준 동쪽, 남쪽만 확인하면 됨 
	static void openBorder() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				
				// 범위를 벗어나지 않는지 체크
				if(j + 1 < N) {
					int eastDifference = Math.abs(map[i][j] - map[i][j+1]);
					
					if(eastDifference >= L && eastDifference <= R) {
						border[i][j].add(0);
						border[i][j+1].add(2);
					}
				}
				
				if(i + 1 < N) {
					int southDifference = Math.abs(map[i][j] - map[i+1][j]);
					
					
					
					if(southDifference >= L && southDifference <= R) {
						border[i][j].add(1);
						border[i+1][j].add(3);
					}
				}
				
				
			}
		}
	}
	
	static void closeBorder() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				border[i][j].clear();
			}
		}
	}
	
	
	static boolean noMoreMigrate() {
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				// 범위를 벗어나지 않는지 체크 
				// 범위를 벗어나지 않는지 체
				if(j + 1 < N) {
					int eastDifference = Math.abs(map[i][j] - map[i][j+1]);
					
					if(eastDifference >= L && eastDifference <= R) {
						return false;
					}
				}
				
				if(i + 1 < N) {
					int southDifference = Math.abs(map[i][j] - map[i+1][j]);
					
					if(southDifference >= L && southDifference <= R) {
						return false;
					}
				}
				
		
			}
		}
	
		return true;
	}
	
	static void print() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	static void printBorder() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				for(int k=0;k<border[i][j].size();k++) {
					System.out.print(border[i][j].get(k) + " ");
				}
				System.out.println();
			}
		}
	}
	
	static class Position {
		int x;
		int y;
		
		Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
