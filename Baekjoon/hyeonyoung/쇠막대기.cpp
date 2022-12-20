// 221220_BOJ_10799

#include <iostream>
#include <string>
#include <stack>

using namespace std;

string input;
int answer = 0;
stack<int> st;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> input;
    int len = input.length();
    for (int i = 0; i < len; ++i)
    {
        if (input[i] == '(' && input[i + 1] == ')')
        {
            answer += st.size();
            i++;
        }
        else if (input[i] == '(')
        {
            st.push(i);
        }
        else if (input[i] == ')')
        {
            answer++;
            st.pop();
        }
    }
    cout << answer;

    return 0;
}
