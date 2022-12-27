// 221227_BOJ_16953

#include <iostream>

using namespace std;

int A, B, answer = -1;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> A >> B;

    int cnt = 1;
    while (B > A)
    {
        cnt++;
        if (B % 10 == 1)
        {
            B /= 10;
        }
        else if (B % 2 == 0)
        {
            B /= 2;
        }
        else
        {
            break;
        }
    }
    if (B == A)
    {
        answer = cnt;
    }
    cout << answer;

    return 0;
}
