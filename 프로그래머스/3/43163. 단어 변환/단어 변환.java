import java.util.*;

class Solution {
    
    int count = 0;
    boolean[] visited;
    
    public int solution(String begin, String target, String[] words) {
        
        visited = new boolean[words.length];
        
        bfs(begin, target, words);
        
        return count;
    }
    
    void bfs(String begin, String target, String[] words) {
        Queue<Node> queue = new LinkedList<>();
        
        queue.offer(new Node(begin, 0));
        
        while(!queue.isEmpty()) {
            
            Node node = queue.poll();
            String word = node.word;
            int currentCount = node.count;
            
            if(word.equals(target)) {
                count = currentCount;
                return;
            }
            
            for(int i=0;i<words.length;i++) {
                // 해당 단어로 변경한 적 없고 && 오직 한 자리만 다르다면
                if(!visited[i] && isDifferentOnlyOne(word, words[i])) {
                    visited[i] = true;
                    queue.offer(new Node(words[i], currentCount+1));
                }
            }
        }
        
    }
    
    boolean isDifferentOnlyOne(String current, String target) {
        int differentCount = 0;
        
        for(int i=0;i<current.length();i++) {
            if(current.charAt(i) != target.charAt(i)) {
                differentCount++;
            }
        }
        
        if(differentCount == 1) {
            return true;
        } else {
            return false;
        }
    }
    
    class Node {
        String word;
        int count;
        
        Node(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }
    
    // 현재 단어와 바꾸고자 하는 단어가 알파벳 하나만 차이 나야함
    // 바꾸고자 하는 단어로 바꾼 적이 없어야함.
}