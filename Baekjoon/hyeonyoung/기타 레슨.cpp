// 220831_BOJ_2343

#include <iostream>

using namespace std;

int N, M, lecture[100001];

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> M;
    int all = 0;
    for (int i = 0; i < N; ++i)
    {
        cin >> lecture[i];
        all += lecture[i];
    }

    int left = all / M - 1, right = all + 1;
    int ans = right;
    while (left < right)
    {
        int mid = (left + right) / 2;
        int cnt = 0, sum = 0;
        for (int x = 0; x < N; ++x)
        {
            if (sum + lecture[x] <= mid)
            {
                sum += lecture[x];
            }
            else if (lecture[x] > mid)
            {
                cnt = M + 1;
                break;
            }
            else
            {
                cnt++;
                sum = lecture[x];
            }
        }
        if (cnt < M)
        {
            right = mid;
        }
        else
        {
            left = mid + 1;
        }
    }

    cout << left;

    return 0;
}
