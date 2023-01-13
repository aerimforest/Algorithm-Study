#include <iostream>
#include <vector>
#include <queue>

#define ll long long 
#define ld long double
#define pii pair <int, int>
#define pldi pair <ld, int>

using namespace std;

int N, M;
vector<pii> adj[4005];
priority_queue<pii> pq1;
priority_queue<pldi> pq2[2]; // 0 : Halved 1 : doubled

long double dist1[4005];
long double dist2[4005][2];

void dijkstra1(int a){
  pq1.push(make_pair(0, a));
  dist1[a] = 0;

  while(!pq1.empty()){
    int v1 = pq1.top().second;
    ll xv1cost = -pq1.top().first;

    pq1.pop();
    if(xv1cost > dist1[v1]) 
      continue;

    for(int i = 0; i < adj[v1].size() ; i++){
      int v2 = adj[v1][i].second;
      ll v1v2cost = adj[v1][i].first;

      if(dist1[v2] > xv1cost + v1v2cost ){
        dist1[v2] = xv1cost + v1v2cost;
        pq1.push(make_pair(-dist1[v2], v2));
      }
    }
  }
}

void dijkstra2(int a){
  bool isDouble = false; // true when halves the distance
  pq2[isDouble].push(make_pair(0, a));
  dist2[a][isDouble] = 0;

  isDouble = !isDouble;

  //cout << "test : "<< !isDouble << "\n";

  while(!pq2[0].empty() || !pq2[1].empty()){
    while(!pq2[isDouble].empty()){
      int v1 = pq2[isDouble].top().second;
      ld xv1cost = -pq2[isDouble].top().first;

      pq2[isDouble].pop();
      if(xv1cost > dist2[v1][isDouble]) 
        continue;

      for(int i = 0; i < adj[v1].size() ; i++){
        int v2 = adj[v1][i].second;
        ld v1v2cost = adj[v1][i].first * (isDouble? 2 : 0.5) ;

        if(dist2[v2][!isDouble] > xv1cost + v1v2cost ){
          dist2[v2][!isDouble] = xv1cost + v1v2cost;
          pq2[!isDouble].push(make_pair(-dist2[v2][!isDouble], v2));
        }
      }
    }
    isDouble = !isDouble;
  }
}

void printDist1(){
  cout << "\nprint Dist1\n";
  for(int i = 1 ; i <= N ; i++){
    cout << dist1[i] << " ";
  }
}

void printDist2(){
  cout << "\nprint Dist2\n";
  for(int i = 1 ; i <= N ; i++){
    cout << " ("<< dist2[i][0] << ", " << dist2[i][1] <<") ";
  }
}
// solve with dijkstra
int main(){

  cin.tie(0);
  ios_base::sync_with_stdio(0);

  cin >> N >> M ;

  for(int i = 0 ; i < M ; i++){
    int a, b, d; 
    cin >> a >> b >> d;
    adj[a].push_back(make_pair(d,b));
    adj[b].push_back(make_pair(d,a));
  }

  for(int i = 1 ; i <= N; i++){
    dist1[i] = 1e18;
    dist2[i][0] = 1e18;
    dist2[i][1] = 1e18;
  }

  dijkstra1(1);
  dijkstra2(1);
  //printDist1();
  //printDist2();

  ll ans = 0;
  for(int i = 1; i <= N; i++){
    if(dist1[i] < min(dist2[i][0], dist2[i][1]))
      ans++;
  }
  cout << ans ;

  return 0;
}
