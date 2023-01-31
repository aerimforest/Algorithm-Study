#include <iostream>
#include <map>
#define ll long long

using namespace std;

int N, K;
ll presum[200005];
map<ll, ll> m;

void printS(){
  for(int i= 1 ; i <=N ; i++){
    cout << presum[i] << " ";
  }
}
int main(){
  cin >> N >> K;

  for(int i = 1 ; i <= N ; i++){
    int a;
    cin >> a;
    presum[i] = presum[i-1] + a;
  }

  ll cnt = 0;
  for(int i = 1 ; i <= N ; i++){
    if(presum[i] == K) cnt++;

    cnt += m[presum[i] - K];
    m[presum[i]]++;
  }
  cout << cnt << "\n";


  return 0;
}
