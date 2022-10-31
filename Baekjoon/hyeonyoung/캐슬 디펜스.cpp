// 221031_BOJ_17135

#include <iostream>
#include <vector>

using namespace std;

int N, M, D;
bool archer[16], board[16][16];
int answer = 0;

int defense()
{
    int ret = 0;

    bool tmp[16][16];
    for (int i = 0; i < N; ++i)
    {
        for (int j = 0; j < M; ++j)
        {
            tmp[i][j] = board[i][j];
        }
    }

    while (1)
    {
        int cnt = 0;
        for (int i = 0; i < N; ++i)
        {
            for (int j = 0; j < M; ++j)
            {
                if (tmp[i][j])
                {
                    cnt++;
                }
            }
        }
        if (cnt == 0)
        {
            break;
        }

        // 활 쏘기
        vector<pair<int, int>> die;
        for (int k = 0; k < M; ++k)
        {
            if (archer[k])
            {
                int x = 100, y = 100, d = 100;
                for (int i = 0; i < N; ++i)
                {
                    for (int j = 0; j < M; ++j)
                    {
                        if (tmp[i][j])
                        {
                            int dd = abs(i - N) + abs(j - k);
                            if (dd < d)
                            {
                                d = dd;
                                x = i;
                                y = j;
                            }
                            else if (dd == d && j < y)
                            {
                                d = dd;
                                x = i;
                                y = j;
                            }
                        }
                    }
                }
                if (d <= D)
                {
                    die.push_back({x, y});
                }
            }
        }
        for (pair<int, int> d : die)
        {
            if (tmp[d.first][d.second])
            {
                ret++;
                tmp[d.first][d.second] = 0;
            }
        }

        // 적 이동
        for (int i = N - 1; i > 0; --i)
        {
            for (int j = 0; j < M; ++j)
            {
                tmp[i][j] = tmp[i - 1][j];
            }
        }
        for (int j = 0; j < M; ++j)
        {
            tmp[0][j] = 0;
        }
    }

    return ret;
}

void solve(int cnt, int idx)
{
    if (cnt == 3)
    {
        answer = max(answer, defense());

        return;
    }
    if (idx >= M)
    {
        return;
    }

    solve(cnt, idx + 1);
    archer[idx] = true;
    solve(cnt + 1, idx + 1);
    archer[idx] = false;
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> M >> D;
    for (int i = 0; i < N; ++i)
    {
        for (int j = 0; j < M; ++j)
        {
            cin >> board[i][j];
        }
    }

    solve(0, 0);

    cout << answer;

    return 0;
}
