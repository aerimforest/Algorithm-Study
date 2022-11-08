// 221108_BOJ_1484

#include <iostream>
#include <vector>

using namespace std;

int G, prv = 1, cur = 1;
vector<int> answer;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> G;
    while (G > cur * cur)
    {
        cur++;
    }

    while (G >= cur * cur - (cur - 1) * (cur - 1))
    {
        if (G == cur * cur - prv * prv)
        {
            answer.push_back(cur);
            cur++;
            prv++;
        }
        else if (G < cur * cur - prv * prv)
        {
            prv++;
        }
        else
        {
            cur++;
        }
    }

    if (answer.size() == 0)
    {
        cout << "-1";
    }
    else
    {
        for (int a : answer)
        {
            cout << a << "\n";
        }
    }

    return 0;
}
