// [9252] LCS 2
#include <iostream>
#include <cstring>
#include <algorithm>
using namespace std;

int dp[1001][1001];

int LCSLength(string s1, string s2)
{
    for(int i = 1; i < s1.size(); i++) {
        for(int j = 1; j < s2.size(); j++) {
            if(s1[i] == s2[j]) dp[i][j] = dp[i - 1][j - 1] + 1;
            else dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
        } 
    }
    return dp[s1.size() - 1][s2.size() - 1];
}

string LCS(string s1, string s2)
{
    string ans = "";
    int i = s1.size() - 1, j = s2.size() - 1;
    while(i > 0 && j > 0) {
        if(s1[i] == s2[j]) {
            ans.push_back(s1[i]);
            i -= 1; j -= 1;
        }
        else {
            if(dp[i - 1][j] > dp[i][j - 1]) i -= 1;
            else j -= 1;
        }
    }
    reverse(ans.begin(), ans.end());
    return ans;
}

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    string s1, s2;
    cin >> s1 >> s2;

    s1.insert(0, "0"); s2.insert(0, "0");
    cout << LCSLength(s1, s2) << '\n';
    cout << LCS(s1, s2) << '\n';

    return 0;
}