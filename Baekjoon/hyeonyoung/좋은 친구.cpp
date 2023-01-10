// 230110_BOJ_3078

#include <iostream>
#include <string>

using namespace std;

int N, K, len[300001], memo[300001][21];
string name;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> K;
    for (int i = 1; i <= N; ++i)
    {
        cin >> name;
        for (int j = 1; j <= 20; ++j)
        {
            memo[i][j] = memo[i - 1][j];
        }
        len[i] = name.length();
        memo[i][len[i]]++;
    }

    long long answer = 0;
    for (int i = 1; i <= N; ++i)
    {
        answer += memo[min(i + K, N)][len[i]] - memo[i][len[i]];
    }
    cout << answer;

    return 0;
}
