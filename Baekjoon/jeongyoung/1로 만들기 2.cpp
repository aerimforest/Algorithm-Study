#include <iostream>
#include <stack>
#include <queue>
#define pii pair< int , int >

using namespace std;

int N;

int dp[1000005];
queue< pii > q;

int solve(int num){

  q.push(make_pair(0, num));

  while(!q.empty()){
    int num = q.front().second;
    int steps = q.front().first;
    q.pop();

    //cout << num << " " << steps << "\n";
    if(num == 1){
      return steps;
    }

    if(num % 3 == 0 && !dp[num/3]){
      dp[num/3] = num;
      q.push(make_pair(steps + 1, num/3));
    }
    if(num % 2 == 0 && !dp[num/2]){
      dp[num/2] = num;
      q.push(make_pair(steps + 1, num/2));
    }
    if(!dp[num-1]){
      dp[num - 1] = num;
      q.push(make_pair(steps + 1, num -1));
    }
  }

  return 0;
}

int main(){
  cin >> N;

  cout << solve(N) << "\n";

  stack<int> s;

  int num = 1;
  while(num != N){

    s.push(num);

    num = dp[num];
  }
  s.push(N);

  while(!s.empty()){
    cout << s.top() << " ";
    s.pop();
  }

  return 0;
}
