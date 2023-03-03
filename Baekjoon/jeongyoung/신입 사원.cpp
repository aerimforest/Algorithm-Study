#include <iostream>
#include <vector>
#include <algorithm>

#define pii pair< int , int >
using namespace std;

int T;

int main(){
  cin.tie(0);
  ios_base::sync_with_stdio(0);

  cin >> T;
  while(T--){
    int N;
    vector<pii> arr;
    
    cin >> N;

    for(int i = 0 ; i < N ; i++){
      int a, b;
      cin >> a >> b ;
      arr.push_back(make_pair(a, b));
    }

    sort(arr.begin(), arr.end());


    int worst = 1e9;
    int ans = 0;
    for(int i = 0; i < N ; i++){
      int a = arr[i].first;
      int b = arr[i].second;

      if(b < worst){
        ans++;
        worst = b;
      }
    }
    cout << ans << "\n";
  }

  return 0;
  
}
