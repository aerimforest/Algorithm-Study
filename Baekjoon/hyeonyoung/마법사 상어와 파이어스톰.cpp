// 221014_BOJ_20058

#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int N, Q, A[65][65];
int tmp[65][65], visit[65][65];
int dx[] = {-1, 1, 0, 0};
int dy[] = {0, 0, -1, 1};

void firestorm(int L)
{
    // 회전
    for (int i = 0; i < (1 << (N - L)); ++i)
    {
        for (int j = 0; j < (1 << (N - L)); ++j)
        {
            int x = i * (1 << L), y = j * (1 << L);

            for (int r = 0; r < (1 << L); ++r)
            {
                for (int c = 0; c < (1 << L); ++c)
                {
                    tmp[r][c] = A[x + r][y + c];
                }
            }

            for (int r = 0; r < (1 << L); ++r)
            {
                for (int c = 0; c < (1 << L); ++c)
                {
                    A[x + r][y + c] = tmp[(1 << L) - 1 - c][r];
                }
            }
        }
    }

    // for (int i = 0; i < (1 << N); ++i)
    // {
    //     for (int j = 0; j < (1 << N); ++j)
    //     {
    //         cout << A[i][j] << " ";
    //     }
    //     cout << "\n";
    // }

    // 얼음 감소
    vector<pair<int, int>> reduce;
    for (int i = 0; i < (1 << N); ++i)
    {
        for (int j = 0; j < (1 << N); ++j)
        {
            if (A[i][j] == 0)
            {
                continue;
            }
            int cnt = 0;
            for (int k = 0; k < 4; ++k)
            {
                int x = i + dx[k], y = j + dy[k];
                if (x < 0 || x >= (1 << N) || y < 0 || y >= (1 << N))
                {
                    continue;
                }
                if (A[x][y] > 0)
                {
                    cnt++;
                }
            }
            if (cnt < 3)
            {
                reduce.push_back({i, j});
            }
        }
    }
    for (pair<int, int> i : reduce)
    {
        A[i.first][i.second]--;
    }
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> Q;
    for (int i = 0; i < (1 << N); ++i)
    {
        for (int j = 0; j < (1 << N); ++j)
        {
            cin >> A[i][j];
        }
    }

    for (int q = 0; q < Q; ++q)
    {
        int l;
        cin >> l;

        firestorm(l);
    }

    int sum = 0, mass = 0;
    for (int i = 0; i < (1 << N); ++i)
    {
        for (int j = 0; j < (1 << N); ++j)
        {
            sum += A[i][j];
            if (A[i][j] == 0 || visit[i][j] > 0)
            {
                continue;
            }

            queue<pair<int, int>> que;
            visit[i][j] = 1;
            que.push({i, j});
            int cnt = 0;
            while (!que.empty())
            {
                int x = que.front().first, y = que.front().second;
                que.pop();

                cnt++;

                for (int k = 0; k < 4; ++k)
                {
                    int xx = x + dx[k], yy = y + dy[k];

                    if (xx < 0 || xx >= (1 << N) || yy < 0 || yy >= (1 << N))
                    {
                        continue;
                    }

                    if (A[xx][yy] > 0 && visit[xx][yy] == 0)
                    {
                        visit[xx][yy] = 1;
                        que.push({xx, yy});
                    }
                }
            }
            mass = max(mass, cnt);
        }
    }

    cout << sum << "\n";
    cout << mass << "\n";

    return 0;
}
