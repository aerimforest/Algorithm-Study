#include <iostream>
#include <cstdlib>

using namespace std;

int T;



int main(){

  cin.tie(0);
  ios_base::sync_with_stdio(0);
  cin >> T;
  while(T--){
    int n ;

    cin >> n;

    int trial = 1000;
    bool zeroflag = false;
    
    int v1[20];
    int v2[20];

    for(int i = 0 ; i < n ; i++){
      int num;
      cin >> num;
      v1[i] = num;
      v2[i] = num;
    }
    v1[n] = v1[0];
    
    while(trial--){

      int sum = 0 ;
      for(int i = 0 ; i < n ; i++){
        if(trial%2==0){
          v2[i] = abs(v1[i] - v1[i+1]);
          sum += v2[i];
        } else {
          v1[i] = abs(v2[i] - v2[i+1]);
          sum += v1[i];
        }
      }
      v1[n] = v1[0];
      v2[n] = v2[0];


      if(sum == 0){
        zeroflag = true;
        break;
      }
    }

    if(zeroflag)
      cout << "ZERO" << "\n";
    else
      cout << "LOOP" << "\n";
  }

  return 0;
}
