#include <iostream>
#include <vector>

using namespace std;

int solution(vector<vector<int>> land)
{
    int dp[2][4];
    dp[0][0] = land[0][0];
    dp[0][1] = land[0][1];
    dp[0][2] = land[0][2];
    dp[0][3] = land[0][3];

    int R = land.size();
    for (int i = 1; i < R; ++i)
    {
        for (int j = 0; j < 4; ++j)
        {
            int score = 0;
            for (int jj = 0; jj < 4; ++jj)
            {
                if (j == jj)
                {
                    continue;
                }

                score = max(score, dp[(i + 1) & 1][jj]);
            }
            dp[i & 1][j] = score + land[i][j];
        }
    }

    int answer = 0;
    for (int j = 0; j < 4; ++j)
    {
        answer = max(answer, dp[(R + 1) & 1][j]);
    }
    return answer;
}
