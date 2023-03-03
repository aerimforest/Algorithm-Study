#include <iostream>

#define MX 2e9

using namespace std;

int N;
int map[3][1005];
int dp[3][3][1005];

int solve(int color, int first_color, int idx){
  if(idx == N){
    return 0;
  }

  if(dp[first_color][color][idx])
    return dp[first_color][color][idx];
    
  int ans = MX;
  if(color != 0 && (idx+1 != N-1 || first_color != 0))
    ans = min(ans, solve(0, first_color, idx+1));

  if(color != 1 && (idx+1 != N-1 || first_color != 1))
    ans = min(ans, solve(1, first_color, idx+1));
  
  if(color != 2 && (idx+1 != N-1 || first_color != 2))
    ans = min(ans, solve(2, first_color, idx+1));
  
  dp[first_color][color][idx] = ans + map[color][idx];
  return dp[first_color][color][idx];
}

int main(){
  cin >> N;

  for(int i = 0 ; i < N ; i++){
    cin >> map[0][i];
    cin >> map[1][i];
    cin >> map[2][i];
  }


  int ans = MX;

  ans = min(ans, solve(0, 0, 0));
  ans = min(ans, solve(1, 1, 0));
  ans = min(ans, solve(2, 2, 0));
  cout << ans ;



  return 0;
}
