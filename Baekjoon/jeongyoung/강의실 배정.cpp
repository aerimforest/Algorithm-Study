#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

#define pii pair <int , int >

using namespace std;

int N;
priority_queue<int, vector<int>, greater<int> > pq;

vector < pii > scheds;

// think pq as classroom available
int main(){
  cin >> N;

  for(int i = 0 ; i < N ; i++){
    int s, t;
    cin >> s >> t;
    scheds.push_back(make_pair(s,t));
  }

  sort(scheds.begin(), scheds.end());

  pq.push(scheds[0].second);

  for(int i = 1 ; i < N; i++){
    int s = scheds[i].first;
    int t = scheds[i].second;
    if(pq.top() <= s){
      pq.pop();
      pq.push(t);
    } else{
      pq.push(t);
    }
  }

  cout << pq.size() ;
  return 0;
}
