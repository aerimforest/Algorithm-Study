// 221007_BOJ_2473

#include <iostream>
#include <algorithm>

using namespace std;

int N, S[5001];
long long ans = 3000000000;
int memo[3] = {0, 0, 0};

void twoPointer(int n)
{
    int l = n + 1, r = N - 1;
    long long s = S[n];

    while (l < r)
    {
        long long sum = s + S[l] + S[r];
        if (abs(ans) > abs(sum))
        {
            ans = abs(sum);
            memo[0] = s;
            memo[1] = S[l];
            memo[2] = S[r];
        }

        if (sum < 0)
        {
            l++;
        }
        else if (sum > 0)
        {
            r--;
        }
        else
        {
            break;
        }
    }
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    for (int i = 0; i < N; ++i)
    {
        cin >> S[i];
    }
    sort(S, S + N);

    for (int i = 0; i < N; ++i)
    {
        twoPointer(i);
    }

    cout << memo[0] << " " << memo[1] << " " << memo[2] << "\n";

    return 0;
}
