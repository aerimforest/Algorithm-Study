#include <iostream>
#include <vector>
#include <queue>
#include <stack>

#define pii pair < int, int >
using namespace std;

int N, M;
int A, B;
vector<pii> adj[1005];
priority_queue <pii> pq;

int dist[1005];
int way[1005];

void dijkstra(){

  dist[A] = 0;
  pq.push(make_pair(0, A));

  while(!pq.empty()){
    int v1 = pq.top().second;
    int xv1cost = -pq.top().first;

    //cout << v1 << " " << xv1cost << "\n";
    pq.pop();
    if(xv1cost > dist[v1]) continue;

    for(int i = 0 ; i < adj[v1].size(); i++){
      int v2 = adj[v1][i].second;
      int v1v2cost = adj[v1][i].first;

      if(dist[v2] > xv1cost + v1v2cost){
        dist[v2] = xv1cost + v1v2cost;
        way[v2] = v1;
        pq.push(make_pair(-dist[v2], v2));
      }
    }
  }
}

// MST -> bfs 
// or
// dijkstra
int main(){

  cin >> N >> M;

  for(int i= 0 ; i < M ; i++){
    int a, b, w;
    cin >> a >> b >> w;
    adj[a].push_back(make_pair(w, b));
  }
  cin >> A >> B;

  for(int i = 1 ; i <= N ; i++){
    dist[i] = 1e9;
  }

  dijkstra();
  cout << dist[B] << "\n";

  stack<int> s;
  s.push(B);
  int prev = way[B];

  while(prev != 0){
    s.push(prev);
    prev = way[prev];
  }

  cout << s.size()  << "\n";
  while(!s.empty()){
    cout << s.top() << " ";
    s.pop();
  }

  return 0;
}
