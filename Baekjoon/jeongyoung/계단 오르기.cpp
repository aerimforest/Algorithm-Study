#include <iostream>

using namespace std;

int N;
int dp[305][3];
int map[305];

int solve(int idx, int streak){
  if(idx == N){
    return map[N];
  }

  if(idx > N)
    return -5000000;

  if(dp[idx][streak])
    return dp[idx][streak];

  int ans = -5000000;
  if(streak < 2){
    ans = max(ans, solve(idx + 1, streak + 1));
  
  }
  if(idx + 2 <= N){
    ans = max(ans, solve(idx + 2, 1));
  }
  dp[idx][streak] = map[idx] + ans;
  return dp[idx][streak];
}

int main(){
  cin >> N;

  for(int i = 1 ; i <= N ; i++){
    cin >> map[i];
  }

  cout << solve(0, 0);

  return 0;
}
