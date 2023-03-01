#include <iostream>
#include <math.h>
#define pii pair<int, int>
#define pipii pair<int, pii>
#define ll long long

using namespace std;

int N;
ll ha;
ll hhp;
ll maxhhp;
pipii room[123457];

int main(){
  cin >> N >> ha;

  for(int i = 0 ; i < N; i++){
    cin >> room[i].first >> room[i].second.first >> room[i].second.second;
  }

  for(int i = 0 ; i < N ; i++){
    ll type = room[i].first;
    ll a = room[i].second.first;
    ll h = room[i].second.second;

    if(type == 1){ // monster
      //hhp += (ceil(h / (double)ha )-1) * a; 
      if(h % ha == 0)
        hhp += ((h / ha)-1) * a ;
      else 
        hhp += (h / ha) * a;
      maxhhp = max(hhp, maxhhp);
    }else {
      ha += a;
      hhp -= h;
      if(hhp < 0 )
        hhp = 0;
    }
  }

  cout << maxhhp + 1;
  return 0;
}
