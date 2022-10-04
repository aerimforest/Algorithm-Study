// 221004_BOJ_1662

#include <iostream>
#include <string>
#include <stack>

using namespace std;

string S;
stack<int> st;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> S;
    int len = S.length();
    for (int i = 0; i < len; ++i)
    {
        if (S[i] == '(')
        {
            st.push(-1);
        }
        else if (S[i] == ')')
        {
            int cnt = 0;
            while (!st.empty() && st.top() != -1)
            {
                cnt += st.top();
                st.pop();
            }
            if (!st.empty())
            {
                st.pop();
            }

            cnt *= st.top();
            st.pop();
            st.push(cnt);
        }
        else if (i + 1 < len && S[i + 1] == '(')
        {
            st.push(S[i] - '0');
        }
        else
        {
            st.push(1);
        }
    }
    int ans = 0;
    while (!st.empty())
    {
        ans += st.top();
        st.pop();
    }
    cout << ans;

    return 0;
}
