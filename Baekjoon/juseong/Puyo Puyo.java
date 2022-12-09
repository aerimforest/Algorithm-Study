import java.util.*;
import java.io.*;

public class Main {
	
	static char[][] map = new char[12][6];
	
	static int pop = 0; // 연쇄 카운트
	static boolean isPop = false; // 연쇄가 발생했는지 체크
	
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0; i<12; i++) {
			String str = br.readLine();
			for(int j=0; j<6; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		while(true) {
			isPop = false;
			
			bfs(); // 연쇄가 가능한 뿌요들을 다 터트린 후 종료
			onFloor(); // 연쇄가 끝난 후 뿌요들을 맨 아래까지 내림
			
			// 더 이상 연쇄가 발생할 것이 없다면 탈출
			if(isPop == false) {
				break;
			}
			pop++; // 한 타이밍에 연쇄가 여러 번 일어나도 한 번으로 카운트 함.
		}
		
		System.out.println(pop);
	}
	
	static void bfs() {
		Queue<Puyo> que = new LinkedList<>();
		boolean[][] isVisited = new boolean[12][6];
		
		// 탐색하면서 뿌요를 만나면 큐에 넣고 바로 탐색 시작함
		for(int i=0; i<12; i++) {
			for(int j=0; j<6; j++) {
				if(map[i][j] != '.' && !isVisited[i][j]) {
					// 같은 색의 뿌요가 붙어있다면 리스트에 넣음
					ArrayList<int[]> list = new ArrayList<>();
					
					que.add(new Puyo(i, j, map[i][j]));
					list.add(new int[] {i, j});
					isVisited[i][j] = true;
					
					while(!que.isEmpty()) {
						Puyo p = que.poll();
						
						int curX = p.x;
						int curY = p.y;
						char curColor = p.color;
					
						for(int t=0; t<4; t++) {
							int nx = curX + dx[t];
							int ny = curY + dy[t];
							
							if(nx < 0 || ny < 0 || nx >= 12 || ny >= 6) continue;
							
							if(!isVisited[nx][ny] && map[nx][ny] == curColor) {
								que.add(new Puyo(nx, ny, map[nx][ny]));
								list.add(new int[] {nx, ny});
								isVisited[nx][ny] = true;
							}
						}
						
					}
					
					// 리스트에 들어있는 뿌요의 수(같은 색의 구슬이 붙어있는 수) 가 4개 이상이면 
                    // 연쇄적으로 터트림
					if(list.size() >= 4) {
						for(int k=0; k<list.size(); k++) {
							int x = list.get(k)[0];
							int y = list.get(k)[1];
							
							map[x][y] = '.'; // 터트려서 빈 칸으로 만듦
							
							isPop = true; // 연쇄가 일어났다고 표시
						}
//						pop++; // 처음에 연쇄 할 때 마다 카운트 해야 되는 줄 알고 여기서 카운트 했음
					}
					
				}
			}
		}
	}
	
	// 모든 뿌요를 바닥까지 내림
	static void onFloor() {
		// 각 열 마다 내리는 연산 수행함
		for(int j=0; j<6; j++) {
			down(j);
		}
	}
	
	// 한 열에 있는 뿌요를 바닥까지 내림
	static void down(int j) {
		Queue<Puyo> puyo = new LinkedList<>();
		int idx = 11;
		
		/* 
		 * 뿌요의 위치를 큐에 넣음, 가장 아래에 있는 빈 칸의 인덱스를 구함 
		 * -> 가장 바닥에 있는 뿌요도 큐에 넣어서 모두 빈 칸으로 만든 뒤
		 * 가장 아래부터 큐에 있는 뿌요들을 차례로 채워나감
		*/ 
		for(int i=11; i>=0; i--) {
			if(map[i][j] != '.') {
				puyo.add(new Puyo(i, j, map[i][j]));
				map[i][j] = '.';
			}
		}
		// 뿌요를 가장 밑에 있는 빈 칸에 채워나감
		while(!puyo.isEmpty()) {
			Puyo p = puyo.poll();
			
			char color = p.color;
			
			map[idx][j] = color;
			
			idx--;
		}
					
	}
	
	static class Puyo{
		int x, y;
		char color;
		
		Puyo(int x, int y, char color){
			this.x = x;
			this.y = y;
			this.color = color;
		}
	}
		
}
