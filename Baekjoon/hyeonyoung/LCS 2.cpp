// 220825_BOJ_9252

#include <iostream>
#include <string>

using namespace std;

string A, B;
int lcs[1001][1001];
char ans[1002];

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> A >> B;
    A = " " + A;
    B = " " + B;
    int a = A.length(), b = B.length();

    for (int i = 1; i < a; ++i)
    {
        for (int j = 1; j < b; ++j)
        {
            if (A[i] == B[j])
            {
                lcs[i][j] = lcs[i - 1][j - 1] + 1;
            }
            else
            {
                lcs[i][j] = max(lcs[i - 1][j], lcs[i][j - 1]);
            }
        }
    }

    cout << lcs[a - 1][b - 1] << "\n";
    int x = a - 1, y = b - 1, idx = lcs[a - 1][b - 1];
    ans[idx--] = '\0';
    while (x > 0 && y > 0)
    {
        if (A[x] == B[y])
        {
            ans[idx--] = A[x];
            x--;
            y--;
        }
        else if (lcs[x - 1][y] >= lcs[x][y - 1])
        {
            x--;
        }
        else
        {
            y--;
        }
    }
    cout << ans;

    return 0;
}
