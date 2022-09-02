// 220902_BOJ_2467

#include <iostream>

using namespace std;

int N, solution[100001];

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    for (int i = 0; i < N; ++i)
    {
        cin >> solution[i];
    }

    int x = 0, y = N - 1;
    int ans = 0x7fffffff;
    pair<int, int> memo;
    while (x < y)
    {
        int mix = solution[x] + solution[y];
        if ((mix < 0 ? -mix : mix) < (ans < 0 ? -ans : ans))
        {
            ans = mix;
            memo = {x, y};
        }

        if (mix < 0)
        {
            x++;
        }
        else
        {
            y--;
        }
    }

    cout << solution[memo.first] << " " << solution[memo.second];

    return 0;
}
