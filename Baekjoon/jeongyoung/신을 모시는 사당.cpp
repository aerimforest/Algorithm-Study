#include <iostream>

using namespace std;

int N;
int arr[100005];

// two pointer? greedy?
int main(){
  cin >> N;

  for(int i = 0 ; i < N ; i++){
    cin >> arr[i];
  }

  int ans = 0;
  int streak = 0;
  for(int i = 0 ; i < N ; i++){
    if(arr[i] == 1)
      streak++;
    else 
      streak--;

    if(streak < 0)
      streak = 0;
  
    ans = max(ans, streak);
  }
  
  streak = 0;
  for(int i = 0 ; i < N ; i++){
    if(arr[i] == 2)
      streak++;
    else 
      streak--;

    if(streak < 0)
      streak = 0;
  
    ans = max(ans, streak);
  }

  cout << ans ;
  
  return 0;
}
