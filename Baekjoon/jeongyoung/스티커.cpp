#include <iostream>
#include <cstring>

using namespace std;


int T;
int N;
int dp[100005][2];
int map[100005][2];

int solve(int idx, bool top){

  if(idx >= N )
    return 0;

  if(dp[idx][top] != -1)
    return dp[idx][top];

  dp[idx][top] = max(solve(idx + 1, !top) , solve(idx+2, !top)) + map[idx][top];

  return dp[idx][top];
}

int main(){
  cin.tie(0);
  ios_base::sync_with_stdio(0);

  cin >> T;
  while(T--){
    cin >> N;

    for(int i = 0 ; i < 2; i++){
      
      for(int j = 0 ; j < N; j++){
        cin >> map[j][i];
        dp[j][i] = -1;
      }
    }

    cout << max(solve(0,0), solve(0,1)) << "\n";
  }
    
  return 0;
}
