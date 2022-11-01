import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		double X = Double.parseDouble(st.nextToken());
		double Y = Double.parseDouble(st.nextToken());
		double C = Double.parseDouble(st.nextToken());
		
		double high = Math.min(X, Y);
		double low = 0d;
		double mid = (high+low)/2;
		
		while(true) {
			double tmp = check(mid, X, Y, C);
			if(Math.abs(tmp-mid)<=0.001) break;
			else if(tmp>mid) {
				high = mid;
			}else {
				low = mid;
			}
			mid = (high+low)/2;
		}
		System.out.println(mid);
	}

	private static double check(double mid, double x, double y, double c) {
		return  c * mid / Math.sqrt(x*x-mid*mid) + c * mid / Math.sqrt(y*y-mid*mid);
		
	}

}
