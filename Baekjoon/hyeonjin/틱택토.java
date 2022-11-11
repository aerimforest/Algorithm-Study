import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    private static int pieceXNum;
    private static int pieceONum;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            StringTokenizer str = new StringTokenizer(br.readLine());
            String data = str.nextToken();
            if(data.equals("end")) break;
            char[][] grid = MakeGrid(data);
            if(CheckNormalStatus(grid))
                bw.write("valid");
            else
                bw.write("invalid");
            bw.newLine();
        }
        bw.flush();
    }

    private static boolean CheckNormalStatus(char[][] grid) {
        if(!CheckNumberOfPiece(grid)) return false;
        if(!CheckSuccess(grid)) return false;
        return true;
    }

    private static boolean CheckSuccess(char[][] grid) {
        int success = 0;
        int addNum;
        addNum = GetNumberofSuccess_Width(grid);
        if(addNum == -1) return false;
        success += addNum;
        addNum = GetNumberofSuccess_Height(grid);
        if(addNum == -1) return false;
        success += addNum;
        addNum = GetNumberofSuccessDiagonal(grid);
        if(addNum == -1) return false;
        success += addNum;

        if(success > 2)
            return false;
        if(success == 1)
            return true;

        if(CheckExistEmpty(grid))
            return false;
        return true;
    }

    private static boolean CheckEndofWinnerTurn(char winner) {
        if(winner == 'X')
        {
            if(pieceXNum == pieceONum + 1)
                return true;
            else
                return false;
        }
        else{
            if(pieceXNum == pieceONum)
                return true;
            else
                return false;
        }

    }

    private static int GetNumberofSuccess_Width(char[][] grid) {
        int success = 0;
        for(int i = 0; i < 3; i++){
            char firstPiece = grid[i][0];
            if(firstPiece != '.' && firstPiece == grid[i][1] && firstPiece == grid[i][2]){
                if(!CheckEndofWinnerTurn(firstPiece)) return -1;
                success++;
            }
        }
        return success;
    }

    private static int GetNumberofSuccess_Height(char[][] grid) {
        int success = 0;
        for(int i = 0; i < 3; i++){
            char firstPiece = grid[0][i];
            if(firstPiece != '.' && firstPiece == grid[1][i] && firstPiece == grid[2][i]) {
                if (!CheckEndofWinnerTurn(firstPiece)) return -1;
                success++;
            }
        }
        return success;
    }

    private static int GetNumberofSuccessDiagonal(char[][] grid) {
        int success = 0;

        if(grid[0][0] != '.' && grid[0][0] == grid[1][1] && grid[0][0] == grid[2][2]) {
            if(!CheckEndofWinnerTurn(grid[0][0])) return -1;
            success++;
        }

        if(grid[0][2] != '.' &&grid[0][2] == grid[1][1] && grid[0][2] == grid[2][0]) {
            if(!CheckEndofWinnerTurn(grid[0][2])) return -1;
            success++;
        }

        return success;
    }

    private static boolean CheckExistEmpty(char[][] grid) {
        for(int i =0;i < 3; i++){
            for(int j = 0 ; j<3; j++){
                if(grid[i][j] == '.')
                    return true;
            }
        }
        return false;
    }

    //말의 수가 정상적인지 체크
    private static boolean CheckNumberOfPiece(char[][] grid) {
        pieceXNum = 0;
        pieceONum = 0;
        for(int i =0;i < 3; i++){
            for(int j = 0 ; j<3; j++){
                if(grid[i][j] == 'X')
                    pieceXNum++;
                else if(grid[i][j] == 'O')
                    pieceONum++;
            }
        }

        if(pieceXNum != pieceONum && pieceXNum != pieceONum + 1)
            return false;

        return true;
    }

    public static char[][] MakeGrid(String str){
        char[][] grid = new char[3][3]; //틱택토 격자판
        int strIndex = 0;
        for(int i =0; i < 3; i++){
            for(int j =0; j < 3; j++){
                grid[i][j] = str.charAt(strIndex);
                strIndex++;
            }
        }
        return grid;
    }
}
