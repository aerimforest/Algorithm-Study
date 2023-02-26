import java.io.*;
import java.util.*;

class lecture implements Comparable<lecture>{
	int start, end ;
	lecture(int start, int end){
		this.start = start;
		this.end = end;
	}

	@Override
	public int compareTo(lecture o){
		if(this.start == o.start){
			return this.end - o.end ;
		}else return this.start - o.start ;
	}
}

public class Main {

	static int N; 
	static lecture[] lectures;

	public static void main(String[] args) throws IOException {

		// 값 입력받기 -->
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		lectures = new lecture[N];

		StringTokenizer st;
		for(int i=0;i<N;i++){
			st  = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken())-1;
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			lectures[num] = new lecture(start, end) ;
		}
		// <-- 
		
		Arrays.sort(lectures); // 시작 시간순 정렬

		PriorityQueue<Integer> q = new PriorityQueue<>();

		for(int i=0;i<N;i++){
			q.offer(lectures[i].end); // 현재 강의 넣기
			
			if(q.size() < 1 ) continue ; // 큐가 비어있다면 즉 강의실을 사용중이지 않다면, 비교할 강의실이 없으므로 continue
			int endTime = q.peek(); // 제일 먼저 끝나는 시간과
			if(lectures[i].start >= endTime) q.poll(); // 다음 강의의 시작시간을 비교
		}

		System.out.println(q.size());

	} 
}

