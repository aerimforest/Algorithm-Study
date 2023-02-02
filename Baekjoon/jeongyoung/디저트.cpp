#include <iostream>

using namespace std;

int N, M;
int map[15][100005];
int dp[15][100005];

int solve(int d, int idx){
  if(idx == N)
    return 0;

  if(dp[d][idx] != -1)
    return dp[d][idx];

  int ans = 0; 
  for(int i = 0 ; i < M; i++){
    int cmp = solve(i, idx+1);

    if(i == d)
      cmp += map[i][idx + 1] / 2;
    else 
      cmp += map[i][idx + 1] ; 

    ans = max(ans, cmp);
  }

  dp[d][idx] = ans;
  return dp[d][idx];
}

// dfs + dp 
int main(){
  cin.tie(0);
  ios_base::sync_with_stdio(0);

  cin >> N >> M;

  for(int i = 0 ; i < M ; i++){
    for(int j = 0; j < N ; j++){
      cin >> map[i][j];
      dp[i][j] = -1;
    }
  }

  int ans = 0;
  for(int i = 0 ; i < M ; i++){
    ans = max(ans, solve(i, 0) + map[i][0]);
  }
  cout << ans; 

  return 0;
}
