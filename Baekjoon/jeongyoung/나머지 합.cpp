#include <iostream>
#include <vector>
#include <cstring>

#define ll long long

using namespace std;

int N, M;
vector<ll> presum;
vector<ll> arr;
ll dp[1004];

int main(){
  cin >> N >> M;
  presum.push_back(0);
  for(int i = 1; i <= N ;i++){
    int a;
    cin >> a;
    arr.push_back(a);
    presum.push_back(presum[i-1] + a);
  }


  for(int i = 1; i <= N ; i++){
    ll rem = presum[i] % M;
    dp[rem]++;
  }

  ll ans = (dp[0] * (dp[0]+1))/2;
  for(int i = 1 ; i < M; i++){
    ll n = dp[i] - 1;
    ans += (n * (n+1)) / 2;
  }
  cout << ans ;

  return 0;
}
