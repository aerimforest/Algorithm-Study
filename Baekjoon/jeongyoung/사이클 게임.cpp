#include <iostream>

using namespace std;

int N, M;

int p[500005];

int find(int a){
  if(p[a] < 0)
    return a;
  else return p[a] = find(p[a]);
}

void uni(int a, int b){
  int u = find(a);
  int v = find(b);

  if( u == v)
    return;
  
  if(p[v] < p[u])
    swap(u, v);

  if(p[u] == p[v])
    p[u]--;

  p[v] = u;
}

int main(){

  cin.tie(0);
  ios_base::sync_with_stdio(0);


  cin >> N >> M;

  for(int i = 0 ; i <= N ; i++){
    p[i] = -1;
  }

  int ans = 0;
  for(int i = 0 ; i < M ; i++){
    int a, b;
    cin >> a >> b;
    ans++;

    if(find(a) == find(b)) {
      cout << ans;
      return 0;
    }
    uni(a,b);

  }
  cout << 0;

  return 0;
}
