// 221214_BOJ_5430

#include <iostream>
#include <string>
#include <deque>

using namespace std;

int T, N;
string cmd, arr;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> T;
    while (T-- > 0)
    {
        deque<int> dq;
        bool error = false, point = true; // true: -> false: <-

        cin >> cmd >> N >> arr;
        int len = arr.length(), n = 0;
        for (int i = 1; i < len - 1; ++i)
        {
            if (arr[i] == ',')
            {
                dq.push_back(n);
                n = 0;
            }
            else
            {
                n = n * 10 + arr[i] - '0';
            }
        }
        if (n > 0)
        {
            dq.push_back(n);
        }

        for (char c : cmd)
        {
            if (c == 'R')
            {
                point = !point;
            }
            else if (c == 'D')
            {
                if (dq.empty())
                {
                    error = true;
                    break;
                }
                else if (point)
                {
                    dq.pop_front();
                }
                else
                {
                    dq.pop_back();
                }
            }
        }

        if (error)
        {
            cout << "error\n";
        }
        else if (point)
        {
            cout << "[";
            if (!dq.empty())
            {
                cout << dq.front();
                dq.pop_front();
            }
            while (!dq.empty())
            {
                cout << "," << dq.front();
                dq.pop_front();
            }
            cout << "]\n";
        }
        else
        {
            cout << "[";
            if (!dq.empty())
            {
                cout << dq.back();
                dq.pop_back();
            }
            while (!dq.empty())
            {
                cout << "," << dq.back();
                dq.pop_back();
            }
            cout << "]\n";
        }
    }

    return 0;
}
