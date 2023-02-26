#include <iostream>
#include <queue>
#include <vector>

#define pii pair<int, int>
using namespace std;

int N;
int ans;
vector<pii> arr;
priority_queue<pii> pq; // time , out == 1 || in == 0

int main(){
  cin >> N;

  for(int i = 0; i < N ; i++){
    int a , b , c;
    cin >> a >> b >> c;
    //arr.push_back(make_pair(b, c));
    pq.push(make_pair(-b, 0));
    pq.push(make_pair(-c, 1));
  }

  int classes = 0;

  while(!pq.empty()){
    int t = -pq.top().first;
    bool isout = pq.top().second;
    pq.pop();

    if(isout){
      classes--;
    }else{
      classes++;
      ans = max(ans, classes);
    }
  }

  cout << ans;
    
  return 0;
}
