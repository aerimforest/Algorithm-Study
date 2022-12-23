// 221224_BOJ_5582

#include <iostream>
#include <string>

using namespace std;

string A, B;
int memo[4001][4001], answer = 0;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> A >> B;
    int a = A.length(), b = B.length();

    for (int i = 1; i <= a; ++i)
    {
        for (int j = 1; j <= b; ++j)
        {
            if (A[i - 1] == B[j - 1])
            {
                memo[i][j] = memo[i - 1][j - 1] + 1;
            }

            answer = max(answer, memo[i][j]);
        }
    }

    cout << answer;

    return 0;
}
