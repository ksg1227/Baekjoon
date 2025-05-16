import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int[][] like;
	static int[][] like2;
	
	static int[][] map;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	static int result = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		like = new int[N*N+1][5];
		like2 = new int[N*N+1][4];
		
		map = new int[N+1][N+1];
		
		for(int i=1;i<=N*N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int index = 0;
			
			for(int j=0;j<5;j++) {
				int num = Integer.parseInt(st.nextToken());
				
				if(j == 0) {
					index = num;
				} else {
					like2[index][j-1] = num;
				}
				
				like[i][j] = num;
				
			}
		}
		
		for(int i=1;i<=N*N;i++) {
			int num = like[i][0];
			
			PriorityQueue<Position> pq = new PriorityQueue<>();
			
			for(int j=1;j<=N;j++) {
				for(int k=1;k<=N;k++) {
					if(map[j][k] == 0) {
						pq.offer(createPosition(j, k, i));
					}
				}
			}
			
			Position bestPosition = pq.poll();
			
			int x = bestPosition.x;
			int y = bestPosition.y;
			
			map[x][y] = num;
			
		}
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				result += calculateResult(i, j, map[i][j]);
			}
		}
		
		System.out.println(result);
		
	}
	
	
	static int calculateResult(int x, int y, int num) {
		
		int likeCount = 0;
		
		for(int i=0;i<4;i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			
			if(nextX <= N && nextX >=1 && nextY <= N && nextY >= 1) {
				for(int j=0;j<4;j++) {
					if(like2[num][j] == map[nextX][nextY]) {
						likeCount++;
					}
				}
			}
		}
		
		if(likeCount == 0) {
			return 0;
		} else if(likeCount == 1) {
			return 1;
		} else if(likeCount == 2) {
			return 10;
		} else if(likeCount == 3) {
			return 100;
		} else {
			return 1000;
		}
		
		
	}
	
	static Position createPosition(int x, int y, int index) {
		
		int likeCount = 0;
		int vacantCount = 0;
		
		for(int i=0;i<4;i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			
			if(nextX <= N && nextX >=1 && nextY <= N && nextY >= 1) {
				for(int j=1;j<=4;j++) {
					if(like[index][j] == map[nextX][nextY]) {
						likeCount++;
					}
					
					if(map[nextX][nextY] == 0) {
						vacantCount++;
					}
					
				}
			}
		}
		
		return new Position(likeCount, vacantCount, x, y);
	}
	
	
	static class Position implements Comparable<Position> {
		
		int likeCount; // 인접한 칸에 존재하는 좋아하는 학생 수 
		int vacantCount; // 인접한 칸에 존재하는 빈 칸의 수 
		int x;
		int y;
		
		Position(int likeCount, int vacantCount, int x, int y) {
			this.likeCount = likeCount;
			this.vacantCount = vacantCount;
			this.x = x;
			this.y = y;
		}
		
		public int compareTo(Position o) {
			if(this.likeCount == o.likeCount) {
				if(this.vacantCount == o.vacantCount) {
					if(this.x == o.x) {
						return this.y - o.y;
					}
					
					return this.x - o.x;
				}
				return o.vacantCount - this.vacantCount;
			}
			return o.likeCount - this.likeCount;
		}
	}
}
