// 221109_BOJ_1717

#include <iostream>

using namespace std;

int N, M;
int parent[1000001];

int findParent(int x)
{
    if (parent[x] == x)
    {
        return x;
    }
    return parent[x] = findParent(parent[x]);
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> M;
    for (int i = 1; i <= N; ++i)
    {
        parent[i] = i;
    }

    for (int i = 0; i < M; ++i)
    {
        int x, a, b;
        cin >> x >> a >> b;

        // 합집합
        if (x == 0)
        {
            parent[findParent(a)] = findParent(b);
        }
        // 같은 집합?
        else
        {
            int A = findParent(a), B = findParent(b);
            if (A == B)
            {
                cout << "YES\n";
            }
            else
            {
                cout << "NO\n";
            }
        }
    }

    return 0;
}
