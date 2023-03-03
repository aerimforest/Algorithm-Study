// 230117_BOJ_15898

#include <iostream>

using namespace std;

int N, answer = 0;
struct state
{
    int quality;
    char color;
};
state gama[5][5], source[11][4][4];
bool visit[11];

int init[4][2] = {{0, 0}, {0, 3}, {3, 3}, {3, 0}};
int delta[4][2] = {{1, 1}, {1, -1}, {-1, -1}, {-1, 1}};

void putSource(int idx, int x, int y, int d)
{
    state tmp[4][4];
    int cnt = 0;
    for (int i = init[d][0]; i >= 0 && i < 4; i += delta[d][0])
    {
        for (int j = init[d][1]; j >= 0 && j < 4; j += delta[d][1])
        {
            tmp[cnt / 4][cnt % 4] = ((d & 1) ? source[idx][j][i] : source[idx][i][j]);
            cnt++;
        }
    }

    for (int i = 0; i < 4; i++)
    {
        for (int j = 0; j < 4; j++)
        {
            gama[x + i][y + j].quality += tmp[i][j].quality;
            if (gama[x + i][y + j].quality < 0)
            {
                gama[x + i][y + j].quality = 0;
            }
            else if (gama[x + i][y + j].quality > 9)
            {
                gama[x + i][y + j].quality = 9;
            }
            if (tmp[i][j].color != 'W')
            {
                gama[x + i][y + j].color = tmp[i][j].color;
            }
        }
    }
}
void solve(int cnt)
{
    if (cnt == 3)
    {
        int sum = 0;
        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 5; j++)
            {
                switch (gama[i][j].color)
                {
                case 'R':
                    sum += 7 * gama[i][j].quality;
                    break;
                case 'B':
                    sum += 5 * gama[i][j].quality;
                    break;
                case 'G':
                    sum += 3 * gama[i][j].quality;
                    break;
                case 'Y':
                    sum += 2 * gama[i][j].quality;
                    break;
                default:
                    break;
                }
            }
        }
        answer = max(answer, sum);
        return;
    }

    state tmp[5][5];
    for (int i = 0; i < 5; i++)
    {
        for (int j = 0; j < 5; j++)
        {
            tmp[i][j] = {gama[i][j].quality, gama[i][j].color};
        }
    }

    for (int i = 0; i < N; i++)
    {
        if (visit[i])
        {
            continue;
        }

        visit[i] = true;
        for (int x = 0; x < 2; x++)
        {
            for (int y = 0; y < 2; y++)
            {
                for (int k = 0; k < 4; k++)
                {
                    putSource(i, x, y, k);
                    solve(cnt + 1);
                    for (int a = 0; a < 5; a++)
                    {
                        for (int b = 0; b < 5; b++)
                        {
                            gama[a][b] = tmp[a][b];
                        }
                    }
                }
            }
        }
        visit[i] = false;
    }
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    // init
    for (int i = 0; i < 5; i++)
    {
        for (int j = 0; j < 5; j++)
        {
            gama[i][j] = {0, 'W'};
        }
    }

    // input
    cin >> N;
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < 4; j++)
        {
            for (int k = 0; k < 4; k++)
            {
                cin >> source[i][j][k].quality;
            }
        }
        for (int j = 0; j < 4; j++)
        {
            for (int k = 0; k < 4; k++)
            {
                cin >> source[i][j][k].color;
            }
        }
    }

    solve(0);
    cout << answer;

    return 0;
}
