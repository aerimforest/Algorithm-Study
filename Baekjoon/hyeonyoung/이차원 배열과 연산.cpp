// 221108_BOJ_17140

#include <iostream>
#include <algorithm>
#include <vector>
#include <cstring>

using namespace std;

int r, c, k, A[101][101], tmp[101][101], answer = -1;
int R = 3, C = 3, cnt[101];

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> r >> c >> k;
    for (int i = 0; i < 3; ++i)
    {
        for (int j = 0; j < 3; ++j)
        {
            cin >> A[i][j];
        }
    }
    for (int t = 0; t <= 100; ++t)
    {
        if (A[r - 1][c - 1] == k)
        {
            answer = t;
            break;
        }

        memset(tmp, 0, sizeof(tmp));
        if (R >= C)
        {
            int newC = 0;
            for (int i = 0; i < R; ++i)
            {
                memset(cnt, 0, sizeof(cnt));
                vector<pair<int, int>> srt;
                for (int j = 0; j < C; ++j)
                {
                    cnt[A[i][j]]++;
                }

                for (int j = 1; j <= 100; ++j)
                {
                    if (cnt[j] > 0)
                    {
                        srt.push_back({cnt[j], j});
                    }
                }
                sort(srt.begin(), srt.end());

                int len = srt.size();
                newC = max(newC, len * 2);
                for (int j = 0; j < len && j * 2 < 100; ++j)
                {
                    tmp[i][j * 2] = srt[j].second;
                    tmp[i][j * 2 + 1] = srt[j].first;
                }
            }
            C = min(newC, 100);
        }
        else
        {
            int newR = 0;
            for (int j = 0; j < C; ++j)
            {
                memset(cnt, 0, sizeof(cnt));
                vector<pair<int, int>> srt;
                for (int i = 0; i < R; ++i)
                {
                    cnt[A[i][j]]++;
                }
                for (int i = 1; i <= 100; ++i)
                {
                    if (cnt[i] > 0)
                    {
                        srt.push_back({cnt[i], i});
                    }
                }
                sort(srt.begin(), srt.end());

                int len = srt.size();
                newR = max(newR, len * 2);
                for (int i = 0; i < len && i * 2 < 100; ++i)
                {
                    tmp[i * 2][j] = srt[i].second;
                    tmp[i * 2 + 1][j] = srt[i].first;
                }
            }
            R = min(newR, 100);
        }

        for (int i = 0; i < R; ++i)
        {
            for (int j = 0; j < C; ++j)
            {
                A[i][j] = tmp[i][j];
            }
        }
    }

    cout << answer;

    return 0;
}
