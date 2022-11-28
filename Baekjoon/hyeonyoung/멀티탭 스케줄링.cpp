// 221103_BOJ_1700

#include <iostream>
#include <vector>

using namespace std;

int N, K, seq[101];
bool holes[101];
vector<int> electronics[101];

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> K;
    for (int i = 1; i <= K; ++i)
    {
        cin >> seq[i];
        electronics[seq[i]].push_back(i);
    }

    int cnt = 0, ans = 0;
    for (int i = 1; i <= K; ++i)
    {
        // 이미 꽂혀 있을 때
        if (holes[seq[i]])
        {
            continue;
        }
        // 빈 자리 있을 때
        else if (cnt < N)
        {
            holes[seq[i]] = true;
            cnt++;
        }
        // 빼고 꽂기
        else
        {
            ans++;
            // 뺄 전기용품 고르기
            int remove = 0, last = 0;
            for (int h = 1; h <= K; ++h)
            {
                if (holes[h])
                {
                    int idx = lower_bound(electronics[h].begin(), electronics[h].end(), i) - electronics[h].begin();
                    if (idx == electronics[h].size())
                    {
                        remove = h;
                        last = K + 1;
                    }
                    else if (last < electronics[h][idx])
                    {
                        remove = h;
                        last = electronics[h][idx];
                    }
                }
            }
            holes[seq[i]] = true;
            holes[remove] = false;
        }
    }

    cout << ans;

    return 0;
}
