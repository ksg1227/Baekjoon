import java.io.*;
import java.util.*;

public class Solution {
	
	static int[] card;
	static boolean[] visited;
	
	static int[] rest;
	static int[] myCard;
	
	static int win = 0;
	static int lose = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=1;i<=T;i++) {
			st = new StringTokenizer(br.readLine());
			
			win = 0;
			lose = 0;
			
			card = new int[9];
			visited = new boolean[9];
			rest = new int[9];
			myCard = new int[9];
			
			for(int j=0;j<9;j++) {
				card[j] = Integer.parseInt(st.nextToken());
			}
			
			int index = 0;
			for(int j=1;j<=18;j++) {
				
				boolean flag = false;
				for(int k=0;k<9;k++) {
					if(card[k] == j) {
						flag = true;
					}
				}
				
				if(!flag) {
					rest[index++] = j;
				}
			}
			
			game(0);
			
			sb.append("#" + i + " ").append(lose + " " + win).append("\n");
			
		}
		
		System.out.println(sb);
	}
	
	static void game(int size) {
		if(size == 9) {
			if(battle()) {
				win++;
			} else {
				lose++;
			}
			return;
		}
		
		for(int i=0;i<9;i++) {
			if(!visited[i]) {
				myCard[size] = rest[i];
				visited[i] = true;
				game(size+1);
				visited[i] = false;
			}
		}
	}
	
	static boolean battle() {
		int opponentScore = 0;
		int myScore = 0;
		
		for(int i=0;i<9;i++) {
			if(card[i] < myCard[i]) {
				myScore += card[i] + myCard[i];
			} else {
				opponentScore += card[i] + myCard[i];
			}
		}
		
		if(myScore > opponentScore) {
			return true;
		} else {
			return false;
		}
	}

}
