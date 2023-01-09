// 230109_BOJ_1946

#include <iostream>
#include <algorithm>

using namespace std;

int T, N;
pair<int, int> score[100001];

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> T;
    while (T-- > 0)
    {
        cin >> N;
        for (int i = 0; i < N; ++i)
        {
            cin >> score[i].first >> score[i].second;
        }
        sort(score, score + N);

        int answer = 1, memo = score[0].second;
        for (int i = 1; i < N; ++i)
        {
            if (score[i].second < memo)
            {
                answer++;
                memo = score[i].second;
            }
        }
        cout << answer << "\n";
    }

    return 0;
}
