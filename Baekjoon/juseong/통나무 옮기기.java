import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B1938_통나무옮기기 {
	static int N, cnt, dir[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static char arr[][];
	static boolean visit[][][], startFlag, endFlag;
	static Log start, end;
	static Queue<Log> queue = new LinkedList<>();
	static class Log {
		int r, c, isRow;
		public Log(int r, int c, int isRow) {
			super();
			this.r = r;
			this.c = c;
			this.isRow = isRow; // 가로인지 세로인 구별하는 변수
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		visit = new boolean[N][N][2]; // 중심을 기준으로 가로인지 세로인지 구분하여 방문 처리
		for (int r=0;r<N;r++) {
			String input = br.readLine();
			for (int c=0;c<N;c++) {
				arr[r][c] = input.charAt(c);
				if (arr[r][c] == 'B' && start == null) { // 처음 B를 만나면 일단 위치 저장
					start = new Log(r, c, 0);
				} else if (arr[r][c] == 'B' && !startFlag) { // B를 두번째 만나면
					if (start.r == r) start.isRow = 1; // 첫번째 B와 비교하여 가로인지 세로인지 확인
					start.r = r; start.c = c;
					visit[r][c][start.isRow] = true; // 방문 처리
					startFlag = true; // 중심 만나면 B 탐색 멈춤
				} else if (arr[r][c] == 'E' && end == null) { // 처음 E와 만나면 일단 위치 저장
					end = new Log(r, c, 0); 
				} else if (arr[r][c] == 'E' && !endFlag) { // E를 두번째 만나면  
					if (end.r == r) end.isRow = 1; // 첫번째 E와 비교하여 가로인지 세로인지 확인
					end.r = r; end.c = c; 
					endFlag = true; // 중심 만나면 E 탐색 멈춤
				}
			}
		}
		queue.add(start);
		System.out.println(bfs());
	}
	
	static int bfs() {
		while(!queue.isEmpty()) {
			int size = queue.size();
			while(size-->0) {
				Log now = queue.poll();
				if (now.r == end.r && now.c == end.c && now.isRow == end.isRow) return cnt; // E와 만나면 끝
				// U D L R
				for (int i=0;i<4;i++) {
					int nr = now.r + dir[i][0];
					int nc = now.c + dir[i][1];
					// 범위를 벗어나거나 이동하려는 곳에 통나무가 있거나 이미 방문했다면 continue;
					if (!isIn(nr, nc, now.isRow) || !isInArr(nr, nc, now.isRow) && visit[nr][nc][now.isRow]) continue;
					visit[nr][nc][now.isRow] = true; // 방문 처리
					queue.offer(new Log(nr, nc, now.isRow));
				}
				// T
				int value = now.isRow == 0?1:0;
				/* 
				 범위를 벗어나거나 이동하려는 곳에 통나무가 있거나 이미 방문했다면 continue;
				 중심을 기준으로 8방향을 다 탐색 해야함 (한 줄씩 탐색)
				 */
				if (!isIn(now.r, now.c-1, 0) || !isIn(now.r, now.c, 0) || !isIn(now.r, now.c+1, 0) ||
						!isInArr(now.r, now.c-1, 0) || !isInArr(now.r, now.c, 0) || !isInArr(now.r, now.c+1, 0) &&
						visit[now.r][now.c][value]) continue;
				visit[now.r][now.c][value] = true; // 방문 처리
				queue.offer(new Log(now.r, now.c, value));
			}
			cnt++;
		}
		return 0; // E와 못만남
	}
	
	static boolean isInArr(int r, int c, int isRow) {
		for (int i=-1;i<2;i++) { // -1, 0, 1 확인
			if (isRow == 0 && arr[r+i][c] == '1') return false; // 세로이면 r-1, r, r+1에 모두 나무가 없어야함
			else if (isRow == 1 && arr[r][c+i] == '1') return false; // 가로이면 c-1, c, c+1에 모두 나무가 없어야함
		}
		return true;
	}
	
	static boolean isIn(int r, int c, int isRow) {
		if (isRow == 0) return r-1>=0 && r+1<N && c>=0 && c<N; // 세로이면 r-1, r, r+1이 모두 범위 안에 들어야함
		else return r>=0 && r<N && c-1>=0 && c+1<N; // 가로이면 c-1, c, c+1이 모두 범위 안에 들어야함
	}
}
