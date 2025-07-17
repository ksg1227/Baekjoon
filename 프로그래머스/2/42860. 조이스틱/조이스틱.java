import java.util.*;

class Solution {
    
    int differentCount = 0;
    int leftRight = Integer.MAX_VALUE;
    boolean[] visited;
    
    public int solution(String name) {
        int topBottom = 0;
        
        visited = new boolean[name.length()];
        
        for(int i=0;i<name.length();i++) {
            if(name.charAt(i) != 'A') {
                differentCount++;
            } else {
                visited[i] = true;
            }
            
            topBottom += Math.min(moveBottom(name.charAt(i)), moveTop(name.charAt(i)));
        }
        
        dfs(0, differentCount, 0, 0, name.length());
        
        
        
        return leftRight + topBottom;
    }
    
    int moveBottom(char target) {
        return 'Z' - target + 1;
    }
    
    int moveTop(char target) {
        return target - 'A';
    }
    
    Move moveLeft(int length, int currentIndex) {
        int count = 0;
        
        for(int i = currentIndex;i>=0;i--) {
            if(!visited[i]) {
                return new Move(i, count);
            }
            count++;
        }
        
        for(int i=length-1;i>=currentIndex+1;i--) {
            if(!visited[i]) {
                return new Move(i, count);
            }
            count++;
        }
        
        return new Move(-1, Integer.MAX_VALUE);
    }
    
    Move moveRight(int length, int currentIndex) {
        
        int count = 0;
        
        for(int i=currentIndex;i<length;i++) {
            if(!visited[i]) {
                return new Move(i, count);
            }
            count++;
        }
        
        for(int i=0;i<currentIndex;i++) {
            if(!visited[i]) {
                return new Move(i, count);
            } 
            count++;
        }
        
        return new Move(-1, Integer.MAX_VALUE);
    }
    
    void dfs(int currentCount, int differentCount, int distance, int currentIndex, int length) {
        
        
        System.out.println(currentIndex + " | " + distance + " | " + currentCount);
        
        if(currentCount == differentCount) {
            leftRight = Math.min(distance, leftRight);
            return;
        }
        
        
        Move right = moveRight(length, currentIndex);
        
        visited[right.targetIndex] = true;
        dfs(currentCount + 1, differentCount, distance + right.moveCount, right.targetIndex, length);
        visited[right.targetIndex] = false;
        
        Move left = moveLeft(length, currentIndex);
        
        visited[left.targetIndex] = true;
        dfs(currentCount + 1, differentCount, distance + left.moveCount, left.targetIndex, length);
        visited[left.targetIndex] = false;
        
    }
    
    class Move {
        int targetIndex;
        int moveCount;
        
        Move(int targetIndex, int moveCount) {
            this.targetIndex = targetIndex;
            this.moveCount = moveCount;
        }
    }
    
    
}