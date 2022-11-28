// [2531] 회전 초밥
#include <iostream>
#include <vector>
#include <cstring>
#include <algorithm>
using namespace std;

bool eat[3001];
int N, d, k, c;
int duplication, remainCoupon, ans, sushi[300001];

void input()
{
    cin >> N >> d >> k >> c;
	for (int i = 0; i < N; i++) {
        cin >> sushi[i];
    }
}

void init()
{
    duplication = 0; 
    remainCoupon = 1;
    memset(eat, false, sizeof(eat)); 
}

void solve()
{
    for (int i = 0; i < N; i++) {
        init();
		for (int j = i; j < i + k; j++) {				
			if (eat[sushi[j % N]] == true) duplication++;
			else eat[sushi[j % N]] = true; 	

			if (sushi[j % N] == c) remainCoupon = 0;
		}
		ans = max(ans, k - duplication + remainCoupon); 
	}
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    input();
    solve();

	cout << ans << '\n';
    return 0;
}