// 221201_BOJ_6987

#include <iostream>
#include <cstring>

using namespace std;

int input[6][3];
pair<int, int> game[15];
int result[6][3];
bool answer;

void solve(int idx)
{
    if (answer)
    {
        return;
    }
    if (idx == 15)
    {
        answer = true;
        for (int i = 0; i < 6; ++i)
        {
            for (int j = 0; j < 3; ++j)
            {
                if (input[i][j] != result[i][j])
                {
                    answer = false;
                }
            }
        }
        return;
    }

    int x = game[idx].first, y = game[idx].second;
    // x 승 y 패
    if (input[x][0] > result[x][0] && input[y][2] > result[y][2])
    {
        result[x][0]++;
        result[y][2]++;
        solve(idx + 1);
        result[x][0]--;
        result[y][2]--;
    }
    // 무승부
    if (input[x][1] > result[x][1] && input[y][1] > result[y][1])
    {
        result[x][1]++;
        result[y][1]++;
        solve(idx + 1);
        result[x][1]--;
        result[y][1]--;
    }
    // x 패 y 승
    if (input[x][2] > result[x][2] && input[y][0] > result[y][0])
    {
        result[x][2]++;
        result[y][0]++;
        solve(idx + 1);
        result[x][2]--;
        result[y][0]--;
    }
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    int idx = 0;
    for (int i = 0; i < 6; ++i)
    {
        for (int j = i + 1; j < 6; ++j)
        {
            game[idx++] = {i, j};
        }
    }

    for (int k = 0; k < 4; ++k)
    {
        for (int i = 0; i < 6; ++i)
        {
            for (int j = 0; j < 3; ++j)
            {
                cin >> input[i][j];
            }
        }

        answer = false;
        memset(result, 0, sizeof(result));
        solve(0);
        cout << answer << " ";
    }

    return 0;
}
