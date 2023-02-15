import java.io.*;
import java.util.*;

// 연속된 K개의 수 + C (1개) : 중복이 최대한 없게
// 단순구현밖에 생각이 나지 않아요 ...
// 초밥의 종류가 1이상 D 이하다 ...
// 해시맵의 냄새가 나는 문젠데...

public class Main {

    static int N,D,K,C;
    

    public static int stoi(String str){
        return Integer.parseInt(str);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken()); // 접시의 수
        D = stoi(st.nextToken()); // 초밥의 가짓수
        K = stoi(st.nextToken()); // 연속해서 먹는 접시의 수
        C = stoi(st.nextToken()); // 쿠폰 번호

        HashMap<Integer, Integer> hm = new HashMap<>();
        int[] arr = new int[N];

        for(int i=0;i<N;i++) arr[i] = stoi(br.readLine());

        for(int i=0;i<K;i++){
            int nowNum = arr[i];
            if(hm.containsKey(nowNum)) hm.put(nowNum, hm.get(nowNum)+1);
            else hm.put(nowNum,1);
        }

        int maxResult = hm.size();

        for(int i=1;i<N+K;i++){
            // 이전값 삭제
            int befNum = arr[Math.abs(K-i)];
            if(hm.get(befNum) == 1 )hm.remove(befNum);
            else hm.put(befNum, hm.get(befNum)-1);

            int nowNum = arr[i%N];
            // 다음 값 넣기
            hm.put(nowNum, hm.getOrDefault(nowNum, 0)+1);

            // max 값 갱신
            if(hm.containsKey(C))maxResult = Math.max(maxResult, hm.size());
            else maxResult = Math.max(maxResult, hm.size()+1);
            

        }
        System.out.println(maxResult);
    }
}
