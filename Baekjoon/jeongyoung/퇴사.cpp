// Knapsack problem => dp with cost and price.. but N is too small... maybe
// Bruteforce of some kind ?

#include <iostream>

using namespace std;

int N;
int t[20];
int p[20];
int dp[20];

int solve(int i){
  if(i >= N)
    return 0;

  if(dp[i])
    return dp[i];
  
  int val = 0;
  val = max(val, solve(i+1));
  if(t[i] + i <= N)
    val = max(val, solve(t[i] + i) + p[i]);

  dp[i] = val;
  return val;
}

int main(){
  
  cin >> N;

  for(int i = 0; i < N ; i++){
    cin >> t[i] >> p[i];
  }

  cout << solve(0);

  return 0;
}
