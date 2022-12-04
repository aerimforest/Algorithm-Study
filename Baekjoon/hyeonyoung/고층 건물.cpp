// 221204_BOJ_1027

#include <iostream>

using namespace std;

int N, answer = 0;
long long building[51];

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    for (int i = 0; i < N; ++i)
    {
        cin >> building[i];
    }

    for (int i = 0; i < N; ++i)
    {
        int cnt = 0;
        long long a, b;
        if (i - 1 >= 0)
        {
            a = 1;
            b = building[i] - building[i - 1];
            cnt++;

            for (int j = i - 1; j >= 0; --j)
            {
                long long aa = i - j, bb = building[i] - building[j];
                if (a * bb < aa * b)
                {
                    cnt++;
                    a = aa;
                    b = bb;
                }
            }
        }
        if (i + 1 < N)
        {
            a = 1;
            b = building[i + 1] - building[i];
            cnt++;

            for (int j = i + 1; j < N; ++j)
            {
                long long aa = j - i, bb = building[j] - building[i];
                if (a * bb > aa * b)
                {
                    cnt++;
                    a = aa;
                    b = bb;
                }
            }
        }

        answer = max(answer, cnt);
    }
    cout << answer;

    return 0;
}
