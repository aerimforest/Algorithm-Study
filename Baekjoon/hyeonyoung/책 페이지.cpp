// 221019_BOJ_1019

#include <iostream>

using namespace std;

long long N, answer[10];

void cnt(long long X, long long ten)
{
    while (X > 0)
    {
        answer[X % 10] += ten;
        X /= 10;
    }
}
void solve(long long A, long long B, long long ten)
{
    while (A % 10 && A <= B)
    {
        cnt(A, ten);
        A++;
    }
    while (B % 10 != 9 && A <= B)
    {
        cnt(B, ten);
        B--;
    }
    if (A > B)
    {
        return;
    }

    A /= 10;
    B /= 10;
    for (int i = 0; i < 10; ++i)
    {
        answer[i] += (B - A + 1) * ten;
    }

    solve(A, B, ten * 10);
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;

    solve(1, N, 1);

    for (int i = 0; i < 10; ++i)
    {
        cout << answer[i] << " ";
    }

    return 0;
}
