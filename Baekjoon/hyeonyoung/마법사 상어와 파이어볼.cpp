// 221005_BOJ_20056

#include <iostream>
#include <vector>

using namespace std;

int N, M, K;
vector<int> board[51][51];
struct fireball
{
    int r, c, m, s, d;
};
int dx[] = {-1, -1, 0, 1, 1, 1, 0, -1};
int dy[] = {0, 1, 1, 1, 0, -1, -1, -1};

vector<fireball> move(vector<fireball> fireballs)
{
    for (int i = 0; i < N; ++i)
    {
        for (int j = 0; j < N; ++j)
        {
            board[i][j] = {};
        }
    }

    int idx = fireballs.size();
    for (int i = 0; i < idx; ++i)
    {
        int r = fireballs[i].r, c = fireballs[i].c;
        int m = fireballs[i].m, s = fireballs[i].s, d = fireballs[i].d;

        int rr = r + dx[d] * s, cc = c + dy[d] * s;
        while (rr < 0)
        {
            rr += N;
        }
        while (cc < 0)
        {
            cc += N;
        }
        rr %= N;
        cc %= N;

        board[rr][cc].push_back(i);
    }

    vector<fireball> ret;
    for (int i = 0; i < N; ++i)
    {
        for (int j = 0; j < N; ++j)
        {
            int S = board[i][j].size();
            if (S == 0)
            {
                continue;
            }
            else if (S == 1)
            {
                fireball tmp = fireballs[board[i][j][0]];
                tmp.r = i;
                tmp.c = j;
                ret.push_back(tmp);
                continue;
            }

            int m = 0, s = 0;
            int d = (fireballs[board[i][j][0]].d & 1);
            bool same = true;
            for (int x : board[i][j])
            {
                m += fireballs[x].m;
                s += fireballs[x].s;
                if (d != (fireballs[x].d & 1))
                {
                    same = false;
                }
            }
            same = !same;

            if (m / 5 == 0)
            {
                continue;
            }

            for (int k = 0; k < 4; ++k)
            {
                ret.push_back({i, j, m / 5, s / S, k * 2 + same});
            }
        }
    }

    // for (fireball f : ret)
    // {
    //     cout << f.r << " " << f.c << " " << f.m << " " << f.s << " " << f.d << "\n";
    // }
    // cout << "\n";

    return ret;
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    vector<fireball> fireballs;

    cin >> N >> M >> K;
    for (int i = 0; i < M; ++i)
    {
        int r, c, m, s, d;
        cin >> r >> c >> m >> s >> d;
        fireballs.push_back({r - 1, c - 1, m, s, d});
    }

    for (int k = 0; k < K; ++k)
    {
        fireballs = move(fireballs);
    }

    int ans = 0;
    for (fireball f : fireballs)
    {
        ans += f.m;
    }
    cout << ans;

    return 0;
}
