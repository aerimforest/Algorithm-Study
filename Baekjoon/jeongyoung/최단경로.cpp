#include <iostream>
#include <vector>
#include <queue>

#define pii pair < int , int >  
#define INF 1e9
using namespace std;

int V, E, K;
vector<pii> adj[20005];
priority_queue<pii> pq;
bool visited[20005];

int dist[20005];

void dijkstra(int x){

  dist[x] = 0;
  pq.push(make_pair(0, x));

  while(!pq.empty()){
    int v1 = pq.top().second;
    int xv1cost = -1 * pq.top().first;
    //cout << v1 << " " << xv1cost << "\n";
    
    pq.pop();

    for(int i = 0 ; i < adj[v1].size(); i++){
      int v2 = adj[v1][i].second;
      int v1v2cost = adj[v1][i].first;

      if(dist[v2] > xv1cost + v1v2cost){
        dist[v2] = xv1cost + v1v2cost;
        pq.push(make_pair( -1 * dist[v2], v2));
      }
    }
  }
}
// dijkstra
// O(VlgE)
int main(){

  cin >> V >> E >> K;

  for(int i = 0 ;i < E ; i++){
    int u, v, w;
    cin >> u >> v >> w;

    adj[u].push_back(make_pair(w, v));
  }

  for(int i = 1 ; i <= V; i++){
    dist[i] = INF;
  }

  dijkstra(K);
  for(int i = 1 ; i <= V; i++){
    if(dist[i] == INF) cout << "INF\n"; 
    else cout << dist[i] << "\n";
  }
  return 0;
}
