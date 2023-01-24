#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

int N;
priority_queue<long long> pq;

int main(){
  cin >> N;

  for(int i = 0 ; i < N; i++){
    int a;
    cin >> a;
    pq.push(-a);
  }

  long long ans = 0;

  while(!pq.empty()){
    if(pq.size() == 1){
      pq.pop();
      break;
    }
    long long  n1 = -pq.top();
    pq.pop();
    long long n2 = -pq.top();
    pq.pop();

    pq.push(-(n1 + n2));
    ans+= n1+n2;
    //cout << n1 << " " << n2 << " " << ans << "\n";
  }

  cout << ans;
  return 0;
}
