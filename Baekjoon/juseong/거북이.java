import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	static int dr[]	= {-1,0,1,0};
	static int dc[]	= {0,1,0,-1};
	static int maxr,maxc,minr,minc,r,c;
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			String cmd = sc.next();
			char cmds[] = cmd.toCharArray();//글자 몇개가 들어올지 모르므로
			int d = 0; //처음에 거북이가 북쪽을 쳐다보고있음.
			r=0;c=0;
			//Integer.MIN,MAX value로 하면 안된다. 0,0이 시작점이기 때문.
			maxr=0; maxc=0;
			minr=0; minc=0;
			
			for (int i = 0; i < cmds.length; i++) {
				char command = cmds[i];
				switch (command) {
				case 'F':
					r += dr[d];
					c += dc[d];
					update();
					break;
				case 'B':
					r -= dr[d];
					c -= dc[d];
					update();
					break;
				case 'L':
					//왼쪽으로 방향 변경
					d = (d - 1 + 4)%4;
					break;
				case 'R':
					//오른쪽으로 방향 변경
					d = (d + 1 + 4)%4;
					break;
				}
			}//end command
			//System.out.println(maxr +" "+maxc +" "+minr+" "+minc);
			int res = Math.abs(maxr - minr) * Math.abs(maxc - minc);
			System.out.println(res);
		}
	}
	static void update() {
		maxr = Math.max(maxr, r);
		maxc = Math.max(maxc, c);
		minr = Math.min(minr, r);
		minc = Math.min(minc, c);		
	}

}
