// queue1 이 내가 목표로 하는 것보다 크면 queue1에서 꺼내기
// queue2 가 크면 queue2 에서 꺼내기
// 만약 하나가 비어버거나, 반복문 횟수를 초과하면 종료

import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        
        Queue<Integer> listQueue1 = new LinkedList<>();
        Queue<Integer> listQueue2 = new LinkedList<>();
        
        long sum1 = 0L;
        long sum2 = 0L;
        
        int size = queue1.length * 2 + 2;
        
        for(int i=0;i<queue1.length;i++) {
            int num1 = queue1[i];
            int num2 = queue2[i];
            
            listQueue1.add(num1);
            listQueue2.add(num2);
            
            sum1 += num1;
            sum2 += num2;
        }
        
        int count = 0;
        
        while(count <= size && !listQueue1.isEmpty() && !listQueue2.isEmpty()) {
            
            if(sum1 == sum2) {
                return count;
            } else if(sum1 > sum2) {
                int popNum = listQueue1.poll();
                sum1 -= popNum;
                
                listQueue2.add(popNum);
                sum2 += popNum;
            } else {
                int popNum = listQueue2.poll();
                sum2 -= popNum;
                
                listQueue1.add(popNum);
                sum1 += popNum;
            }
            
            count++;
        }
        
        
        return -1;
    }
}