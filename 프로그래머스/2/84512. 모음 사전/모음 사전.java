class Solution {
    
    String[] alphabet = {"A", "E", "I", "O", "U"};
    int count = 0;
    int answer;
    
    public int solution(String word) {
        
        makeWord(word, "");
        return answer;
    }
    
    void makeWord(String target, String current) {
        
        if(target.equals(current)) {
            answer = count;
            return;
        }
        
        if(current.length() == 5) {
            return;
        }
        
        for(int i=0;i<5;i++) {
            count++;
            makeWord(target, current + alphabet[i]);
        }
    }
}