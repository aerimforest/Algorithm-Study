// 221119_BOJ_2186

#include <iostream>
#include <string>

using namespace std;

int N, M, K;
char board[101][101];
string word;
int dp[101][101][81];

int dx[] = {-1, 1, 0, 0};
int dy[] = {0, 0, -1, 1};

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> M >> K;
    for (int i = 0; i < N; ++i)
    {
        cin >> board[i];
    }
    cin >> word;
    int len = word.length();

    for (int i = 0; i < N; ++i)
    {
        for (int j = 0; j < M; ++j)
        {
            dp[i][j][0] = (board[i][j] == word[0]);
        }
    }

    for (int l = 1; l < len; ++l)
    {
        for (int i = 0; i < N; ++i)
        {
            for (int j = 0; j < M; ++j)
            {
                if (board[i][j] != word[l])
                {
                    continue;
                }

                for (int k = 1; k <= K; ++k)
                {
                    for (int d = 0; d < 4; ++d)
                    {
                        int x = i + dx[d] * k, y = j + dy[d] * k;
                        if (x < 0 || x >= N || y < 0 || y >= M)
                        {
                            continue;
                        }

                        dp[i][j][l] += dp[x][y][l - 1];
                    }
                }
            }
        }
    }

    int answer = 0;
    for (int i = 0; i < N; ++i)
    {
        for (int j = 0; j < M; ++j)
        {
            answer += dp[i][j][len - 1];
        }
    }
    cout << answer;

    return 0;
}
