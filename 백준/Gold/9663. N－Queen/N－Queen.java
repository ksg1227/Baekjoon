import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static boolean[] col;
	static int[] pos; // 각 행의 몇 열에 퀸이 있는지 
	static int result;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		col = new boolean[N];
		pos = new int[N];
		result = 0;
		
		dfs(0);
		
		System.out.println(result);
		
		// 각 행이 점유되어있는지 체크하면 됨 
	}
	
	static void dfs(int row) {
		if(row == N) {
			result++;
			return;
		}
		
		for(int i=0;i<N;i++) {
			// 현재 열이 사용되지 않은 경우 
			if(!col[i]) {
				if(isPossible(row, i)) {
					col[i] = true;
					pos[row] = i;
					dfs(row + 1);
					col[i] = false;
				}
			}
		}
	}
	
	static boolean isPossible(int row, int col) {
		for(int i=0;i<row;i++) {
			int height = row - i;
			int width = pos[i] - col;
			
			if(Math.abs(height) == Math.abs(width)) {
				return false;
			}
		}
		
		return true;
	}

}
