// 221012_BOJ_1976

#include <iostream>

using namespace std;

int N, M, adj[201][201];
int S[201];

int findParent(int x)
{
    if (S[x] == x)
    {
        return x;
    }
    return S[x] = findParent(S[x]);
}
void unionSet(int x, int y)
{
    S[findParent(x)] = findParent(y);
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> M;
    for (int i = 1; i <= N; ++i)
    {
        for (int j = 1; j <= N; ++j)
        {
            cin >> adj[i][j];
        }
        S[i] = i;
    }

    // union-find
    for (int i = 1; i <= N; ++i)
    {
        for (int j = 1; j < i; ++j)
        {
            if (adj[i][j] == 1)
            {
                unionSet(i, j);
            }
        }
    }

    // 연결 확인
    int x;
    cin >> x;
    int par = findParent(x);
    bool ans = true;
    for (int i = 2; i <= M; ++i)
    {
        cin >> x;
        if (par != findParent(x))
        {
            ans = false;
        }
    }

    if (ans)
    {
        cout << "YES";
    }
    else
    {
        cout << "NO";
    }

    return 0;
}
