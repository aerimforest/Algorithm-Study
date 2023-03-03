import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static char[][] arr ;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());

		arr = new char[N][N];

		draw(0,0,N,false);

		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++){
			bw.write(arr[i]);
			bw.write("\n");
		}
		bw.flush();
		bw.close();		
	}

	public static void draw(int X, int Y, int N, boolean blank){
		if(blank){
			for(int i=X;i<X+N;i++){
				for(int j=Y;j<Y+N;j++){
					arr[i][j] = ' ';
				}
			}
			return;
		}

		if(N==1){
			arr[X][Y] = '*' ;
			return;
		}
		
		int PatternSize = N/3;
		int count = 0;

		for(int i=X;i<X+N;i += PatternSize){
			for(int j=Y; j<Y+N; j+= PatternSize){
				count ++;
				if(count == 5) draw(i,j,PatternSize, true);
				else draw(i,j,PatternSize,false);
			}
		}

	}

}
