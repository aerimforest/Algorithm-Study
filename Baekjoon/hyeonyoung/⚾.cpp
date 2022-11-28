// 221106_BOJ_17281

#include <iostream>

using namespace std;

int N, inning[50][9], order[9], answer = 0;
bool visit[10];

void solve(int idx)
{
    if (idx == 9)
    {
        // for (int i = 0; i < 9; ++i)
        // {
        //     cout << order[i] << " ";
        // }
        // cout << "\n";

        int score = 0, turn = 0;
        for (int n = 0; n < N; ++n)
        {
            int out = 0;
            bool base[3] = {0, 0, 0};
            while (out < 3)
            {
                int num = order[turn];
                if (inning[n][num] == 0)
                {
                    out++;
                }
                else if (inning[n][num] == 1)
                {
                    score += base[2];
                    base[2] = base[1];
                    base[1] = base[0];
                    base[0] = 1;
                }
                else if (inning[n][num] == 2)
                {
                    score += base[1] + base[2];
                    base[2] = base[0];
                    base[1] = 1;
                    base[0] = 0;
                }
                else if (inning[n][num] == 3)
                {
                    score += base[0] + base[1] + base[2];
                    base[2] = 1;
                    base[1] = base[0] = 0;
                }
                else if (inning[n][num] == 4)
                {
                    score += base[0] + base[1] + base[2] + 1;
                    base[2] = base[1] = base[0] = 0;
                }
                turn = (turn + 1) % 9;
            }
        }
        answer = max(answer, score);

        return;
    }

    if (idx == 3)
    {
        solve(idx + 1);
        return;
    }

    for (int i = 1; i < 9; ++i)
    {
        if (visit[i] == false)
        {
            visit[i] = true;
            order[idx] = i;
            solve(idx + 1);
            visit[i] = false;
        }
    }
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    for (int i = 0; i < N; ++i)
    {
        for (int j = 0; j < 9; ++j)
        {
            cin >> inning[i][j];
        }
    }

    order[3] = 0;
    visit[0] = true;
    solve(0);

    cout << answer;

    return 0;
}
