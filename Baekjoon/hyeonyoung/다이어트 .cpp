// 221229_BOJ_19942

#include <iostream>
#include <vector>

using namespace std;

int N, M[4], nut[16][5], min_cost = 0x7fffffff;
vector<int> memo, answer;

bool chk()
{
    vector<int> sum(5, 0);
    for (int m : memo)
    {
        for (int i = 0; i < 5; ++i)
        {
            sum[i] += nut[m][i];
        }
    }

    bool ret = true;
    for (int i = 0; i < 4; ++i)
    {
        if (sum[i] < M[i])
        {
            ret = false;
            break;
        }
    }
    return ret;
}

void solve(int idx, int cost)
{
    if (cost >= min_cost)
    {
        return;
    }

    if (cost < min_cost && chk())
    {
        min_cost = cost;
        answer = {};
        for (int m : memo)
        {
            answer.push_back(m);
        }
    }
    if (idx > N)
    {
        return;
    }

    memo.push_back(idx);
    solve(idx + 1, cost + nut[idx][4]);
    memo.pop_back();
    solve(idx + 1, cost);
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    for (int i = 0; i < 4; ++i)
    {
        cin >> M[i];
    }
    for (int i = 1; i <= N; ++i)
    {
        for (int j = 0; j < 5; ++j)
        {
            cin >> nut[i][j];
        }
    }

    solve(1, 0);

    if (min_cost == 0x7fffffff)
    {
        cout << "-1\n";
    }
    else
    {
        cout << min_cost << "\n";
        for (int a : answer)
        {
            cout << a << " ";
        }
    }

    return 0;
}
