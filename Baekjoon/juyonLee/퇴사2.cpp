#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
#define MAX 1500002


int main()
{
    int N;
    vector<pair<int, int > > v;
    int dp[MAX] = {0};
    
    cin >> N;

    for(int i = 0; i < N; i++)
    {
        int n1, n2;
        cin >> n1 >> n2;
        v.push_back(make_pair(n1, n2));
    }

    for(int i = N-1; i >= 0; i--)
    {
        if(i + v[i].first > N)
        {
            dp[i] = dp[i + 1];
        }

        else
        {
            dp[i] = max(dp[i + 1], v[i].second + dp[i + v[i].first]);
        }

    }

    cout << dp[0] << '\n';

    return 0;
}



/* 하단에서부터 더하는코드. 오류 찾아야함
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(0);

    int N, ans = 0, tmp = 0; 
    int dp[MAX];
    vector<pair<int, int > > v;

	cin >> N;

	for (int i = 0; i < N; i++)
    {
		int n1, n2;
        cin >> n1 >> n2;

        v.push_back(make_pair(n1, n2));
	}

	for (int i = 0; i <= N; i++)
    {
		tmp = max(tmp, dp[i]);
		
        if (i + v[i].first > N) 
            continue;
		
        dp[i + v[i].first] = max(dp[i + v[i].first], tmp + v[i].second);
		ans = max(ans, dp[i + v[i].first]);
	}

	cout << ans <<'\n';
	return 0;
}
*/