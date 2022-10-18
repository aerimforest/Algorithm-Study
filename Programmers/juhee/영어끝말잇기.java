import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        
        int len = words.length;
        Map<String, Integer> map = new HashMap<>();
        int[] answer = new int[2];
        char last = words[0].charAt(words[0].length() - 1);
        map.put(words[0], 1);
        for (int i = 1; i < len; i++) {
            // System.out.println(words[i]);
            if(last != words[i].charAt(0) || map.containsKey(words[i])) {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            } else {
                map.put(words[i], 1);
                last = words[i].charAt(words[i].length() - 1);
            }
        }
        

        return answer;
    }
}


/*
+1
테스트 1 〉	통과 (0.06ms, 73.3MB)
테스트 2 〉	통과 (0.05ms, 73.5MB)
테스트 3 〉	통과 (0.02ms, 73.8MB)
테스트 4 〉	통과 (0.05ms, 87.4MB)
테스트 5 〉	통과 (0.07ms, 75.5MB)
테스트 6 〉	통과 (0.02ms, 70.2MB)
테스트 7 〉	통과 (0.04ms, 74.8MB)
테스트 8 〉	통과 (0.04ms, 78.9MB)
테스트 9 〉	통과 (0.04ms, 77.5MB)
테스트 10 〉	통과 (0.08ms, 81.1MB)
테스트 11 〉	통과 (0.05ms, 79MB)
테스트 12 〉	통과 (0.04ms, 69.7MB)
테스트 13 〉	통과 (0.04ms, 74.5MB)
테스트 14 〉	통과 (0.03ms, 77.5MB)
테스트 15 〉	통과 (0.03ms, 84.9MB)
테스트 16 〉	통과 (0.03ms, 76.5MB)
테스트 17 〉	통과 (0.03ms, 80MB)
테스트 18 〉	통과 (0.02ms, 76.5MB)
테스트 19 〉	통과 (0.03ms, 67.4MB)
테스트 20 〉	통과 (0.08ms, 79.6MB)
*/
