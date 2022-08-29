// 220829_BOJ_16235

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int N, M, K;
int A[11][11], ground[11][11];
vector<int> tree[11][11];

int dx[] = {-1, -1, -1, 0, 0, 1, 1, 1};
int dy[] = {-1, 0, 1, -1, 1, -1, 0, 1};

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> M >> K;
    for (int i = 0; i < N; ++i)
    {
        for (int j = 0; j < N; ++j)
        {
            cin >> A[i][j];
            ground[i][j] = 5;
        }
    }

    for (int i = 0; i < M; ++i)
    {
        int x, y, z;
        cin >> x >> y >> z;
        tree[x - 1][y - 1].push_back(z);
    }

    for (int k = 0; k < K; ++k)
    {
        // 봄
        for (int i = 0; i < N; ++i)
        {
            for (int j = 0; j < N; ++j)
            {
                if (tree[i][j].size() == 0)
                {
                    continue;
                }

                sort(tree[i][j].begin(), tree[i][j].end());
                int num = tree[i][j].size();
                for (int x = 0; x < num; ++x)
                {
                    if (ground[i][j] >= tree[i][j][x])
                    {
                        ground[i][j] -= tree[i][j][x];
                        tree[i][j][x]++;
                    }
                    else
                    {
                        tree[i][j][x] *= -1;
                    }
                }
            }
        }

        // 여름
        for (int i = 0; i < N; ++i)
        {
            for (int j = 0; j < N; ++j)
            {
                int num = tree[i][j].size(), idx = num;
                for (int x = 0; x < num; ++x)
                {
                    if (tree[i][j][x] <= 0)
                    {
                        idx = min(idx, x);
                        ground[i][j] += (-tree[i][j][x]) / 2;
                    }
                }
                tree[i][j].erase(tree[i][j].begin() + idx, tree[i][j].end());
            }
        }

        // 가을
        for (int i = 0; i < N; ++i)
        {
            for (int j = 0; j < N; ++j)
            {
                int num = tree[i][j].size();
                for (int x = 0; x < num; ++x)
                {
                    if (tree[i][j][x] % 5 == 0)
                    {
                        for (int n = 0; n < 8; ++n)
                        {
                            int ii = i + dx[n], jj = j + dy[n];
                            if (ii < 0 || ii >= N || jj < 0 || jj >= N)
                                continue;

                            tree[ii][jj].push_back(1);
                        }
                    }
                }
            }
        }

        // 겨울
        for (int i = 0; i < N; ++i)
        {
            for (int j = 0; j < N; ++j)
            {
                ground[i][j] += A[i][j];
            }
        }
    }

    int ans = 0;
    for (int i = 0; i < N; ++i)
    {
        for (int j = 0; j < N; ++j)
        {
            for (int x : tree[i][j])
            {
                if (x > 0)
                {
                    ans++;
                }
            }
        }
    }
    cout << ans;

    return 0;
}
