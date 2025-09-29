class Solution {

    // 그대로 사용
    int[] lionPoint = new int[11];
    int maxScoreDiff = Integer.MIN_VALUE;
    int[] answer = new int[11];

    public int[] solution(int n, int[] info) {
        // 변경: DFS 파라미터를 (현재 점수칸 인덱스 i, 남은 화살 left)로
        dfs(0, n, info);

        if (allZero(answer)) {
            return new int[]{-1};
        }
        return answer;
    }

    // 변경된 DFS: i는 0..10 (10점~0점), left는 남은 화살 수
    void dfs(int i, int left, int[] info) {
        // 끝까지 왔거나(모든 점수칸 결정) 남은 화살이 없으면 평가
        if (i == 11 || left == 0) {
            // 남은 화살이 있으면 0점 칸(인덱스 10)에 몰아줘서 tie-break 유리하게
            if (left > 0) {
                lionPoint[10] += left;
            }

            Score score = totalScore(info);
            if (score.isLionWin()) {
                int currentScoreDiff = score.scoreDiff();

                if (currentScoreDiff > maxScoreDiff) {
                    maxScoreDiff = currentScoreDiff;
                    for (int k = 0; k <= 10; k++) answer[k] = lionPoint[k];
                } else if (currentScoreDiff == maxScoreDiff) {
                    // tie-break: 낮은 점수(인덱스 10부터) 더 많이 맞힌 게 우선
                    for (int k = 10; k >= 0; k--) {
                        if (lionPoint[k] == answer[k]) continue;
                        if (lionPoint[k] > answer[k]) {
                            for (int t = 0; t <= 10; t++) answer[t] = lionPoint[t];
                        }
                        break; // 첫 차이에서 결정
                    }
                }
            }

            if (left > 0) {
                lionPoint[10] -= left; // 복구
            }
            return;
        }

        // 현재 칸 점수: (10 - i)
        // 선택 1) 이 칸을 이겨서 점수를 가져간다 (어피치보다 1발 더 많이)
        int need = info[i] + 1;
        if (need <= left) {
            lionPoint[i] += need;
            dfs(i + 1, left - need, info);
            lionPoint[i] -= need; // 복구
        }

        // 선택 2) 이 칸을 포기 (0발)
        dfs(i + 1, left, info);
    }

    // 그대로 사용
    Score totalScore(int[] apeachPoint) {
        int apeachScore = 0;
        int lionScore = 0;

        for (int i = 0; i <= 10; i++) {
            int apeachCount = apeachPoint[i];
            int lionCount = lionPoint[i];

            if (apeachCount == 0 && lionCount == 0) continue;

            if (apeachCount >= lionCount) {
                apeachScore += 10 - i;
            } else {
                lionScore += 10 - i;
            }
        }
        return new Score(apeachScore, lionScore);
    }

    boolean allZero(int[] arr) {
        for (int num : arr) if (num != 0) return false;
        return true;
    }

    class Score {
        int apeachScore;
        int lionScore;

        Score(int apeachScore, int lionScore) {
            this.apeachScore = apeachScore;
            this.lionScore = lionScore;
        }

        boolean isLionWin() { return this.lionScore > apeachScore; }
        int scoreDiff() { return this.lionScore - this.apeachScore; }
    }
}
