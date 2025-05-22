import java.io.*;
import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Map<String, Integer> participantMap = new HashMap<>();
        
        for(int i=0;i<participant.length;i++) {
            String player = participant[i];
            participantMap.put(player, participantMap.getOrDefault(player, 0) + 1);
        }
        
        for(int i=0;i<completion.length;i++) {
            String completePlayer = completion[i];
            if(participantMap.containsKey(completePlayer)) {
                participantMap.put(completePlayer, participantMap.get(completePlayer) - 1);
            }
        }
        
        for(String key : participantMap.keySet()) {
            if(participantMap.get(key) == 1) {
                answer = key;
            }
        }
        
        
        return answer;
    }
}