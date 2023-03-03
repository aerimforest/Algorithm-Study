#include <iostream>
#include <vector>
#include <cmath>

#define ll long long 

using namespace std;

// Two pointer

int main(){

  int G;
  cin >> G;

  int cur = ceil(pow(G, 1/2.));
  int prev = 1;
  vector<int> ans;

  while(1){
    long long cur_2 = pow(cur, 2);
    long long prev_2 = pow(prev, 2);

    long long diff = cur_2 - prev_2;
    
    if(diff == G){
      //cout << cur << " " << prev << "\n";
      ans.push_back(cur);
      cur++;
    } else if(diff > G) {
      if(cur - 1 == prev) break;
      prev++;
    } else { // difff < G
      cur++;
    }
  }


  for(int i = 0 ; i < ans.size(); i++){
    cout << ans[i] << "\n";
  }

  if(ans.size() == 0){
    cout << -1 ;
  }

  return 0;
}
