#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int N, L;
vector<int> loc;

// Greedy

int main(){
  
  cin >> N >> L;

  for(int i = 0 ; i < N ; i++){
    int tmp;
    cin >> tmp;
    loc.push_back(tmp);
  }
  sort(loc.begin(), loc.end());


  int ans = 0 ;
  int prevLen = -1005;
  for(int i = 0 ; i < N ; i++){
    if(prevLen + L - 1< loc[i]){
      ans++;
      prevLen = loc[i];
    }
  }

  cout << ans;
  return 0;
}
