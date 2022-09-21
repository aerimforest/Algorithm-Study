// 220921_BOJ_1541

#include <iostream>
#include <string>
#include <stack>

using namespace std;

string S;
int idx = 0;
pair<char, int> op[50];
stack<int> st;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> S;
    int n = 0;
    for (char c : S)
    {
        if (c >= '0' && c <= '9')
        {
            n = n * 10 + c - '0';
        }
        else
        {
            op[idx++].second = n;
            op[idx].first = c;
            n = 0;
        }
    }
    op[idx++].second = n;

    // for (int i = 0; i < idx; ++i)
    // {
    //     cout << op[i].first << " " << op[i].second << " ";
    // }

    st.push(op[0].second);
    for (int i = 1; i < idx; ++i)
    {
        int c = op[i].first, n = op[i].second;
        if (c == '+')
        {
            int top = st.top();
            st.pop();

            st.push(top + n);
        }
        else
        {
            st.push(n);
        }
    }

    int ans = 0;
    while (st.size() > 1)
    {
        int top = st.top();
        st.pop();

        ans -= top;
    }
    ans += st.top();

    cout << ans;

    return 0;
}
