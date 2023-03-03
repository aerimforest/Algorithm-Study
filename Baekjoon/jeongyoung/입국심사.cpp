#include <iostream>
#include <vector>

#define ll long long 

using namespace std;

int N, M;
vector<int> ts;

// O(Nlg(1e18))
int main(){

  cin >> N >> M;

  for(int i = 0 ; i < N; i++){
    int t;

    cin >> t;
    ts.push_back(t);
  }

  ll start = 0;
  ll end = 2e18;
  ll ans = end;
  while(start <= end) {
    ll mid = (start + end) / 2;

    ll sum = 0; 
    for(int i = 0 ; i < N && sum < M ; i++){
      sum += mid / ts[i];
    }
    
    //cout << start << " " << end << " " << sum << " " << ans << "\n";

    if(sum >= M){
      end = mid - 1;
      ans = mid;
    } else {
      start = mid + 1;
    }
  }

  cout << ans ;


  return 0;
}

