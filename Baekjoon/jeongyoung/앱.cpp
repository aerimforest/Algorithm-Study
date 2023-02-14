#include <iostream>

using namespace std;

int N, M;

int dp[105][10005];

int mem[105];
int cost[105];
//knapsack problem, solve with dp
void printDP(int maxcost){
  
  for(int i = 0 ; i <= N; i++){
    for(int j = 0 ; j <= maxcost; j++){
      cout << dp[i][j] << " ";
    }
    cout << "\n";
  }
}
int main(){
  int maxcost =0 ;
  cin >> N >> M;

  for(int i = 0 ; i < N ; i++){
    cin >> mem[i];
  }
  for(int i = 0 ; i < N ; i++){
    cin >> cost[i];
    maxcost += cost[i];
    
  }

  for(int i = 1 ; i <= N; i++){
    for(int j = 0 ; j <= 10000; j++){
      if(j >= cost[i-1]){ // if u can include it, include it
        dp[i][j] = max(dp[i-1][j-cost[i-1]] + mem[i-1], dp[i-1][j]);
      }
      dp[i][j]  = max(dp[i][j], dp[i-1][j]);
    }
  }
  //printDP(maxcost);

  for(int i = 0 ; i <= 10000 ; i++){
    if(dp[N][i] >= M ){
      cout << i ;
      return 0;
    }
  }

  return 0;
}
