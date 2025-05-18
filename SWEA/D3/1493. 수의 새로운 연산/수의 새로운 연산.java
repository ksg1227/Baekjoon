import java.io.*;
import java.util.*;

public class Solution {
	
	// 10000 칸 -> 100 * 100
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=1;i<=T;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			
			sb.append("#" + i + " " + star(p, q)).append("\n");
			
		}
		
		System.out.println(sb);
	}
	
	static int star(int p, int q) {
		Position first = op2(p);
		Position second = op2(q);
		
		int x = first.x + second.x;
		int y = first.y + second.y;
		
		return op1(x, y);
	}
	
	// # 연산 
	// x = N , y = K -> N + k - 1 번째 줄에 위치
	// 2, 1 -> 2 + 1 - 1 => 2 번째 줄에 위치 
	// 3, 3 -> 3 + 3 - 1 => 5 번째 줄에 위치 
	
	// N 번째 줄에 K번째 -> 1 ~ N-1까지 다 더한 것 + K 
	static int op1(int x, int y) {
		int line = x + y - 1;
		
		
		int sum = 0;
		
		for(int i=1;i<=line;i++) {
			sum += i;
		}
		
		return sum - (y-1);
	}
	
	// & 연산
	// N번째 줄의 시작값 = N-1 번째 줄의 시작 + N-1
	// 우선 몇 번째 줄인지 찾기. 그리고 y 값의 차이가 K 만큼 나면 해당 줄의 
	static Position op2(int p) {
		
		int stride = 0;
		int currentNum = 1;
		int line = 1;
		
		while(true) {
			
			currentNum += stride;
			
			if(currentNum > p) {
				currentNum -= stride;
				line--;
				break;
			}
			
			stride++;
			line++;
		}
		
		// 여기에 도달하면 p 가 몇번째 선에 존재하는 값인지 알 수 있음 
		// 1 + p - (currentNum)
		// line - (p-currentNum)
		return new Position(1 + (p - currentNum), line - (p-currentNum));
		
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
