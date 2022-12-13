import java.util.*;

class Solution {
    static HashMap<String, Integer> ht;
    
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Music> m_list = new ArrayList<>();
        ht = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            m_list.add(new Music(i, genre, play));
            if (!ht.containsKey(genre)) {
                ht.put(genre, play);
            } else {
                ht.put(genre, ht.get(genre) + play);
            }
        }
        Collections.sort(m_list);
        
        ArrayList<Integer> ans = new ArrayList<>();
        int cnt = 0;
        String prev = " ";
        for (int i = 0; i < m_list.size(); i++) {
            String name = m_list.get(i).name;
            if (name.equals(prev)) {
                // 장르 내에서 최대 2개까지 앨범에 넣는다
                if (cnt == 2) continue;
                ans.add(m_list.get(i).no);
                cnt++;
            } else {
                ans.add(m_list.get(i).no);
                cnt = 1;
                prev = name;
            }
        }
        
        int[] answer = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }
        return answer;
    }
    
    static class Music implements Comparable<Music> {
        String name;
        int play, no;
        
        public Music(int no, String name, int play) {
            this.no = no;
            this.name = name;
            this.play = play;
        }
        
	    public int compareTo(Music o) {
            if (!this.name.equals(o.name)) {
                // 재생수가 많은 순으로 장르를 정렬한다(내림차순)
                return ht.get(o.name) - ht.get(this.name);
            } else if (this.play != o.play) {
                // 장르별 노래를 재생수가 않은 순으로 정렬한다(내림차순)
                return o.play - this.play;
            } else {
                /// 장르 내에서 재생수가 같은 노래 중에서는 고유 번호가 낮은 노래를 고른다(오름차순)
                return this.no - o.no;
            }
	    }
    }
}
