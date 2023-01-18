#include <iostream>
#include <queue>
#include <vector>

#define pii pair< int, int >
using namespace std;

int N, M, X;

vector<pii> adj[1005];
vector<pii> revadj[1005];
int goDist[1005];
int revDist[1005];

priority_queue<pii> pq;
void goDijkstra(){
  pq.push(make_pair(0, X));
  goDist[X] = 0;

  while(!pq.empty()){
    int xv1cost = -pq.top().first;
    int v1 = pq.top().second;
    pq.pop();
    
    for(int i = 0 ; i < adj[v1].size(); i++){
      int v2 = adj[v1][i].second;
      int v1v2cost = adj[v1][i].first;

      if(goDist[v2] > v1v2cost + xv1cost){
        goDist[v2] = v1v2cost + xv1cost;
        pq.push(make_pair(-goDist[v2], v2));
      }
    }
  }
}

void revDijkstra(){
  pq.push(make_pair(0, X));
  revDist[X] = 0;

  while(!pq.empty()){
    int xv1cost = -pq.top().first;
    int v1 = pq.top().second;
    pq.pop();
    
    for(int i = 0 ; i < revadj[v1].size(); i++){
      int v2 = revadj[v1][i].second;
      int v1v2cost = revadj[v1][i].first;

      if(revDist[v2] > v1v2cost + xv1cost){
        revDist[v2] = v1v2cost + xv1cost;
        pq.push(make_pair(-revDist[v2], v2));
      }
    }
  }
}
int main(){
  cin >> N >> M >> X;

  for(int i = 0 ; i < M ; i++){
    int a, b, c;
    cin >> a >> b >> c;
    adj[a].push_back(make_pair(c, b));
    revadj[b].push_back(make_pair(c, a));
  }

  for(int i = 0; i <= N; i++){
    goDist[i] = 2e9;
    revDist[i] = 2e9;
  }

  goDijkstra();
  revDijkstra();

  ///int maxDist = 1e9;
  int maxDist = 0;
  for(int i = 1; i <= N ; i++){
    if(maxDist < goDist[i] + revDist[i]){
      maxDist = goDist[i] + revDist[i];
    }
  }

  cout << maxDist;
  return 0;
}
