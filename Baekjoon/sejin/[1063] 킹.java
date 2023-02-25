import java.io.*;
import java.util.*;


public class Main {

	static int N; 
	static int[][] map;
	static int KingX, KingY , RockX, RockY;
	static int[] dx = {1,-1,0,0,1,-1,1,-1}, dy={0,0,-1,1,1,1,-1,-1};

	static String[] dists = {"R", "L", "B", "T", "RT", "LT", "RB", "LB"};
	static int[] distNums = {0,1,2,3,4,5,6,7};

	public static void main(String[] args) throws IOException {

		Map<String, Integer> distHm = new HashMap<>();
		for(int i=0;i<8;i++){
			distHm.put(dists[i],distNums[i]);
		}

		// 값 입력받기 -->
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String KingXY = st.nextToken();
		
		KingX = KingXY.charAt(0)-'A';
		KingY = (KingXY.charAt(1)-'0')-1;

		String rockXY = st.nextToken();
		RockX = rockXY.charAt(0)-'A';
		RockY = (rockXY.charAt(1)-'0')-1;

		N = Integer.parseInt(st.nextToken());

		for(int i=0;i<N;i++){
			String nowDist = br.readLine();
			int dist = distHm.get(nowDist);
			
			int Kxx = KingX + dx[dist]; // 킹 이동
			int Kyy = KingY + dy[dist];
			// System.out.println(Kxx + " , " + Kyy);

			// 킹 범위 확인
			if(checkRange(Kxx,Kyy)) continue ;

			// System.out.println("King Pass ! ");

			if(Kxx == RockX && Kyy == RockY){
				int Rxx = RockX + dx[dist]; // 돌 이동
				int Ryy = RockY + dy[dist];
				// System.out.println(Rxx + " , " + Ryy);

				// 같이 이동하는데 돌이 범위를 벗어난 경우
				if(checkRange(Rxx,Ryy)) continue ;
				// System.out.println("Rock Pass ! ");

				RockX = Rxx ;
				RockY = Ryy ;
			}
			// System.out.println("King move ! ");

			KingX = Kxx ;
			KingY = Kyy ;

			// System.out.println(KingX + " " + KingY);
			// System.out.println(RockX + " " + RockY);
			// System.out.println();

		}

		StringBuilder sb = new StringBuilder();


		String king = convertX(KingX) + convertY(KingY) ;
		String rock = convertX(RockX) + convertY(RockY) ;
		System.out.println(king);
		System.out.print(rock);

	} 
	
	public static String convertX(int xx){
		char character = (char)(xx + 'A') ;
		return Character.toString(character);
	}

	public static String convertY(int yy){
		char character = (char)(yy + '1') ;
		return Character.toString(character);
	}


	public static boolean checkRange(int xx,int yy){
		if(xx<0 || xx>7 || yy<0 || yy>7 ) return true ;
		return false ;
	}
}


