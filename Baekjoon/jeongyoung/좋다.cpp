#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int N;
vector<int> arr;
int main(){
  cin >> N;

  for(int i = 0; i < N ; i++){
    int a;
    cin >> a;

    arr.push_back(a);
  }

  sort(arr.begin(), arr.end());

  int ans = 0;
  // N^2 lg n
  for(int i = 0; i < N; i++){
    bool good = false;
    for(int j = 0; j < N; j++){
      if(j == i ) continue;

      int idx = lower_bound(arr.begin(), arr.end(), arr[i] - arr[j]) - arr.begin();
      
      if(idx == i || idx == j){

        if(idx + 1 < N && (idx+1 != i && idx+1 != j) && arr[idx+1] + arr[j] == arr[i]){
          good = true;
          break;
        }else if(idx + 2 < N && (idx+2 != i && idx+2 != j) && arr[idx+2] + arr[j] == arr[i]){
          good = true;
          break;
        }else{
          continue;
        }
      }

      if(arr[idx] + arr[j] == arr[i]){
        good = true;
        break;
      }
    }

    if(good)
      ans++;
  }
  cout << ans;

  return 0;
}
