import java.util.*;

class Node implements Comparable<Node>{
    int x;
    int y;
    Node(int x, int y){
        this.x = x;
        this.y = y;
    }
    @Override

    public int compareTo(Node o) {
        if(o.x < this.x) return 1;
        else return -1;
    }
}

public class Main {
    
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test_case = sc.nextInt();
        for(int T=0;T<test_case;T++){
            N = sc.nextInt();
            ArrayList<Node> arr = new ArrayList<>();

            for(int i=0;i<N;i++){
                int x= sc.nextInt();
                int y= sc.nextInt();
                arr.add(new Node(x,y));
            }

            Collections.sort(arr);
            int ans = 1;
            int min = arr.get(0).y;
            for(int i=1;i<N;i++){
                if(arr.get(i).y < min){
                    ans ++ ;
                    min = arr.get(i).y;
                }
            }
            System.out.println(ans);
        }
    }

}


