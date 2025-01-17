import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 스터디 1주차
 * 백트래킹
 * 백준 14888번 : 연산자 끼워넣기
 */

public class Main {

    static int N;
    static int[][] map;
    static int[] team;

    static int minDifference = Integer.MAX_VALUE;

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        team = new int[N + 1];   // 스타트팀 소속이면 1값, 링크팀 소속이면 0값

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backTracking(0, 1);

        System.out.println(minDifference);

    }

    static void backTracking(int startTeamSize, int index) {
        if (startTeamSize == N / 2) {
            int startTeamScore = 0;
            int linkTeamScore = 0;

            for (int i = 1; i <= N - 1; i++) {
                for (int j = i + 1; j <= N; j++) {
                    if (team[i] == 1 && team[j] == 1) {
                        startTeamScore += map[i][j];
                        startTeamScore += map[j][i];
                    } else if (team[i] == 0 && team[j] == 0) {
                        linkTeamScore += map[i][j];
                        linkTeamScore += map[j][i];
                    }
                }
            }

            minDifference = Math.min(minDifference, Math.abs(startTeamScore - linkTeamScore));
        }

        for (int i = index; i <= N; i++) {
            team[i] = 1;
            backTracking(startTeamSize + 1, i + 1);
            team[i] = 0;
        }
    }


    public static void main(String[] args) throws IOException {
        solution();
    }

}







