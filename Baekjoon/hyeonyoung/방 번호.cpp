// 221217_BOJ_1082

#include <iostream>
#include <string>

using namespace std;

int N, M, P[10];
string dp[51];

string max(string A, string B)
{
    int a = A.length(), b = B.length();
    if (a > 1 && A[0] == '0')
    {
        A = "0";
        a = 1;
    }
    if (b > 1 && B[0] == '0')
    {
        B = "0";
        b = 1;
    }

    if (a == b)
    {
        if (A < B)
        {
            return B;
        }
        else
        {
            return A;
        }
    }
    if (a < b)
    {
        return B;
    }
    return A;
}
string make_max(string A, string B)
{
    int idx = A.length(), i = 0;
    for (i = 0; i < idx; ++i)
    {
        if (A[i] - '0' <= stoi(B))
        {
            break;
        }
    }
    return A.insert(i, B);
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    for (int i = 0; i < N; ++i)
    {
        cin >> P[i];
    }
    cin >> M;

    for (int i = 1; i <= M; ++i)
    {
        for (int j = 0; j < N; ++j)
        {
            if (i - P[j] >= 0)
            {
                dp[i] = max(dp[i], make_max(dp[i - P[j]], to_string(j)));
            }
        }
    }
    cout << dp[M];

    return 0;
}
