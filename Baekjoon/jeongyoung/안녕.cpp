#include <iostream>
#include <vector>

using namespace std;

// knapsack problem
// health > 0, max joy

int N;
vector <int> cost;
vector <int> benefit;

// i, cost 
int dp[25][105]; 


void printDP(){
 for(int i = 1 ; i <= N; i++){
   for(int j = 1 ; j <= 100 ; j++){
      cout << dp[i][j] << " ";
   }
  cout << "\n";
 }
}

int main(){
  cin.tie(0);
  ios_base::sync_with_stdio(0);
  cin >> N;

  for(int i = 0 ; i < N ; i++){
    int c;
    cin >> c;
    cost.push_back(c);
  }
  
  for(int i = 0 ; i < N ; i++){
    int b;
    cin >> b;
    benefit.push_back(b);
  }

  for(int i = 1 ; i <= N; i++){
    for(int j = 1; j <= 101; j++){
      int idx = i-1;
      int w = j - 1;
      if(cost[idx] < w ){
        dp[i][j] = dp[i-1][j - cost[idx]] + benefit[idx];
      }
      dp[i][j] = max(dp[i][j], dp[i-1][j]);
    }
  }

  //printDP();

  cout << dp[N][101];



  return 0;
}
