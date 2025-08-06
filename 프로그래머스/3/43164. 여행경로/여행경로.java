import java.util.*;

class Solution {
    
    String[][] ticket;
    String[] path;
    
    // 사용한 티켓
    boolean[] visited;
    
    public String[] solution(String[][] tickets) {
        
        ticket = tickets;
        visited = new boolean[tickets.length];
        
        Arrays.sort(ticket, (o1, o2) -> o1[1].compareTo(o2[1]));
        
        List<String> list = new ArrayList<>();
        list.add("ICN");
        dfs("ICN", list);
        
        return path;
    }
    
    void dfs(String current, List<String> list) {
        
        // 이미 경로를 찾은 경우
        if(path != null) {
            return;
        }
        
        if(visited.length + 1 == list.size()) {
            path = list.toArray(String[]::new);
            return;
        }
        
        for(int i=0;i<ticket.length;i++) {
            if(!visited[i] && ticket[i][0].equals(current)) {
                
                list.add(ticket[i][1]);
                visited[i] = true;
                
                dfs(ticket[i][1], list);
                
                list.remove(list.size()-1);
                visited[i] = false;
            }
        }
    }
    
    
    
    
}