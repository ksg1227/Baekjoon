import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, V;
	
	static PriorityQueue<Integer>[] dfsAdjList, bfsAdjList;
	static boolean[] visited;
	
	static StringBuilder forDfs, forBfs;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		dfsAdjList = new PriorityQueue[N+1];
		bfsAdjList = new PriorityQueue[N+1];
		
		visited = new boolean[N+1];
		
		forDfs = new StringBuilder();
		forBfs = new StringBuilder();
		
		for(int i=1;i<=N;i++) {
			dfsAdjList[i] = new PriorityQueue<>();
			bfsAdjList[i] = new PriorityQueue<>();
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			dfsAdjList[start].add(end);
			dfsAdjList[end].add(start);
			
			bfsAdjList[start].add(end);
			bfsAdjList[end].add(start);
		}

		visited[V] = true;
		dfs(V);
		Arrays.fill(visited, false);
		bfs(V);
		
		System.out.println(forDfs);
		System.out.println(forBfs);
		
	}
	
	static void dfs(int current) {
		
		forDfs.append(current).append(" ");
		
		while(!dfsAdjList[current].isEmpty()) {
			int next = dfsAdjList[current].poll();
			
			if(!visited[next]) {
				visited[next] = true;
				dfs(next);
			}
		}
	}
	
	static void bfs(int start) {
		
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(start);
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			int num = queue.poll();
			
			forBfs.append(num).append(" ");
			
			while(!bfsAdjList[num].isEmpty()) {
				int next = bfsAdjList[num].poll();
				
				if(!visited[next]) {
					visited[next] = true;
					queue.add(next);
				}
			}
		}
	}

}
