// 221022_BOJ_20922

#include <iostream>
#include <set>

using namespace std;

int N, K, A[200001];
int cnt[100001], ans = 1;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> K;
    for (int i = 0; i < N; ++i)
    {
        cin >> A[i];
    }

    set<int> S;
    int x = 0, y = 0;
    while (x <= y && x < N)
    {
        if (!S.empty())
        {
            if (--cnt[A[x]] <= K)
            {
                S.erase(A[x]);
            }
            x++;
        }
        else if (y < N)
        {
            if (++cnt[A[y]] > K)
            {
                S.insert(A[y]);
            }
            y++;
        }
        else
        {
            x++;
        }

        if (S.empty())
        {
            ans = max(ans, y - x);
        }
    }

    cout << ans;

    return 0;
}
