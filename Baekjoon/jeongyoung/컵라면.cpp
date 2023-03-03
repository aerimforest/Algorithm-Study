#include <iostream>
#include <algorithm>
#include <queue>

#define pii pair<int, int>

using namespace std;

int N;

priority_queue<int> pq;
vector<pii> vec;
int maxTime = 0;

bool cmp(pii a, pii b){
  return a.first > b.first;
}

int main(){
  cin >> N;

  for(int i = 0 ; i < N; i++){
    int t, v;
    cin >> t >> v;
    vec.push_back(make_pair(t-1, v));
    maxTime = max(maxTime, t-1);
  }
  int ans = 0;

  sort(vec.begin(), vec.end(), cmp);

  int j = 0;
  for(int i = maxTime; i >=0 ; i--){ // i => time
    while( j < N && i == vec[j].first){
      pq.push(vec[j].second);
      j++;
    }

    if(!pq.empty()){ // most valuable one
      ans += pq.top();
      pq.pop();
    }
  }
  cout << ans;

  
  return 0;
}
