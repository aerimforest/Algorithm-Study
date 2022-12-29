// 221229_BOJ_2002

#include <iostream>
#include <string>
#include <vector>
#include <map>

using namespace std;

int N, answer = 0;
vector<string> E;
map<string, int> S;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    for (int i = 0; i < N; ++i)
    {
        string str;
        cin >> str;
        S[str] = i;
    }
    for (int i = 0; i < N; ++i)
    {
        string str;
        cin >> str;
        E.push_back(str);
    }

    for (int i = 0; i < N; ++i)
    {
        for (int j = i + 1; j < N; ++j)
        {
            if (S[E[i]] > S[E[j]])
            {
                answer++;
                break;
            }
        }
    }
    cout << answer;

    return 0;
}
