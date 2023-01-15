#include <iostream>
#include <vector>

#define MX 2e9

using namespace std;

int N, S;
int arr[100005];
int sarr[100005];

// two pointer?
int main(){
  cin >> N >> S;

  int a;
  for(int i = 1; i <= N ; i++){
    cin >> a;
    arr[i] = a;
    sarr[i] = sarr[i-1] + a;
  }

  int sum = 0;
  int ans = MX;
  int j = 0 ;
  for(int i = 1 ; i <= N ;){
    sum = sarr[i] - sarr[j];
    //cout << sum << " " <<  ans <<  " " << i << " " << j << "\n";
    if(sum >= S){
      ans = min(ans, i-j);
      j++;
    } else{
      i++;
    }
  }

  if(ans == MX)
    cout << 0;
  else 
    cout << ans;


  return 0;
}
