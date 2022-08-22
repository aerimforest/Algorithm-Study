// [9251] LCS
// dp
#include <iostream>
using namespace std;

int dp[1001][1001];

int lcs(string s1, string s2)
{
    for(int i = 1; i < s1.size(); i++) {
        for(int j = 1; j < s2.size(); j++) {
            if(s1[i] == s2[j]) dp[i][j] = dp[i-1][j-1] + 1;
            else dp[i][j] = max(dp[i-1][j], dp[i][j-1]);
        }
    }
    return dp[s1.size()-1][s2.size()-1];
}

int main(void)
{
    string s1, s2;
    cin >> s1 >> s2;

    s1.insert(0, "0"); s2.insert(0, "0");

    cout << lcs(s1, s2) << '\n';
    return 0;
}