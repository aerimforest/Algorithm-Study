// 220825_BOJ_1783

#include <iostream>

using namespace std;

int N, M;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> M;

    int ans = 1;

    // 4번 이상
    if (N >= 3 && M >= 7)
    {
        ans = M - 2;
    }
    // 4번 미만
    else if (N == 2)
    {
        ans = min((M + 1) / 2, 4);
    }
    else if (N == 1)
    {
        ans = 1;
    }
    else if (M < 7)
    {
        ans = min(M, 4);
    }

    cout << ans;

    return 0;
}
