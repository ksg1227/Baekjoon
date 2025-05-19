import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int M;
	static int H;
	
	// 사다리를 추가한 후 형태 
	static int[][] map;
	
	static boolean successFlag = false;
	static boolean failFlag = true;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new int[H+1][N+1];
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			map[a][b] = 1;
			map[a][b+1] = -1;
		}
		
		
		int plus = 0;
		
		while(plus <= 3) {
			failFlag = true;
			
			check(0, plus, 1);
			
			
			if(failFlag) {
				break;
			}
			
			if(successFlag) {
				break;
			}
			plus++;
		}
		
//		System.out.println("결과 : " + plus);
		
		if(failFlag || plus > 3) {
			System.out.println(-1);
		} else {
			System.out.println(plus);
		}
		
		
	}
	
	
	static void check(int count, int plus, int start) {
		
		
		if(count == plus) {
			
			failFlag = false;
			
			if(runGame(plus)) {
				successFlag = true;
			}
			
			return;
		}
		
		
		for(int i=start;i<=N*H;i++) {
			int x = (i-1) / N + 1;
			int y = (i-1) % N + 1;
			
			// 사다리가 그어져있지 않다면 
			if(map[x][y] == 0) {

				// 오른쪽으로 그을 수 있는 경우
				if(y != N && map[x][y+1] == 0) {
					
					map[x][y] = 1;
					map[x][y+1] = -1;
					check(count+1, plus, i+1);
					map[x][y] = 0;
					map[x][y+1] = 0;
				}
			}
		}
		 
	}
	

	
	// runGame 하기 전에 map 에 적용해둬야
	static boolean runGame(int num) {
		
//		printMap(num);
		
		for(int i=1;i<=N;i++) {
			int col = i;
			
			for(int j=1;j<=H;j++) {
				if(map[j][col] == 1) {
					col++;
				} else if(map[j][col] == -1){
					col--;
				}
				
			}
			
//			System.out.println("시작점 : " + i + " 도착점 : " + col);
			
			if(col != i) {
				return false;
			}
		}
		
		return true;
	}
	
	static void printMap(int num) {
		System.out.println();
		System.out.println("게임 시작 : " + num + "개 추가 ");
		for(int i=1;i<=H;i++) {
			for(int j=1;j<=N;j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
