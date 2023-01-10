#include <iostream>
#include <vector>

#define pii pair < int, int >

using namespace std;

int dp[2][25];
int N;
int K;

vector<pii> costs;

int solve(int idx, int used){

  if(dp[used][idx])
    return dp[used][idx];

  int ans = 1e9 ;

  if(idx == N - 1)
    return 0;

  if(!used && idx + 3 <= N - 1)
    ans = min(ans, solve(idx+3, 1) + K);

  if(idx + 2 <= N - 1)
    ans = min(ans, solve(idx+2, used) + costs[idx].second);

  ans = min(ans, solve(idx+1, used) + costs[idx].first);
  
  dp[used][idx] = ans;
  //cout << idx  << " " << used << " " << ans <<  "\n";
  return ans;
}

int main(){
  cin >> N;
  for(int i = 0 ; i < N - 1 ; i++){
    int a, b;
    cin >> a >> b;

    costs.push_back(make_pair(a,b));
  }
  
  cin >> K;


  cout << solve(0, 0);

  return 0;
}
