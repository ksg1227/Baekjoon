import java.util.*;
import java.io.*;

class Solution {
    
    public int solution(int[][] routes) {
        int answer = 0;
        
        int lastCameraPosition = -30001;
        
        List<Route> list = new ArrayList<>();
        
        for(int i=0;i<routes.length;i++) {
            list.add(new Route(routes[i][0], routes[i][1]));
        }
        
        Collections.sort(list);
        
        for(Route route : list) {
            
            // 단속 카메라를 지나지 않는 경우
            if(route.in > lastCameraPosition) {
                lastCameraPosition = route.out;
                answer++;
            }
        }
        
        return answer;
        
    }
    
    class Route implements Comparable<Route> {
        int in;
        int out;
        
        Route(int in, int out) {
            this.in = in;
            this.out = out;
        }
        
        public int compareTo(Route o) {
            return this.out - o.out;
        }
    }
    
}