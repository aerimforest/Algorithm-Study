// 220910_BOJ_16926

#include <iostream>
#include <vector>

using namespace std;

int N, M, R, A[301][301];

void rotate(int k, int r)
{
    vector<int> memo;

    int x = k, y = k;
    for (; y < M - k - 1; ++y)
    {
        memo.push_back(A[x][y]);
    }
    for (; x < N - k - 1; ++x)
    {
        memo.push_back(A[x][y]);
    }
    for (; y > k; --y)
    {
        memo.push_back(A[x][y]);
    }
    for (; x > k; --x)
    {
        memo.push_back(A[x][y]);
    }

    int s = memo.size(), idx = r % s;
    for (; y < M - k - 1; ++y)
    {
        A[x][y] = memo[idx];
        idx = (idx + 1) % s;
    }
    for (; x < N - k - 1; ++x)
    {
        A[x][y] = memo[idx];
        idx = (idx + 1) % s;
    }
    for (; y > k; --y)
    {
        A[x][y] = memo[idx];
        idx = (idx + 1) % s;
    }
    for (; x > k; --x)
    {
        A[x][y] = memo[idx];
        idx = (idx + 1) % s;
    }
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> M >> R;
    for (int i = 0; i < N; ++i)
    {
        for (int j = 0; j < M; ++j)
        {
            cin >> A[i][j];
        }
    }

    for (int k = min(N, M) / 2 - 1; k >= 0; --k)
    {
        rotate(k, R);
    }

    for (int i = 0; i < N; ++i)
    {
        for (int j = 0; j < M; ++j)
        {
            cout << A[i][j] << " ";
        }
        cout << "\n";
    }

    return 0;
}
