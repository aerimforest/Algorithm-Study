import java.io.*;
import java.util.*;

public class Main {

	static int G;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		G = sc.nextInt();
		
		int start = 1 ;
		int end = 2 ;
		boolean flag = false;
		
		while(end<100000){
			int SQRstart = start * start ;
			int SQRend = end * end;
			if (SQRend == SQRstart + G){
				System.out.println(end);
				flag = true;
			}

			if(SQRend-SQRstart < G ){
				end += 1 ;
			}else{
				start += 1;
			}

		}

		if(!flag) System.out.println(-1);
	}
}
