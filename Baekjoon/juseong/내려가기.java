import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cur[] = new int[3];
        int prevMax[] = new int[3];
        int prevMin[] = new int[3];
        int tempMax[] = new int[3];
        int tempMin[] = new int[3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int j = 0; j < 3; j++) {
            prevMax[j] = Integer.parseInt(st.nextToken());
        }
        prevMin = prevMax.clone();
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                cur[j] = Integer.parseInt(st.nextToken());
            }
            tempMax = prevMax.clone();
            tempMin = prevMin.clone();

            prevMax[0] = cur[0] + Math.max(tempMax[0], tempMax[1]);
            prevMax[1] = cur[1] + Math.max(tempMax[2], Math.max(tempMax[0], tempMax[1]));
            prevMax[2] = cur[2] + Math.max(tempMax[1], tempMax[2]);

            prevMin[0] = cur[0] + Math.min(tempMin[0], tempMin[1]);
            prevMin[1] = cur[1] + Math.min(tempMin[2], Math.min(tempMin[0], tempMin[1]));
            prevMin[2] = cur[2] + Math.min(tempMin[1], tempMin[2]);

        }

        Arrays.sort(prevMax);
        Arrays.sort(prevMin);

        System.out.println(prevMax[2] + " " + prevMin[0]);
    }
}
