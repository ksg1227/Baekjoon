// 기준에 따라 이모티콘을 구매하거나, 이모티콘 플러스 서비스에 가입함

// 이모티콘을 샀을 때, 합이 일정 가격 이상이 되면 이모티콘 구매 안하고 이모티콘 플러스 서비스에 가입함
// 할인을 많이 할수록 이모티콘을 많이 삼.
// 대신 이모티콘 플러스에 가입을 안할 수 있음

// 백트래킹 느낌인데

import java.util.*;
import java.io.*;

class Solution {
    
    int currentEmoticonPlus = Integer.MIN_VALUE;
    int currentEmoticonPrice = Integer.MIN_VALUE;
    
    int[] emoticonDiscount;
    int[] discount = {40, 30, 20, 10};
    
    public int[] solution(int[][] users, int[] emoticons) {
        
        emoticonDiscount = new int[emoticons.length];
        Arrays.fill(emoticonDiscount, 40);
        
        dfs(0, emoticons.length, users, emoticons);
        
        int[] answer = {currentEmoticonPlus, currentEmoticonPrice};
        
        return answer;
    }
    
    void dfs(int at, int size, int[][] users, int[] emoticons) {
        
        if (at == size) {
            EmoticonSell r = countEmoticonPlus(users, emoticons);
            if (r.emoticonPlusBuyCount > currentEmoticonPlus ||
                (r.emoticonPlusBuyCount == currentEmoticonPlus && r.totalPrice > currentEmoticonPrice)) {
                currentEmoticonPlus = r.emoticonPlusBuyCount;
                currentEmoticonPrice = r.totalPrice;
            }
            return;
        }

        for (int d : discount) {
            emoticonDiscount[at] = d;   // at 인덱스만 결정
            dfs(at + 1, size, users, emoticons);
        }
    }
    
    EmoticonSell countEmoticonPlus(int[][] users, int[] emoticons) {
        
        int emoticonPlusBuyCount = 0;
        int totalPrice = 0;
        
        for(int i=0;i<users.length;i++) {
            int proportion = users[i][0];
            int limitPrice = users[i][1];
            
            int sum = 0;
            
            // 각 이모티콘을 구매할지 결정
            for(int j=0;j<emoticons.length;j++) {
                // 유저가 생각한 비율보다 더 할인하는 경우 -> 구매
                if(emoticonDiscount[j] >= proportion) {
                    sum += emoticons[j] * (10 - (double)(emoticonDiscount[j] / 10)) / 10;
                }
            }
            
            // 생각한 범주를 벗어난다면 이모티콘 플러스를 삼
            if(sum >= limitPrice) {
                emoticonPlusBuyCount++;
            } else { // 생각한 범주 이내라면 그냥 이모티콘들을 삼
                totalPrice += sum;
            }
        }
        
        return new EmoticonSell(emoticonPlusBuyCount, totalPrice);
        
    }
    
    class EmoticonSell {
        int emoticonPlusBuyCount;
        int totalPrice;
        
        EmoticonSell(int emoticonPlusBuyCount, int totalPrice) {
            this.emoticonPlusBuyCount = emoticonPlusBuyCount;
            this.totalPrice = totalPrice;
        }
    }
}