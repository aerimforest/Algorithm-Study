import java.io.*;
import java.util.*;

public class Main {

    static int kingx ;
    static int kingy ;
    static int stonex;
    static int stoney;

    static boolean check(int i, int j) {
        if(1<=i&&i<=8 && 1<=j&&j<=8)return true;
        return false;
    }

    static int[][] arr = new int[9][9];
    static int[] di = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dj = {0, 1, 1, 1, 0, -1, -1, -1};

    static void move(int di, int dj) {

        int kni = kingx+di;
        int knj = kingy+dj;

        if(check(kni, knj)) {
            if(kni==stonex && knj==stoney) {

                if(check(stonex+di, stoney+dj)) {
                    stonex+=di; stoney+=dj;
                    kingx = kni; kingy = knj;
                }
            }
            else {
                kingx = kni; kingy = knj;
            }
        }
    }


    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer ST = new StringTokenizer(br.readLine());

        String king = ST.nextToken();
        kingx = king.charAt(1)-'0';
        kingy = king.charAt(0)-'A'+1;

        String stone = ST.nextToken();
        stonex = stone.charAt(1)-'0';
        stoney = stone.charAt(0)-'A'+1;
        int movenum = Integer.parseInt(ST.nextToken());

        int di = 0; int dj = 0;
        for(int i=0; i<movenum; i++) {
            String mtype = br.readLine();


            if(mtype.equals("T")) {
                di = 1; dj=0;	//
            }else if(mtype.equals("RT")) {
                di = 1; dj=1;	//
            }else if(mtype.equals("R")) {
                di = 0; dj=1;
            }else if(mtype.equals("RB")) {
                di=-1; dj=1;	//
            }else if(mtype.equals("B")) {
                di=-1; dj=0;	//
            }else if(mtype.equals("LB")) {
                di = -1; dj=-1;	//
            }else if(mtype.equals("L")) {
                di = 0; dj=-1;
            }else if(mtype.equals("LT")) {
                di = 1; dj=-1;	//
            }

            move(di, dj);
        }
        char ky = (char) ('A'+kingy -1);
        char sy = (char) ('A'+stoney -1);

        System.out.println(ky+""+kingx+"\n"+sy+stonex);
    }
}
