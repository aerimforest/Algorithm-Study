// 221212_BOJ_1339

#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int N;
string words[11];
int alphabet[30];

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    for (int i = 0; i < N; ++i)
    {
        cin >> words[i];
        int ten = 1;
        for (int j = words[i].length() - 1; j >= 0; --j)
        {
            alphabet[words[i][j] - 'A'] += ten;
            ten *= 10;
        }
    }

    vector<int> v;
    for (int i = 0; i < 26; ++i)
    {
        if (alphabet[i] > 0)
        {
            v.push_back(alphabet[i]);
        }
    }
    sort(v.begin(), v.end());

    int answer = 0, num = 9;
    for (int i = v.size() - 1; i >= 0; --i)
    {
        answer += v[i] * num--;
    }
    cout << answer;

    return 0;
}
