// [16637] 괄호 추가하기
#include <iostream>       
#include <string>
#include <algorithm>
#include <climits>
using namespace std;

int N, result = INT_MIN;
string s;

int calculate(int a, int b, char op)
{
    switch (op) {
        case '+':
            return a + b;
        case '-':
            return a - b;
        case '*':
            return a * b;
    }
}

void dfs(int idx, int value)
{
    if (idx >= N) {
        result = max(result, value);
        return;
    }
    char op = idx >= 1 ? s[idx - 1] : '+';
    int temp = calculate(value, s[idx] - '0', op);

    dfs(idx + 2, temp);

    if (idx < N - 2) {
        temp = calculate(s[idx] - '0', s[idx + 2] - '0', s[idx + 1]);
        temp = calculate(value, temp, op);
        dfs(idx + 4, temp);
    }
}

int main(void)
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> s;

    dfs(0, 0);

    cout << result << "\n";

    return 0;
}