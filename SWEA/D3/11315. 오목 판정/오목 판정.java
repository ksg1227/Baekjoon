import java.io.*;

public class Solution {
	
	static char[][] map;
	
	static int[] dx = {-1, 0, 1, 0, -1, -1, 1, 1};
	static int[] dy = {0, 1, 0, -1, 1, -1, 1, -1};
	
	static int N;
	
	// 북, 동, 남, 서, 북동, 북서, 남동, 남
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=1;i<=T;i++) {
			N = Integer.parseInt(br.readLine());
			
			map = new char[N][N];
			
			for(int j=0;j<N;j++) {
				String input = br.readLine();
				
				for(int k=0;k<N;k++) {
					map[j][k] = input.charAt(k);
				}
			}
			
			boolean flag = false;
			
			
			for(int j=0;j<N;j++) {
				for(int k=0;k<N;k++) {
					if(map[j][k] == 'o') {
						if(check(j, k)) {
							flag = true;
						}
					}
				}
				
				if(flag) break;
			}
			
			if(flag) {
				sb.append("#" + i + " YES").append("\n");
			} else {
				sb.append("#" + i + " NO").append("\n");
			}
		}
		
		System.out.println(sb);
		
		
		
		
		
	}
	
	static boolean check(int x, int y) {
		
		for(int i=0;i<8;i++) {
			
			int currentX = x;
			int currentY = y;
			
			boolean flag = true;
			
			for(int k=0;k<4;k++) {
				currentX += dx[i];
				currentY += dy[i];
				
				if(currentX >= 0 && currentX < N && currentY >= 0 && currentY < N) {
					if(map[currentX][currentY] == '.' ) {
						flag = false;
						break;
					}
				} else {
					flag= false;
					break;
				}
				
			}
			
			if(flag) {
				return true;
			}
		}
		
		return false;
	}

}
