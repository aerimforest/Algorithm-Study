#include <iostream>
#include <vector>


using namespace std;

int N;
vector <int> ps;

int dp[1005];
// knapsack problem? solve with dp ?
// /O(N^2)
int main(){
  cin >> N;

  for(int i = 0 ; i < N; i++){
    int tmp;
    cin >> tmp;
    ps.push_back(tmp);
  }

  for(int i = 1; i <= N ; i++){
    dp[i] = ps[i-1];
    for(int j = 0 ; j <= i/2 ; j++){
      dp[i] = max(dp[i], dp[j] + dp[i-j]);
    }
  }
  
  cout << dp[N];
  

  return 0;
}
