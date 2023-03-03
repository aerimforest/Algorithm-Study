#include <iostream>
#include <vector>
#include <cstring>

using namespace std;

int N;
int t;

int cul[50005];
vector <int > arr;

int dp[4][50005];


// O(3 * 50005)
int solve(int train, int idx){
  if(train == 3 || idx + t > N)
    return 0;
  
  if(dp[train][idx] != -1)
    return dp[train][idx];

  return dp[train][idx] = max(solve(train, idx+1), solve(train + 1, idx + t) + cul[idx+t] - cul[idx]);
}

void printDP(){
  cout << "\n";
  for(int i = 0 ; i < 3; i++){
    for(int j = 0; j < N ; j++){
      cout << dp[i][j] << " "; 
    }
    cout << "\n"; 
  }
}

int main(){
  cin >> N;
  for(int i = 0; i < N ; i++){
    int a;
    cin >> a;
    arr.push_back(a);
    cul[i+1] = a + cul[i]; 
  }
  
  cin >> t;

  memset(dp, -1, sizeof(dp));

  cout << solve(0, 0) << "\n";
  //printDP();

  return 0;
}
