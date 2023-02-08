#include <iostream>
#define ll long long 
#define MX (ll) 1e9 + 5
using namespace std;

int N, M, K;
ll dp[105][105];
string ans = "";

ll count(int a, int b){

  if(a == 0 || b == 0){
    return 1;
  }

  if(dp[a][b])
    return dp[a][b];

  dp[a][b] = min(count(a-1, b) + count(a, b-1), MX);
  return dp[a][b];
}

void solve(int n, int m, int rem){
  if(n == 0){
    for(int i = 0 ; i < m ; i++){
      ans+= 'z';
    }
    return;
  }
  if(m == 0){
    for(int i = 0 ; i < n ; i++){
      ans += 'a';
    }
    return;
  }

  ll poss = count(n-1, m); // when a is on front.

  //cout << n << " " << m << " " << poss << "\n";
  if(poss > rem){ // if the possibility is included
    ans += 'a';
    solve(n-1, m, rem);
  }else{ // else contain z in front and subtract poss becuz all the poss for a-infront are included
    ans += 'z';
    solve(n, m-1 , rem - poss);
  }
}

int main(){

  cin >> N >> M >> K;

  if(count(N, M) < K){
    cout << -1 ;
    return 0;
  }

  solve(N, M, K-1);
  cout << ans ;
  return 0;
}
