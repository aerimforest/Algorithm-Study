// 221228_BOJ_15683

#include <iostream>
#include <vector>
#include <cstring>

using namespace std;

int N, M, office[10][10];
int visit[10][10], answer = 0x7fffffff, wall = 0;
vector<pair<int, int>> cctv;
vector<int> dir;

int dx[] = {1, 0, -1, 0};
int dy[] = {0, 1, 0, -1};

void view(int x, int y, int k)
{
    while (x >= 0 && x < N && y >= 0 && y < M && office[x][y] != 6)
    {
        visit[x][y] = 1;
        x += dx[k];
        y += dy[k];
    }
}

void solve(int idx)
{
    if (idx == cctv.size())
    {
        memset(visit, 0, sizeof(visit));
        for (int i = 0; i < idx; ++i)
        {
            int x = cctv[i].first, y = cctv[i].second;
            if (office[x][y] == 1)
            {
                view(x, y, dir[i]);
            }
            else if (office[x][y] == 2)
            {
                view(x, y, dir[i]);
                view(x, y, (dir[i] + 2) % 4);
            }
            else if (office[x][y] == 3)
            {
                view(x, y, dir[i]);
                view(x, y, (dir[i] + 1) % 4);
            }
            else if (office[x][y] == 4)
            {
                view(x, y, dir[i]);
                view(x, y, (dir[i] + 1) % 4);
                view(x, y, (dir[i] + 2) % 4);
            }
            else if (office[x][y] == 5)
            {
                view(x, y, 0);
                view(x, y, 1);
                view(x, y, 2);
                view(x, y, 3);
            }
        }

        int cnt = 0;
        for (int i = 0; i < N; ++i)
        {
            for (int j = 0; j < M; ++j)
            {
                if (visit[i][j] == 0)
                {
                    cnt++;
                }
            }
        }
        answer = min(answer, cnt - wall);
        return;
    }

    int x = cctv[idx].first, y = cctv[idx].second;
    if (office[x][y] == 1)
    {
        for (int k = 0; k < 4; ++k)
        {
            dir.push_back(k);
            solve(idx + 1);
            dir.pop_back();
        }
    }
    else if (office[x][y] == 2)
    {
        for (int k = 0; k < 2; ++k)
        {
            dir.push_back(k);
            solve(idx + 1);
            dir.pop_back();
        }
    }
    else if (office[x][y] == 3)
    {
        for (int k = 0; k < 4; ++k)
        {
            dir.push_back(k);
            solve(idx + 1);
            dir.pop_back();
        }
    }
    else if (office[x][y] == 4)
    {
        for (int k = 0; k < 4; ++k)
        {
            dir.push_back(k);
            solve(idx + 1);
            dir.pop_back();
        }
    }
    else if (office[x][y] == 5)
    {
        dir.push_back(0);
        solve(idx + 1);
        dir.pop_back();
    }
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> M;
    for (int i = 0; i < N; ++i)
    {
        for (int j = 0; j < M; ++j)
        {
            cin >> office[i][j];

            if (office[i][j] > 0 && office[i][j] < 6)
            {
                cctv.push_back({i, j});
            }
            if (office[i][j] == 6)
            {
                wall++;
            }
        }
    }

    solve(0);
    cout << answer;

    return 0;
}
