import java.io.*;
import java.util.*;

public class Main {
	
	// 먹을 수 있는 물고기라면, 해당 지점까지의 거리를 계산 
	// 그렇게 계산한 먹을 수 있는 물고기의 지점들 중, 가장 가까운 지점을 골라서 해당 장소로 이동 
	
	static int result = 0;
	
	static int N;
	static int[][] map;
	static boolean[][] visited;
	
	static int[] dx = {-1, 0, 0, 1};
	static int[] dy = {0, -1, 1, 0};
	
	static int sharkSize = 2;
	static int eatCount = 0;
	
	static int sharkX;
	static int sharkY;
	
	// 부호 
	// x의 부호 
	// y의 부호 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j=0;j<N;j++) {
				int num = Integer.parseInt(st.nextToken());
				
				if(num == 9) {
					sharkX = i;
					sharkY = j;
				} else {
					map[i][j] = num;
				}
			}
		}
		
		while(true) {
			
			if(!findFish()) {
				break;
			}
		}
		
		System.out.println(result);
		
	}
	
	static boolean findFish() { 
		
		// 북, 서, 동, 남 순으로 bfs
		Queue<Position> queue = new LinkedList<>();
		queue.offer(new Position(sharkX, sharkY, 0));
		
		visited = new boolean[N][N];
		visited[sharkX][sharkY] = true;
		
		int minDistance = Integer.MAX_VALUE;
		
		List<Position> nodes = new ArrayList<>();
		
		
		while(!queue.isEmpty()) {
			Position currentPosition = queue.poll();
			int x = currentPosition.x;
			int y = currentPosition.y;
			int time = currentPosition.time;
			
			if(time+1 > minDistance) {
				break;
			}
			
			for(int i=0;i<4;i++) {
				int nextX = x + dx[i];
				int nextY = y + dy[i];
				
				if(nextX < N && nextX >= 0 && nextY < N && nextY >= 0) {
					if(!visited[nextX][nextY]) {
						
						// 상어보다 작은 물고기를 최초로 찾는 경우 
						// 해당 위치로 이동해서 물고기를 먹고 거기로 이동함 
						if(map[nextX][nextY] < sharkSize && map[nextX][nextY] > 0) {
							visited[nextX][nextY] = true;
							nodes.add(new Position(nextX, nextY, time+1));
							minDistance = Math.min(minDistance, time+1);
						}
						
						// 상어랑 크기가 같은 물고기이거나 물고기가 없는 경
						if(map[nextX][nextY] == sharkSize || map[nextX][nextY] == 0) {
							visited[nextX][nextY] = true;
							queue.offer(new Position(nextX, nextY, time+1));
						}
						
					}
				}
			}
		}
		
		Collections.sort(nodes);
		
		if(nodes.isEmpty()) {
			return false;
		} else {
			Position nextPosition = nodes.get(0);
			eatCount++;
			
			if(eatCount == sharkSize) {
				sharkSize++;
				eatCount = 0;
			}
			
			map[nextPosition.x][nextPosition.y] = 0;
			sharkX = nextPosition.x;
			sharkY = nextPosition.y;
			
			result += minDistance;
			
			return true;
		}
	
		
		
	}
	
 	
	static class Position implements Comparable<Position> {
		int x;
		int y;
		int time;
		
		Position(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
		
		public int compareTo(Position o) {
			if(this.x == o.x) {
				return this.y - o.y;
			} 
			
			return this.x - o.x;
		}
	}

}
