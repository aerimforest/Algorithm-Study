import java.io.*;

public class Main
{
    static int maxVal = 1000000;
    static boolean[] isPrime = new boolean[maxVal + 1];

    static int impossible(int n)
    {
        for (int i = 2; i * 2 <= n; i++)
        {
            int a = i;
            int b = n - a;
            if (isPrime[a] && isPrime[b])
                return a;
        }

        return -1;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        isPrime[1] = false;
        for (int i = 2; i <= maxVal; i++)
            isPrime[i] = true;

        for (int i = 2; i <= Math.sqrt(maxVal); i++)
        {
            if (isPrime[i] == true)
            {
                for (int j = 2; i * j <= maxVal; j++)
                    isPrime[i * j] = false;
            }
        }

        while (true)
        {
            int n = Integer.parseInt(br.readLine());
            if (n == 0)
                break;
            int chk = impossible(n);
            if (chk > 0)
                sb.append(n + " = " + chk + " + " + (n - chk)).append("\n");
            else
                sb.append("Goldbach's conjecture is wrong.").append("\n");
        }
        System.out.print(sb.toString());
    }
}
