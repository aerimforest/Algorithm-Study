import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, count, eatCount;
	static int[][] mat;
	static int bx, by, bsize;

	static int[] dirx = {-1, 0, 1, 0};
	static int[] diry = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		count = 0;
		while(true){
			PriorityQueue<int[]> eatAble = new PriorityQueue<>(new Comparator<int[]>() {
						@Override
						public int compare(int[] o1, int[] o2) {
							if(o1[2]== o2[2]) {
								if(o1[0]== o2[0])
									return o1[1] - o2[1];
								return o1[0] - o2[0]; 
							}
							return o1[2] - o2[2];
						}
			});
			Queue<int[]> queue = new LinkedList<int[]>();
			boolean[][] visit = new boolean[N][N];
			
			queue.add(new int[] {bx, by, 0});
			while(!queue.isEmpty()) {
				int[] cur = queue.poll();
				boolean check = false;
				for(int di=0; di<4; di++) {
					int nx = cur[0] + dirx[di];
					int ny = cur[1] + diry[di];
					
					if(nx<0||ny<0||nx>=N||ny>=N)
						continue;
					if(mat[nx][ny]>bsize)
						continue;
					if(visit[nx][ny])
						continue;
					
					visit[nx][ny] = true;
					if(mat[nx][ny] <= bsize) {
						queue.add(new int[] {nx, ny, cur[2]+1});
					}
					if(mat[nx][ny] != 0 && mat[nx][ny] < bsize) {
						queue.add(new int[] {nx, ny, cur[2]+1});
						eatAble.add(new int[] {nx, ny, cur[2] + 1});
					}
				}
			}
			
			if(eatAble.isEmpty())
				break;
			
			int[] target = eatAble.poll();
//			System.out.println(target[0] + " " + target[1] + " " + target[2]);
			eat(target);
			
		}
		System.out.println(count);
	}

	private static void eat(int[] target) {
		int x = target[0];
		int y = target[1];
		count += target[2];
		
		eatCount++;
		if(eatCount == bsize) {
			bsize++;
			eatCount = 0;
		}
		mat[x][y] = 0;
		
		bx = x;
		by = y;
	}


	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		mat = new int[N][N];
		eatCount = 0;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
				if(mat[i][j]==9) {
					bx = i;
					by = j;
					bsize = 2;
					mat[i][j] = 0;
				}
			}
		}
		
		br.close();
	}
}
