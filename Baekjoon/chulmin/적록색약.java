import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 적록색약 {
	// 구역 찾기는 BFS문제이다
	// 두 개의 방법으로 BFS를 처리하여 두 방법의 차이를 출력하면 된다.

	static int N, a, b;
	static char[][] mat;
	static boolean[][] visitA, visitB;

	static int[] dirx = { -1, 0, 1, 0 };
	static int[] diry = { 0, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	// bfs 계산을 한다.
	private static void pro() {
		// R, G, B 구분
		visitA = new boolean[N][N];
		// R-G, B 구분
		visitB = new boolean[N][N];

		Queue<int[]> queueA = new LinkedList<int[]>();
		Queue<int[]> queueB = new LinkedList<int[]>();

		a = 0;
		b = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 새로운 영역인지 확인한다.
				if (!visitA[i][j]) {
					// 새로운 영역이면 더해준다.
					a++;
					// 탐색 목록에 넣는다.
					queueA.add(new int[] { i, j });
				}
				// 새로운 영역인지 확인한다.
				if (!visitB[i][j]) {
					// 새로운 영역이면 더해준다.
					b++;
					// 탐색 목록에 넣는다.
					queueB.add(new int[] { i, j });
				}

				// R,G,B 탐색하기 (BFS)
				while (!queueA.isEmpty()) {
					int[] cur = queueA.poll();

					// 4방 탐색
					for (int di = 0; di < 4; di++) {
						{
							// 다음 x와 y
							int nx = cur[0] + dirx[di];
							int ny = cur[1] + diry[di];

							// 범위를 벗어났다면 PASS
							if (nx < 0 || ny < 0 || nx >= N || ny >= N)
								continue;
							// 이미 탐색한 곳이면 PASS
							if (visitA[nx][ny])
								continue;
							// 다음이 현재와 같지 않다면 PASS
							if (mat[cur[0]][cur[1]] != mat[nx][ny])
								continue;
							
							// 방문한다.
							visitA[nx][ny] = true;
							// 탐색 리스트에 넣는다.
							queueA.add(new int[] { nx, ny });
						}
					}
				}
				
				// R-G,B 탐색하기 (BFS)
				while (!queueB.isEmpty()) {
					// 탐색 시작점 꺼내기
					int[] cur = queueB.poll();
					
					// 4방 탐색
					for (int di = 0; di < 4; di++) {
						{
							// 다음 x, y
							int nx = cur[0] + dirx[di];
							int ny = cur[1] + diry[di];

							// 범위를 벗어났다면 PASS
							if (nx < 0 || ny < 0 || nx >= N || ny >= N)
								continue;
							// 방문한 곳이라면 PASS
							if (visitB[nx][ny])
								continue;
							// 만약 같은 곳이라면 탐색 범위에 넣는다.
							if(mat[cur[0]][cur[1]]== mat[nx][ny]){
								visitB[nx][ny] = true;
								queueB.add(new int[] { nx, ny });
							}
							// 만약 R-G라면 탐색 범위에 넣는다.
							else if( (mat[cur[0]][cur[1]]=='G' || mat[cur[0]][cur[1]]=='R') 
								&& (mat[nx][ny]=='G' || mat[nx][ny]=='R') 
									) {
								visitB[nx][ny] = true;
								queueB.add(new int[] { nx, ny });
							}
						}
					}
				}
			}
		}
		// 두 영역을 출력한다.
		System.out.println(a + " " + b);
	}

	// N 입력을 받고 mat를 입력받는다.
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		mat = new char[N][N];

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			mat[i] = line.toCharArray();
		}

		br.close();
	}
}
