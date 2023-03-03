// 230107_BOJ_20040

#include <iostream>

using namespace std;

int N, M, answer = 0;
int point[500001];

int find_set(int x)
{
    if (point[x] == x)
    {
        return x;
    }
    return point[x] = find_set(point[x]);
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> M;
    for (int i = 0; i < N; ++i)
    {
        point[i] = i;
    }
    for (int i = 1; i <= M; ++i)
    {
        int a, b;
        cin >> a >> b;

        if (answer > 0)
        {
            continue;
        }

        int A = find_set(a), B = find_set(b);
        if (A == B)
        {
            answer = i;
        }
        else
        {
            point[A] = B;
        }
    }
    cout << answer;

    return 0;
}
