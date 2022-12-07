// 221207_BOJ_13022

#include <iostream>
#include <string>

using namespace std;

string wolf;
bool answer = true;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> wolf;
    int memo = 0, cnt = 1, len = wolf.length();
    if (wolf[0] != 'w' || wolf[len - 1] != 'f')
    {
        answer = false;
    }
    for (int i = 1; i < len && answer; ++i)
    {
        if (wolf[i] == 'w')
        {
            if (wolf[i - 1] == 'f')
            {
                if (memo != cnt)
                {
                    answer = false;
                }
                else
                {
                    cnt = 1;
                }
            }
            else if (wolf[i - 1] == 'w')
            {
                cnt++;
            }
            else
            {
                answer = false;
            }
        }
        else if (wolf[i] == 'o')
        {
            if (wolf[i - 1] == 'w')
            {
                memo = cnt;
                cnt = 1;
            }
            else if (wolf[i - 1] == 'o')
            {
                cnt++;
            }
            else
            {
                answer = false;
            }
        }
        else if (wolf[i] == 'l')
        {
            if (wolf[i - 1] == 'o')
            {
                if (memo != cnt)
                {
                    answer = false;
                }
                else
                {
                    cnt = 1;
                }
            }
            else if (wolf[i - 1] == 'l')
            {
                cnt++;
            }
            else
            {
                answer = false;
            }
        }
        else if (wolf[i] == 'f')
        {
            if (wolf[i - 1] == 'l')
            {
                if (memo != cnt)
                {
                    answer = false;
                }
                else
                {
                    cnt = 1;
                }
            }
            else if (wolf[i - 1] == 'f')
            {
                cnt++;
            }
            else
            {
                answer = false;
            }
        }
    }
    if (memo != cnt)
    {
        answer = false;
    }
    cout << answer;

    return 0;
}
