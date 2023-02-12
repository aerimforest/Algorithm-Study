#include <iostream>
#include <vector>
#define pii pair <int, int >

using namespace std;

int N, M, L, K;
vector<pii> p;

int ans = 0;
int main(){
  cin >> N >> M >> L >> K;

  for(int i = 0 ; i < K; i++){
    int a, b;
    cin >> a >> b;
    p.push_back(make_pair(a, b));
  }

  for(int i = 0; i < K ; i++){
    for(int j = 0 ; j < K ; j++){
      int cnt = 0;
      int x1 = p[i].first;
      int y1 = p[j].second;
      for(int k = 0 ; k < K ; k++){
        int x2 = p[k].first; 
        int y2 = p[k].second; 

        if(x1 <= x2 && x1 + L >= x2 && y1 <= y2 && y1 + L >= y2)
          cnt++;
      }

      ans = max(ans, cnt);
    }
  }
  cout <<  K - ans;


  return 0;
}

