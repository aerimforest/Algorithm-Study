#include <iostream>

using namespace std;

int N;
int map[3][1005];
int dp[3][1005];

int dfs(int color, int idx){
  if(idx == N)
    return 0;

  if(dp[color][idx])
    return dp[color][idx];

  int ans = 2e9;

  for(int i = 0 ; i < 3; i++){
    if(color == i)
      continue;
    ans = min(ans, dfs(i, idx+1));
  }

  dp[color][idx] = ans + map[color][idx];
  return dp[color][idx];
}

int main(){
  cin >> N;

  for(int i = 0 ; i < N; i++){
    for(int j = 0 ; j < 3 ; j++){
      cin >> map[j][i];
    }
  }

  cout << min(min(dfs(0, 0), dfs(1,0)), dfs(2,0));

  return 0;
}
