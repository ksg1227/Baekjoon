// 불량 이용자를 신고하고 처리 결과를 메일로 발송

// 각 유저는 한 번에 한 명의 유저를 신고
// 신고 횟수 제한 X -> 서로 다른 유저를 계속해서 신고 가능
// 한 유저를 여러 번 신고할 수 있음. 하지만 동일한 유저에 대한 신고 횟수는 1회로 처리됨 (Set?)

// k 번 이상 신고된 유저는 게시판 이용이 정지되며, 해당 유저를 신고한 모든 유저에게 정지 사실을 메일로 발송한다.

// 모든 내용을 취함하여 마지막에 한꺼번에 

// 각 유저별로 처리결과 메일을 받은 횟수

// 각 유저가 누구를 신고했는지 관리하는 Map<String, Set<String>>

// 각 유저가 누구에게 신고를 당했는지 Map<String, Set<String>>

import java.util.*;

class Solution {
    
    Map<String, Set<String>> reportTo = new HashMap<>();
    Map<String, Set<String>> reportFrom = new HashMap<>();
    
    Map<String, Integer> mailCount = new HashMap<>();
    
    // reportFrom.keySet();
        
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        for(String id : id_list) {
            reportTo.put(id, new HashSet<>());
            reportFrom.put(id, new HashSet<>());
            mailCount.put(id, 0);
        }
        
        for(String input : report) {
            StringTokenizer st = new StringTokenizer(input);
            
            String reporter = st.nextToken(); // 신고인
            String reportee = st.nextToken(); // 피신고인
            
            reportTo.get(reporter).add(reportee); // 신고인이 누구를 신고했는지
            reportFrom.get(reportee).add(reporter); // 피신고인이 누구한테 신고당했는디
        }
        
        for(String reportee : reportFrom.keySet()) {
            Set<String> reporter = reportFrom.get(reportee); // 나를 신고한 사람 목록
            
            // 신고 횟수가 일정 이상인 케이스
            if(reporter.size() >= k) {
                for(String reporterName : reporter) {
                    mailCount.put(reporterName, mailCount.get(reporterName) + 1);
                }
            }
        }
        
        for(int i=0;i<id_list.length;i++) {
            answer[i] = mailCount.get(id_list[i]);
        }
        
        
        return answer;
    }
}