#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int N, K;
queue<int> q[25];

int main(){

  cin >> N >> K;
  long long ans = 0 ;

  for(int i = 0 ; i < N; i++){
    string str;
    cin >> str;

    int len = str.size();

    while(!q[len].empty()){
      int level = q[len].front();
      
      if(i - level <= K) break;

      q[len].pop();
    }

    ans += q[len].size(); // contains number of possible pairs 
                          // that could be made by combining with previous
                          // numbers

    q[len].push(i);
  }

  cout << ans;
  
  return 0;
}
