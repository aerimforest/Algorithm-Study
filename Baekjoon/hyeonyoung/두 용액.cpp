// 221121_BOJ_2470

#include <iostream>
#include <algorithm>

using namespace std;

int N, sol[100001];
pair<int, int> answer = {0, 0x7fffffff};

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    for (int i = 0; i < N; ++i)
    {
        cin >> sol[i];
    }
    sort(sol, sol + N);

    int x = 0, y = N - 1;
    while (x < y)
    {
        if (abs(answer.first + answer.second) > abs(sol[x] + sol[y]))
        {
            answer = {sol[x], sol[y]};
        }

        if (sol[x] + sol[y] < 0)
        {
            x++;
        }
        else
        {
            y--;
        }
    }

    cout << answer.first << " " << answer.second;

    return 0;
}
