import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // 장르 - 노래목록
        HashMap<String, ArrayList<Node>> map = new HashMap<>();
        // 장르 - 장르 내  총 재생 횟수
        HashMap<String, Integer> genre = new HashMap<>();
        
        for(int i=0; i<plays.length; i++) {
            if(!map.containsKey(genres[i])) 
                map.put(genres[i], new ArrayList<Node>());
                
            map.get(genres[i]).add(new Node(i,plays[i]));
            genre.put(genres[i], genre.getOrDefault(genres[i],0)+plays[i]);
        }
        
        ArrayList<String> keys = new ArrayList<>(genre.keySet());
        // 장르를 재생횟수 내림차순 정렬
        Collections.sort(keys, (o1, o2) -> genre.get(o2)- genre.get(o1));
        
        ArrayList<Integer> list = new ArrayList<>();
        for (String key : keys) {
            // 노래를 재생수 내림차순 , 번호 오름차순으로 정렬
            Collections.sort(map.get(key));
            
            // 1순위 2순위 list에 추가
            list.add(map.get(key).get(0).num);
            if(map.get(key).size() > 1)
                list.add(map.get(key).get(1).num);
        }
        
        int[] answer = new int[list.size()];
        for(int j=0; j<list.size(); j++) {
            answer[j] = list.get(j);
        }
        
        return answer;
    }
    
    public class Node implements Comparable<Node> {
        int num;
        int play;
        
        public Node(int num, int play) {
            this.num = num;
            this.play = play;
        }
        
        @Override
        public int compareTo(Node n) {
            if(this.play != n.play)
                return n.play - this.play;
            else
                return this.num - n.num;
        }
    }
}

/*
+6
정확성  테스트
테스트 1 〉	통과 (1.32ms, 80.5MB)
테스트 2 〉	통과 (1.29ms, 74MB)
테스트 3 〉	통과 (1.29ms, 79.8MB)
테스트 4 〉	통과 (0.98ms, 72.4MB)
테스트 5 〉	통과 (2.01ms, 78.6MB)
테스트 6 〉	통과 (1.41ms, 71.8MB)
테스트 7 〉	통과 (1.05ms, 78.2MB)
테스트 8 〉	통과 (1.19ms, 77.7MB)
테스트 9 〉	통과 (1.35ms, 78.3MB)
테스트 10 〉	통과 (1.62ms, 70.7MB)
테스트 11 〉	통과 (1.23ms, 76.1MB)
테스트 12 〉	통과 (2.77ms, 73.3MB)
테스트 13 〉	통과 (1.67ms, 79.9MB)
테스트 14 〉	통과 (1.80ms, 80.3MB)
테스트 15 〉	통과 (1.84ms, 88.2MB)
 */