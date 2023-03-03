#include <iostream>
#include <queue>
using namespace std;

int N;
int arr[15];
int ans[15];
int main() {
  cin >> N;
  
  for(int i = 1; i <= N ; i++){
    cin >> arr[i];
  }

  queue<int> q;
  for(int i = 1; i <= N; i++){
    int space = 0;
    int j = 0;
    for(int j = 0; j < N ; j++){
      if(!ans[j])
        space++;
      if(space == arr[i]+1){
        ans[j] = i;
        break;
      }
    }
  }
  
  for(int i = 0 ; i < N; i++){
    cout << ans[i] << " ";
  }

  return 0;
}
