import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        
        // 장르별로 노래 두개
        // 노래가 하나뿐이면 하나만
        
        int index = 0;
        
        // 장르 재생 횟수
        Map<String, Integer> map1 = new HashMap<>();
        
        // 각 장르에 속한 노래들
        Map<String, List<Integer>> map2 = new HashMap<>();
        
        // 초기화
        for(int i=0;i<genres.length;i++) {
            String genre = genres[i];
            int play = plays[i];
            
            map1.put(genre, map1.getOrDefault(genre, 0) + play);
            
            List<Integer> temp = map2.getOrDefault(genre, new ArrayList<>());
            temp.add(i);
            map2.put(genre, temp);
        }
        
        int size = 0;
        
        for(String key : map2.keySet()) {
            List<Integer> songs = map2.get(key);
            
            if(songs.size() >= 2) {
                size +=2;
            } else{
                size +=1;
            }
        }
        
        answer = new int[size];
        
        
        List<Node> genreFrequency = new ArrayList<>();
        
        // 장르 재생 횟수를 확인하고 가장 빈도수가 높은 장르부터 확인
        for(String key : map1.keySet()) {
            int count = map1.get(key);
            genreFrequency.add(new Node(key, count));
        }
        
        // 가장 빈도가 높은 장르에 속한 노래들
        Collections.sort(genreFrequency, Collections.reverseOrder());
        
        // 해당 장르에 속한 노래들 중에서 가장 빈도수가 높은 노래를 먼저 수록
        // 빈도수가 같은 노래들 중 가장 고유번호가 낮은 노래 먼저 수록
        for(Node node : genreFrequency) {
            String genre = node.genre;
            
            List<Integer> songs = map2.get(genre);
            
            List<Node2> sortedSongs = new ArrayList<>();
            
            for(int song : songs) {
                sortedSongs.add(new Node2(song, plays[song]));
            }
            
            Collections.sort(sortedSongs);
            
            for(int i=0;i<Math.min(sortedSongs.size(), 2);i++) {
                Node2 sortedSong = sortedSongs.get(i);
                answer[index++] = sortedSong.song;
            }
            
        }
        
        
        // 각 노래가 몇 번 재생되었는지
        
        return answer;
    }
    
    class Node implements Comparable<Node> {
        String genre;
        int count;
        
        Node(String genre, int count) {
            this.genre = genre;
            this.count = count;
        }
        
        public int compareTo(Node o) {
            return this.count - o.count;
        }
    }
    
    class Node2 implements Comparable<Node2> {
        int song;
        int count;
        
        Node2(int song, int count) {
            this.song = song;
            this.count = count;
        }
        
        public int compareTo(Node2 o) {
            if(this.count == o.count) {
                return this.song - o.song;
            }
            return o.count - this.count;
        }
    }
}