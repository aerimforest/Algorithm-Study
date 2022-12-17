// 221215_BOJ_22942

#include <iostream>
#include <stack>
#include <algorithm>

using namespace std;

int N;
bool answer = true;
pair<int, int> circle[200001];
stack<pair<int, int>> st;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    for (int i = 0; i < N; ++i)
    {
        int x, r;
        cin >> x >> r;

        circle[i] = {x - r, x + r};
    }
    sort(circle, circle + N);

    st.push(circle[0]);
    for (int i = 1; i < N && answer; ++i)
    {
        while (!st.empty() && st.top().second < circle[i].first)
        {
            st.pop();
        }
        if (st.empty() || (st.top().first < circle[i].first && st.top().second > circle[i].second))
        {
            st.push(circle[i]);
        }
        else
        {
            answer = false;
        }
    }

    if (answer)
    {
        cout << "YES";
    }
    else
    {
        cout << "NO";
    }

    return 0;
}
