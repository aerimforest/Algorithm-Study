import java.util.*;
import java.io.*;

class Solution {
    public int solution(String name) {
        int answer = 0 ;
        int NameL = name.length(); // 이름 길이
        
        int NxtIdx; // 다음 값들을 확인할 때 사용
        int move = NameL - 1 ; // 좌우 움직임 수 체크
        
        for(int i=0;i<NameL;i++){
            answer += Math.min(name.charAt(i)-'A', 'Z'-name.charAt(i)+1);
            NxtIdx = i+1 ;
            // 연속하는 A 확인
            while(NxtIdx<NameL && name.charAt(NxtIdx) == 'A'){
                NxtIdx ++ ;
            }
            
            //순서대로, 뒤로 가는 것 비교
            move = Math.min(move, i*2 + NameL - NxtIdx);
            // 뒷부분부터 입력하는 경우
            move = Math.min(move,(NameL-NxtIdx)*2 + i);
            
        }
        return answer + move;
        
    }
}
