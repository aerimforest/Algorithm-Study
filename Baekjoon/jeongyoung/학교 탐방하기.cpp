#include <iostream>
#include <cstring>
#include <queue>
#define ll long long 
#define pii pair < int, int >
#define pipii pair < int, pii >

using namespace std;
vector<pii> adj[1005];

priority_queue <pipii> pq1;
priority_queue <pipii> pq2;
// somehow use kruskal? mst!
int p[1005];
int sa, sb, sc;
int N, M;

int find(int a){
  if(p[a] < 0)
    return a;
  else 
    return p[a] = find(p[a]);
}
void uni(int a, int b){
  int u = find(a);
  int v = find(b);

  if(u == v)
    return;

  if(p[u] > p[v])
    swap(u, v);

  p[v] = u;

  if(p[u] == p[v])
    p[u]--;
}


int kruskal(priority_queue<pipii> pq){
  
  int ans = 0;
  while(!pq.empty()){
    int w = pq.top().first;
    int a = pq.top().second.first;
    int b = pq.top().second.second;
    pq.pop();
    
    if(find(a) == find(b))
      continue;
    

    uni(a,b);

    if(w == 0) ans++;
  }
  return ans;
}

int main(){
  cin >> N >> M;

  for(int i = 0 ; i <= N; i++){
    p[i] = -1;
  }
  for(int i = 0 ; i <= M ; i++){
    int a, b, c;
    cin >> a >> b >> c;
    pq1.push(make_pair(c, make_pair(a, b)));
    pq2.push(make_pair(-c, make_pair(a, b)));
  }

  ll a1 = kruskal(pq1);
  
  
  for(int i = 0 ; i <= N; i++){
    p[i] = -1;
  }

  ll a2 = kruskal(pq2);

  ll ans = a2 * a2 - a1 * a1;
  cout << ans;


  return 0;
}
