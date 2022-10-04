// [1662] 압축
// 2022 LG U+ 경력직 코테 2번 유사 문제
#include <iostream>
#include <stack>
using namespace std;

string s;
struct Info {
    char ch;
    int len;
};

void solve()
{
    stack<Info> st; // <숫자(1~9), 반복 횟수>

    for(char c: s) {
        if(c == ')') {
            int len = 0;
            while(st.top().ch != '(') {
                len += st.top().len;
                st.pop();
            }
            st.pop(); // '(' 삭제
            
            int repeatNum = st.top().ch - '0'; // 반복 횟수
            st.top().len = len * repeatNum; // 내가 반복시킨 문자열의 길이
        }
        else st.push({c, 1});
    }

    int ans = 0;
    while(!st.empty()) {
        ans += st.top().len;
        st.pop();
    }
    cout << ans << '\n';
}

void input()
{
    cin >> s;
}

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    input();
    solve();

    return 0;
}