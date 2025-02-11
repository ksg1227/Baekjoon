import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 스터디 5주차
 * 완전 탐색 - 브루트포스
 * 백준 14502번 : 연구소
 */

public class Main {

    // 0인 위치들 중에서 3개의 위치를 찾으면 됨.
    static int N;
    static int M;

    static int[][] map;
    static List<int[]> virus = new ArrayList<>();
    static List<int[]> empty = new ArrayList<>();

    static Queue<int[]> queue = new LinkedList<>();

    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    static int result = Integer.MIN_VALUE;

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;

                if (num == 0) {
                    empty.add(new int[]{i, j});
                }

                if (num == 2) {
                    virus.add(new int[]{i, j});
                }
            }
        }

        // 가능한 모든 좌표 선택
        for (int i = 0; i < empty.size() - 2; i++) {
            for (int j = i + 1; j < empty.size() - 1; j++) {
                for (int k = j + 1; k < empty.size(); k++) {
                    bfs(empty.get(i), empty.get(j), empty.get(k));
                }
            }
        }

        System.out.println(result);

    }

    static void bfs(int[] wallPosition1, int[] wallPosition2, int[] wallPosition3) {

        for (int i = 0; i < virus.size(); i++) {
            queue.add(virus.get(i));
        }

        int[][] tempMap = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tempMap[i][j] = map[i][j];
            }
        }

        // 벽세우기
        tempMap[wallPosition1[0]][wallPosition1[1]] = 1;
        tempMap[wallPosition2[0]][wallPosition2[1]] = 1;
        tempMap[wallPosition3[0]][wallPosition3[1]] = 1;

        while (!queue.isEmpty()) {
            int[] position = queue.poll();
            int currentX = position[0];
            int currentY = position[1];

            for(int i=0;i<4;i++) {
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];

                if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < M) {
                    if(tempMap[nextX][nextY] == 0) {
                        tempMap[nextX][nextY] = 2;
                        queue.add(new int[]{nextX, nextY});
                    }
                }
            }
        }

        result = Math.max(result, countSafe(tempMap));


    }


    static int countSafe(int[][] map) {
        int count = 0;

        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if(map[i][j] == 0) {
                    count++;
                }
            }
        }

        return count;
    }


    public static void main(String[] args) throws IOException {
        solution();
    }

}








