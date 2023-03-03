import java.util.*;
import java.io.*;
 
// 6시 40분 시작
//  Si에 시작해서 Ti에 끝나는 N개의 수업이 주어지는데, 최소의 강의실을 사용해서 모든 수업을 가능하게
// Ti == Sj 인 경우 같은 강의실

// 시간 제한 1초 (1 ≤ N ≤ 200,000),  (0 ≤ Si < Ti ≤ 109)
// 해시맵을 사용하여 시작시간 있는 거 가져온 다음에 remove 형식 => 시작 지점이 같은 경우 ... 탈락

class Time implements Comparable<Time>{ 
    int start, end;
    Time(int start, int end){
        this.start = start;
        this.end = end;
    }

    @Override
	public int compareTo(Time o) {
        if(this.start == o.start){ // 시작시간이 같으면 끝나는 시간이 낮은 순으로
            return this.end - o.end ;
        }else return this.start - o.start; // 시작시간 낮은 순대로 정렬
    }
}

class Main {
    static int N; // 수업 개수
    static Time[] arr ; 

    public static int stoi(String s){
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws Exception {
        // 값 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = stoi(br.readLine()); 
        arr = new Time[N];

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = (new Time(stoi(st.nextToken()), stoi(st.nextToken())));
        }

        Arrays.sort(arr); // 시작시간 순대로 정렬


        System.out.println(CountLectureRoom());

     }

     public static int CountLectureRoom(){
        PriorityQueue<Integer> q = new PriorityQueue();
        q.add(arr[0].end);

        for(int i=1;i<N;i++){
            if(arr[i].start >= q.peek()){
                q.poll();
            }
            q.add(arr[i].end);
        }
        return q.size();
     }
}
