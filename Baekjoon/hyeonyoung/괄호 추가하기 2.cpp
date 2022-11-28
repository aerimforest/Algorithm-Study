// 221023_BOJ_16638

#include <iostream>
#include <string>
#include <vector>
#include <deque>

using namespace std;

int N;
string input;
pair<char, int> num[11];
bool br[11];
int ans = -(((long long)1 << 31) - 1);

int func(int a, int b, char c)
{
    if (c == '+')
    {
        return a + b;
    }
    else if (c == '-')
    {
        return a - b;
    }
    else
    {
        return a * b;
    }
}
int cal()
{
    // for (int i = 0; i <= N / 2; ++i)
    // {
    //     cout << num[i].first << " " << num[i].second;
    //     if (br[i])
    //     {
    //         cout << ")";
    //     }
    //     cout << " ";
    // }
    // cout << "\t";

    // 괄호
    int i = 0;
    vector<pair<char, int>> par;
    while (i <= N / 2)
    {
        if (br[i + 1])
        {
            par.push_back({num[i].first, func(num[i].second, num[i + 1].second, num[i + 1].first)});
            i += 2;
        }
        else
        {
            par.push_back(num[i]);
            i++;
        }
    }

    // 곱셈
    deque<pair<char, int>> mul;
    for (pair<char, int> p : par)
    {
        if (p.first == '*')
        {
            pair<char, int> t = mul.back();
            mul.pop_back();

            mul.push_back({t.first, t.second * p.second});
        }
        else
        {
            mul.push_back(p);
        }
    }

    // 계산
    while (mul.size() > 1)
    {
        pair<char, int> A = mul.front();
        mul.pop_front();
        pair<char, int> B = mul.front();
        mul.pop_front();

        mul.push_front({A.first, func(A.second, B.second, B.first)});
    }

    // cout << mul.front().second << "\n";

    return mul.front().second;
}
void solve(int idx)
{
    if (idx > N / 2)
    {
        ans = max(ans, cal());
        return;
    }

    br[idx] = true;
    solve(idx + 2);
    br[idx] = false;
    solve(idx + 1);
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> input;

    num[0] = {' ', input[0] - '0'};
    for (int i = 2; i < N; i += 2)
    {
        num[i / 2] = {input[i - 1], input[i] - '0'};
    }

    solve(1);

    cout << ans;

    return 0;
}
