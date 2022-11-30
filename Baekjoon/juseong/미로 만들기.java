import java.io.*;
import java.util.*;
public class Main {
    static int n;
    static char map[][];
    static char[] move;
    static int dx[] = {0,-1,0,1,0};
    static int dy[] = {0,0,1,0,-1};
    static int dir = 3;
    static int left_x =50;
    static int left_y = 50;
    static int right_x = 50;
    static int right_y= 50;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new char[101][101];
        n = Integer.parseInt(br.readLine());
        move = new char[n];
        for(int i=0; i<101; i++) {
            for(int j=0; j<101; j++) {
                map[i][j] = '#';
            }
        }
        String input = br.readLine();
        for(int i=0; i<n; i++) {
            move[i] =input.charAt(i);
        }
        map[50][50] = '.';
        int tmp_x=50; int  tmp_y= 50;
        for(int i=0; i<n; i++) {
            char order = move[i];
            if(order !='F') {
                swap(order);
            }
            else {
                tmp_x +=dx[dir];
                tmp_y+=dy[dir];
                map[tmp_x][tmp_y] ='.';
            }
        }
        for(int i=0; i<101; i++) {
            for(int j=0; j<101; j++) {
                if(map[i][j]=='.') {
                    if(left_x > i) {
                        left_x = i;
                    }
                    if(left_y > j) {
                        left_y =j;
                    }
                    if(right_x <i) {
                        right_x =i;
                    }
                    if(right_y <j) {
                        right_y=j;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i= left_x; i<=right_x; i++) {
            for(int j=left_y; j<=right_y; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
    public static void swap(char order) {
        if(order =='R') {
            dir+=1;
            if(dir==5) {
                dir=1;
            }
        }
        else {
            dir-=1;
            if(dir==0) {
                dir=4;
            }
        }
    }
}
