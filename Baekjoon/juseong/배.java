import java.util.*;

public class Main {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N, M;
        N = sc.nextInt();
        ArrayList<Integer> crain = new ArrayList<Integer>();
        ArrayList<Integer> boxes = new ArrayList<Integer>();
        for(int i = 1; i <= N; i++){
            int crainWeight = sc.nextInt();
            crain.add(crainWeight);
        }
        M = sc.nextInt();
        for(int i = 1; i <= M; i++){
            int boxWeight = sc.nextInt();
            boxes.add(boxWeight);
        }
        Collections.sort(crain);
        Collections.sort(boxes);
        System.out.println(getTime(crain,boxes));
    }
    
    public static int getTime(ArrayList<Integer> crain, ArrayList<Integer> boxes){
        int crainSize = crain.size()-1, boxSize = boxes.size()-1;
        if(boxes.get(boxSize) > crain.get(crainSize)) return -1;
        boolean[] check = new boolean[boxSize+5];
        int ret = 0, delNum = 0;
        while(delNum <= boxSize){
            for(int i = 0; i <= crainSize; i++){
                boolean crainUse = false;
                for(int j = boxSize; j >= 0; j--){
                    if(!check[j] && boxes.get(j) <= crain.get(i)){
                        crainUse = true;
                        check[j] = true;
                        delNum++;
                        break;
                    }
                }
                if(!crainUse){
                    crain.remove(i);
                    crainSize--;
                    i--;
                }
            }
            ret++;
        }
        return ret;
    }
}
