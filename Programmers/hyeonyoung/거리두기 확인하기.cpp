#include <string>
#include <vector>

using namespace std;

int dx[3][4] = {{-1, 1, 0, 0},
                {-2, 2, 0, 0},
                {-1, -1, 1, 1}};
int dy[3][4] = {{0, 0, -1, 1},
                {0, 0, -2, 2},
                {-1, 1, -1, 1}};

bool solve(vector<string> room)
{
    for (int x = 0; x < 5; ++x)
    {
        for (int y = 0; y < 5; ++y)
        {
            if (room[x][y] != 'P')
            {
                continue;
            }

            for (int i = 0; i < 3; ++i)
            {
                for (int j = 0; j < 4; ++j)
                {
                    int xx = x + dx[i][j], yy = y + dy[i][j];
                    if (xx < 0 || xx >= 5 || yy < 0 | yy >= 5 || room[xx][yy] != 'P')
                    {
                        continue;
                    }

                    if (i == 0)
                    {
                        return 0;
                    }
                    else if (i == 1)
                    {
                        if (room[x + dx[0][j]][y + dy[0][j]] != 'X')
                        {
                            return 0;
                        }
                    }
                    else
                    {
                        if (room[x][y + dy[2][j]] != 'X' || room[x + dx[2][j]][y] != 'X')
                        {
                            return 0;
                        }
                    }
                }
            }
        }
    }
    return 1;
}

vector<int> solution(vector<vector<string>> places)
{
    vector<int> answer;
    for (vector<string> room : places)
    {
        answer.push_back(solve(room));
    }
    return answer;
}
