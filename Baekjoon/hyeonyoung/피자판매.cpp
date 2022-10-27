// 221027_BOJ_2632

#include <iostream>

using namespace std;

int N, a, b, A[1001], B[1001];
int pizza[2000001][2];

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    cin >> a >> b;
    int sumA = 0, sumB = 0;
    for (int i = 0; i < a; ++i)
    {
        cin >> A[i];
        sumA += A[i];
    }
    for (int j = 0; j < b; ++j)
    {
        cin >> B[j];
        sumB += B[j];
    }

    pizza[0][0] = pizza[0][1] = 1;
    pizza[sumA][0]++;
    pizza[sumB][1]++;

    for (int i = 0; i < a; ++i)
    {
        int sum = 0;
        for (int j = 0; j < a - 1; ++j)
        {
            sum += A[(i + j) % a];
            pizza[sum][0]++;
        }
    }
    for (int i = 0; i < b; ++i)
    {
        int sum = 0;
        for (int j = 0; j < b - 1; ++j)
        {
            sum += B[(i + j) % b];
            pizza[sum][1]++;
        }
    }

    long long ans = 0;
    for (int i = 0; i <= N; ++i)
    {
        ans += pizza[i][0] * pizza[N - i][1];
    }
    cout << ans;

    return 0;
}
