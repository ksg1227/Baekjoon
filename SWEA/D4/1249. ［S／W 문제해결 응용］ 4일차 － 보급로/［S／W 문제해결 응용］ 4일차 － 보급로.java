import java.io.*;
import java.util.*;

public class Solution {
	
	static int[][] minDistance;
	static boolean[][] visited;
	static int[][] map;
	static int N;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=1;i<=T;i++) {
			N = Integer.parseInt(br.readLine());
			
			minDistance = new int[N][N];
			visited = new boolean[N][N];
			for(int j=0;j<N;j++) {
				Arrays.fill(minDistance[j], N * N * 100);
				
				Arrays.fill(visited[j], false);
			}
			
			minDistance[0][0] = 0;
			
			
			map = new int[N][N];
			for(int j=0;j<N;j++) {
				String[] input = br.readLine().split("");
				
				for(int k=0;k<N;k++) {
					map[j][k] = Integer.parseInt(input[k]);
				}
			}
			
			dijkstra();
			
			System.out.println("#" + i + " " + minDistance[N-1][N-1]);

			
		}
		
	}
	
	static void dijkstra() {
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		pq.add(new Node(0, 0, 0));
		
		while(!pq.isEmpty()) {
			
			Node node = pq.poll();
			
			int currentX = node.x;
			int currentY = node.y;
			int currentTime = node.time;
			
			if(visited[currentX][currentY]) {
				continue;
			}
			
			visited[currentX][currentY] = true;
			
			for(int i=0;i<4;i++) {
				int nextX = currentX + dx[i];
				int nextY = currentY + dy[i];
				
				if(nextX >= 0 && nextY >=0 && nextX < N && nextY < N) {
					int nextPositionDepth = map[nextX][nextY];
					
					if(currentTime + nextPositionDepth < minDistance[nextX][nextY]) {
						minDistance[nextX][nextY] = currentTime + nextPositionDepth;
						
						pq.add(new Node(nextX, nextY, currentTime + nextPositionDepth));
					}
				}
			}
		}
		
	}
	
	static class Node implements Comparable<Node> { 
		int x;
		int y;
		int time;
		
		Node(int x, int y, int depth) {
			this.x = x;
			this.y = y;
			this.time = depth;
		}
		
		public int compareTo(Node o) {
			return this.time - o.time;
		}
		
	}

}
