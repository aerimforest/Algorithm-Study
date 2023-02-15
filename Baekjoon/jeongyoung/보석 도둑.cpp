#include <iostream>
#include <queue>
#include <algorithm>

#define pii pair<int, int>

using namespace std;

int N, K, C;
priority_queue<pii> pq1;
vector<int> w;

//knapsack problem
int main(){

  cin >> N >> K;

  for(int i = 0;i < N ; i++){
    int m,v;
    cin >> m >> v;
    pq1.push(make_pair(-m, v));
  }

  for(int i = 0; i < K ; i++){
    int c;
    cin >> c;
    w.push_back(c);
  }

  sort(w.begin(), w.end());

  long long ans = 0;
  priority_queue<pii> pq2;

  for(int i = 0; i < K; i++){
    while(!pq1.empty() && -pq1.top().first <= w[i]){
      int m = -pq1.top().first;
      int v = pq1.top().second;
      //cout << m << " " <<  v <<"\n";
      pq1.pop();

      pq2.push(make_pair(v, m));
    }

    if(!pq2.empty()){
      ans += pq2.top().first;
      //cout << "> " <<  pq2.top().first <<"\n";
      pq2.pop();
    }
  }

  cout << ans;

  return 0;
}
