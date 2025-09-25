// 이번 달까지 선물을 주고받은 기록을 바탕으로
// 다음달에 누가 선물을 많이 받을지 '예측'

// 두 사람 사이에 더 선물을 많이 준 사람이 선물을 받음

// 두 사람이 선물을 주고 받은 기록이 하나도 없거나, 주고받은 수가 같다면, 선물 지수가 더 큰 사람이 선물 지수가 더 작은 사람에게 하나 받음

// 선물 지수 -> 이번 달까지 자신이 친구들에게 준 선물의 수 - 받은 선물의 수
// 선물 지수까지 같다면, 다음 달에 선물을 주고받지 않는다.

import java.util.*;

class Solution {
    
    // 이름이랑 배열 순서 맞추기
    Map<String, Integer> nameIndex = new HashMap<>();
    
    // 선물 지수 (배열 인덱스, 선물 지수))
    Map<Integer, Integer> giftScore = new HashMap<>();
    
    public int solution(String[] friends, String[] gifts) {
        
        // 행 : 선물을 준 사람
        // 열 : 선물을 받은 사람
        int[][] giftBoard = new int[friends.length][friends.length];
        
        int maxReceive = Integer.MIN_VALUE;
        
        for(int i=0;i<friends.length;i++) {
            nameIndex.put(friends[i], i);
            giftScore.put(i, 0);
        }
        
        for(String gift : gifts) {
            String[] data = gift.split(" ");
            String sender = data[0];
            String receiver = data[1];
            
            int senderIndex = nameIndex.get(sender);
            int receiverIndex = nameIndex.get(receiver);
            
            giftBoard[senderIndex][receiverIndex] += 1;
            giftBoard[receiverIndex][senderIndex] -= 1;
            
            giftScore.put(senderIndex, giftScore.get(senderIndex) + 1);
            giftScore.put(receiverIndex, giftScore.get(receiverIndex) - 1);
        }
        
        for(int i=0;i<giftBoard.length;i++) {
            
            int nextMonthReceive = 0;
            
            for(int j=0;j<giftBoard[i].length;j++) {
                if(i != j) {
                    // i가 j에게 선물을 더 많이 준 경우
                    if(giftBoard[i][j] > 0) {
                        nextMonthReceive++;
                    } else if(giftBoard[i][j] == 0) { // 선물을 주고받지 않았거나, 주고 받은 양이 동일한 경우
                        
                        // 선물 지수 체크
                        int myGiftScore = giftScore.get(i);
                        int othersGiftScore = giftScore.get(j);
                        
                        // 내 선물 지수가 더 높다면
                        if(myGiftScore > othersGiftScore) {
                            nextMonthReceive++;
                        }
                    }
                }
            }
            
            maxReceive = Math.max(maxReceive, nextMonthReceive);
        }
        
        return maxReceive;
    }
}