#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int N;
vector<int> v;

int my_abs(int a){
  if( a < 0)
    return -1 * a;
  return a;
}


int main() {
  cin >> N;

  for(int i = 0 ; i < N ; i++){
    int a;
    cin >> a;
    v.push_back(a);
  }

  int ans = 2e9;
  int a = v[0];
  int b = v[1];

  for(int i = 0 ; i < N ; i++){
    auto it = lower_bound(v.begin(), v.end(), -v[i]);
    int idx = it - v.begin();
    //cout << v[i] << " " <<  idx  <<  " " << v[idx] <<"\n";

    if(idx < N && idx > i){
      int diff = abs(v[i] + v[idx]);
      if(ans > diff){
        ans = diff;
        a = v[i];
        b = v[idx];
      }
    }
    if(idx > 0 && idx-1 > i){
      int diff = abs(v[i] + v[idx-1]);
      if(ans > diff){
        ans = diff;
        a = v[i];
        b = v[idx-1];
      }
    }
  }
  cout << a << " " << b;



  return 0;
}
