import java.io.*;
import java.util.*;

public class Main {

    static int time = 0;

    static int[] dx = {0, -1, 1, 0, 0};
    static int[] dy = {0, 0, 0, -1, 1};

    static int N;
    static int M;
    static int K;

    static Queue<Shark> queue = new LinkedList<>();

    // 각 상어들의 위치
    static Position[] position;

    // 실제 상어의 위치들을표시한 맵
    static int[][] board;

    // 상어의 방향 추적
    static int[] direction;

    // 각 상어들의 우선순위
    // 1번 상어 - 위쪽, 아래쪽, 왼쪽, 오른쪽 을 각각 보고있을 때
    // 각각에 대해 어느 방향이 최우선 순위인지 체크
    // 0 - 위
    // 1 - 아래
    // 2 - 왼
    // 3 - 오른
    static int[][][] priority;

    // 냄새가 몇 초 남았는지 추적
    static int[][] smell;

    // 해당 칸에 냄새를 남긴 상어가 어떤 상어인지 추적
    static int[][] which;

    // 이전에 움직인 상어가 어떤 것인지 체크
    static int count;

    // 큰 수 -> 작은 수로 갈수록 우선순위가 높으니 뒤에서부터 집어넣기
    // 1번 상어가 나올 때마다 1초가 지났다고 생각하면 됨
    // 이전에 나온 상어가 1번인데, 그 다음에 나온 상어도 1번이면 1번 상어만 남은거임

    // 내가 지나온 곳이 있을테니 무조건 내가 갈 수 있는 곳은 존재

    // 1. 빈 칸 찾기

    // 2. 빈 칸이 없다면 내 냄새가 있는 곳 찾

    public static void main(String[] args) throws IOException {
        init();

        bfs();

        if(count > 1) {
            System.out.println(-1);
        } else {
            System.out.println(time);
        }

    }


    static void bfs() {

        while(time < 1000) {
            Shark shark = queue.poll();

            int currentNum = shark.num;
            int currentX = shark.x;
            int currentY = shark.y;
            int currentDirection = shark.direction;


            // 현재 상어의, 현재 방향에 대한 이동 우선 순위
            int[] currentPriority = priority[currentNum][currentDirection];

            // 빈 공간 체크
            boolean blankIsExist = false;
            for(int i=1;i<=4;i++) {
                int nextX = currentX + dx[currentPriority[i]];
                int nextY = currentY + dy[currentPriority[i]];

                if(nextX < N && nextX >= 0 && nextY < N && nextY >= 0) {
                    if(smell[nextX][nextY] == 0) {
                        position[currentNum] = new Position(nextX, nextY);
                        direction[currentNum] = currentPriority[i];
                        board[currentX][currentY] = 0;
                        blankIsExist = true;
                        break;
                    }
                }
            }


            // 빈 공간이 없다면 내 냄새가 존재하는 칸으로 이동
            if(!blankIsExist) {
                for(int i=1;i<=4;i++) {
                    int nextX = currentX + dx[currentPriority[i]];
                    int nextY = currentY + dy[currentPriority[i]];

                    if(nextX < N && nextX >= 0 && nextY < N && nextY >= 0) {
                        if(which[nextX][nextY] == currentNum) {
                            position[currentNum] = new Position(nextX, nextY);
                            direction[currentNum] = currentPriority[i];  // 방향 설정
                            board[currentX][currentY] = 0;
                            break;
                        }
                    }
                }
            }

            // 여기까지 하면 각 상어들이 이동할 경로가 position에 저장되어있음.
            // 그럼 1번 상어까지 결정되면 그 후에 실제로 이동시키면 됨

            if(shark.num == 1) {
                time++;

                decreaseSmellLimit();

                // 실제로 이동시키고 없애기
                for(int i=M;i>=1;i--) {
                    if(position[i] != null) {
                        Position nextPosition = position[i];

                        int nextX = nextPosition.x;
                        int nextY = nextPosition.y;

                        if(board[nextX][nextY] != 0 && board[nextX][nextY] > i) {  // 이동한 위치에 나보다 우선순위가 낮은 상어가 있다면 걔를 내쫓음
                            position[board[nextX][nextY]] = null;
                            count--;
                        }

                        board[nextPosition.x][nextPosition.y] = i;
                        smell[nextX][nextY] = K;
                        which[nextX][nextY] = i;
                    }

                }

                if(count == 1) {
                    return;
                }

                for(int i=M;i>=1;i--) {
                    if(position[i] != null) {
                        Position temp = position[i];
                        queue.offer(new Shark(i, temp.x, temp.y, direction[i]));
                    }
                }

            }

        }
    }



    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        count = M;

        position = new Position[M+1];

        board = new int[N][N];

        direction = new int[M+1];

        smell = new int[N][N];

        which = new int[N][N];

        priority = new int[M+1][5][5];

        // 최초 상어들 위치 추적 및 냄새 설정하기
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                int num = Integer.parseInt(st.nextToken());

                if(num != 0) {
                    position[num] = new Position(i, j);
                    board[i][j] = num;
                    smell[i][j] = K;
                    which[i][j] = num;
                }
            }
        }

        st = new StringTokenizer(br.readLine());

        // 최초 방향 지정하기
        for(int i=1;i<=M;i++) {
            int initDirection = Integer.parseInt(st.nextToken());

            direction[i] = initDirection;
        }

        // 우선 순위 설정하기
        for(int i=1;i<=M;i++) {
            for(int j=1;j<=4;j++) {
                st = new StringTokenizer(br.readLine());

                for(int k=1;k<=4;k++) {
                    int direction = Integer.parseInt(st.nextToken());

                    priority[i][j][k] = direction;
                }

            }
        }

        // 큐에 상어들 채우기
        for(int i=M;i>=1;i--) {
            Position currentPos = position[i];

            queue.offer(new Shark(i, currentPos.x, currentPos.y, direction[i]));
        }
    }


    static void decreaseSmellLimit() {
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(smell[i][j] > 0) {
                    smell[i][j]--;

                    if(smell[i][j] == 0) {
                        which[i][j] = 0;
                    }
                }
            }
        }
    }


    static class Position {
        int x;
        int y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Shark {
        int num;
        int x;
        int y;
        int direction;

        Shark(int num, int x, int y, int direction) {
            this.num = num;
            this.x = x;
            this.y = y;
            this.direction = direction;
        }

    }

}

