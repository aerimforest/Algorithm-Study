#include <iostream>
#include <vector>
#include <set>

using namespace std;

int N, d, k, c;
int arr[30005];
set<int> s;
int chobabs[3005];
// bkkrute force
//
void printC(){

  cout << "--  " << s.size() << " ---------\n";
  for(int i = 1; i <= d; i++){
    cout << chobabs[i] << " ";
  }
  cout << "-----------\n";
}
int main() {

  cin >> N >> d >> k >> c;
  for(int i = 0; i < N; i++){
    cin >> arr[i];
  }
  s.insert(c);
  chobabs[c] = 1e9;

  for(int j = 0; j < k; j++){
    chobabs[arr[j]]++;
    s.insert(arr[j]);
  }

  int i = 0;
  int ans = 0;
  ans = s.size();

  //printC();

  while(1){
    int j = i + k ;
    if(i == N-1)
      break;

    int prev = arr[i];
    int next = arr[j % N];

    //cout << prev << " " << next << "\n"; 

    chobabs[prev]--;
    if(chobabs[prev] == 0){
      s.erase(prev);
    }

    chobabs[next]++;
    s.insert(next);

    ans = max(ans, (int)s.size());
    i++;
    
    //printC();
  }
  
  cout << ans;
  return 0;
}
