#include <iostream>
#include <string>
#include <vector>
#include <set>

using namespace std;

vector<int> solution(int n, vector<string> words)
{
    vector<int> answer = {0, 0};
    set<string> S;

    char c = words[0][0];
    int len = words.size();
    for (int i = 0; i < len; ++i)
    {
        if (c != words[i][0] || words[i].length() == 1)
        {
            answer = {i % n + 1, i / n + 1};
            break;
        }

        if (S.find(words[i]) == S.end())
        {
            S.insert(words[i]);
        }
        else
        {
            answer = {i % n + 1, i / n + 1};
            break;
        }

        c = words[i][words[i].length() - 1];
    }

    return answer;
}
