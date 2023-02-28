#include <iostream>

using namespace std;

int N, M;
int map[1006][1006];
int dp[1006][1006];
void printDP(){
  for(int i = 0 ; i < N ; i++){
    for(int j = 0 ; j < M; j++){
      cout <<  dp[i][j] << " "; 
    }
    cout << "\n";
  }
}
int main(){

  cin >> N >> M ; 
  for(int i = 0 ; i < N ; i++){
    for(int j = 0 ; j < M; j++){
      cin >> map[i][j];
    }
  }

  for(int i = 0 ; i < N; i++){
    for(int j = 0; j < M ; j++){

      dp[i][j] = map[i][j];
      if(i - 1 >= 0 && j - 1 >= 0 ){
        dp[i][j] = max(dp[i][j], dp[i-1][j-1] + map[i][j]);
      }
      if( i - 1 >= 0){
        dp[i][j] = max(dp[i][j], dp[i-1][j] + map[i][j]);
      }
      if ( j - 1 >= 0){
        dp[i][j] = max(dp[i][j], dp[i][j-1] + map[i][j]);
      }
    }
  }
  //printDP();

  cout << dp[N-1][M-1];
  return 0;
}
