import java.io.*;
import java.util.*;
import java.awt.Point;


public class Main {

    static int allFloor,start,goal,up,down;
	static boolean[] visited ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        allFloor = Integer.parseInt(st.nextToken()); // 건물 높이
        start = Integer.parseInt(st.nextToken()); // 강호 위치
        goal = Integer.parseInt(st.nextToken()); // 스타트 링크 위치
        up = Integer.parseInt(st.nextToken()); // Up
        down = Integer.parseInt(st.nextToken()); // Down
		visited = new boolean[allFloor+1];
		FindWay();
    }

	public static void FindWay(){
		Queue<Point> q = new LinkedList<>();
		// Point x : 현재 층, y : 이동 횟수
		q.add(new Point(start,0));
		visited[start] = true ;

		while(!q.isEmpty()){
			Point nowFloor = q.poll();
			
			if(nowFloor.x == goal){ // 도착하면 count 출력
				System.out.println(nowFloor.y);
				System.exit(0);
			}

			// 내려갈 때
			if(nowFloor.x-down > 0 && !visited[nowFloor.x-down]){
				q.add(new Point(nowFloor.x-down, nowFloor.y + 1));
				visited[nowFloor.x-down] = true ; 
			}
			
			// 올라갈 때
			if(nowFloor.x+up <= allFloor && !visited[nowFloor.x+up]){
				q.add(new Point(nowFloor.x+up, nowFloor.y + 1));
				visited[nowFloor.x+up] = true ; 
			}
		}

		// 층에 도착하지 못하고 while 문이 끝난 경우 == 도착 못 함 
		System.out.println("use the stairs");

	}

}
