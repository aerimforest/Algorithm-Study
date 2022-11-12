// 221112_BOJ_15686

#include <iostream>
#include <vector>

using namespace std;

int N, M, city[51][51], answer = 0x7fffffff;
vector<pair<int, int>> house, chicken;
bool choice[15];

int getDistance(pair<int, int> x, pair<int, int> y)
{
    return abs(x.first - y.first) + abs(x.second - y.second);
}

void solve(int idx, int cnt)
{
    if (cnt == M)
    {
        int distance = 0;
        for (int i = house.size() - 1; i >= 0; --i)
        {
            int d = 0x7fffffff;
            for (int j = chicken.size() - 1; j >= 0; --j)
            {
                if (!choice[j])
                {
                    continue;
                }

                d = min(d, getDistance(house[i], chicken[j]));
            }
            distance += d;
        }
        answer = min(answer, distance);

        return;
    }
    if (idx >= chicken.size())
    {
        return;
    }

    choice[idx] = true;
    solve(idx + 1, cnt + 1);
    choice[idx] = false;
    solve(idx + 1, cnt);
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> M;
    for (int i = 0; i < N; ++i)
    {
        for (int j = 0; j < N; ++j)
        {
            cin >> city[i][j];

            if (city[i][j] == 1)
            {
                house.push_back({i, j});
            }
            else if (city[i][j] == 2)
            {
                chicken.push_back({i, j});
            }
        }
    }

    solve(0, 0);
    cout << answer;

    return 0;
}
