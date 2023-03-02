#include <iostream>
#include <algorithm>
#include <set>

using namespace std;

int N , K;

int arr[105];
set <int> s;
int dp[10005];

// n is small, brute fore?
// o(n^2) => impossible because order doesn't matter
// use dp..?
int solve(){


  for(auto it = s.begin(); it != s.end(); it++){
    int coin = *it;

    for(int i = coin; i <= K; i++){
      dp[i] += dp[i - coin];
    }
  }


  return dp[K];
}
int main(){

  cin >> N >> K;
  
  for(int i = 0 ; i < N ;i++){
    int num;
    cin >> num;
    s.insert(num);
  }

  dp[0] = 1;
 
  cout << solve();
  
  return 0;
}
