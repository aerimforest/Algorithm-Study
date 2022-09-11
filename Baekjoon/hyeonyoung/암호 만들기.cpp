// 220909_BOJ_1759

#include <iostream>
#include <algorithm>

using namespace std;

int L, C;
char alphabet[16], code[16];

void solve(int idx, int cnt, int a, int b)
{
    if (cnt == L)
    {
        if (a >= 1 && b >= 2)
        {
            cout << code << "\n";
        }
        return;
    }
    if (idx >= C)
    {
        return;
    }

    code[cnt] = alphabet[idx];
    if (alphabet[idx] == 'a' || alphabet[idx] == 'e' || alphabet[idx] == 'i' || alphabet[idx] == 'o' || alphabet[idx] == 'u')
        solve(idx + 1, cnt + 1, a + 1, b);
    else
        solve(idx + 1, cnt + 1, a, b + 1);
    solve(idx + 1, cnt, a, b);
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> L >> C;
    for (int c = 0; c < C; ++c)
    {
        cin >> alphabet[c];
    }
    sort(alphabet, alphabet + C);

    solve(0, 0, 0, 0);

    return 0;
}
