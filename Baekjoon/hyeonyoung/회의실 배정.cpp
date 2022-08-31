// 220831_BOJ_1931

#include <iostream>
#include <algorithm>

using namespace std;

int N;
pair<int, int> conf[100001]; // end, start
int ans = 0;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    for (int i = 0; i < N; ++i)
    {
        cin >> conf[i].second >> conf[i].first;
    }

    sort(conf, conf + N);

    int t = -1;
    for (int i = 0; i < N; ++i)
    {
        if (conf[i].second >= t)
        {
            t = conf[i].first;
            ans++;

            // cout << conf[i].second << " " << conf[i].first << "\n";
        }
    }
    cout << ans;

    return 0;
}
