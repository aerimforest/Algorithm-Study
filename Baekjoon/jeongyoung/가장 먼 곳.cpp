#include <iostream>
#include <vector>
#include <queue>

#define pii pair < int , int >
using namespace std;


int N;
int A, B, C;
int M;
vector < pii > adj [100005];

int distA[100005];
int distB[100005];
int distC[100005];

void dijkstra(int x, int (&dist)[100005]){

  for(int i = 1 ; i <= N ; i++){
    dist[i] = 2e9;
  }

  priority_queue<pii> pq;
  pq.push(make_pair(0,x));
  dist[x] = 0;

  while(!pq.empty()){
    int xv1cost = -pq.top().first;
    int v1 = pq.top().second;
    pq.pop();

    for(int i = 0 ; i < adj[v1].size(); i++){
      int v2 = adj[v1][i].second;
      int v1v2cost = adj[v1][i].first;

      if(dist[v2] > xv1cost + v1v2cost){
        dist[v2] = xv1cost + v1v2cost;
        pq.push(make_pair(-dist[v2], v2));
      }
    }
  }
}

// dijkstra 3 times?
int main(){
  cin.tie(0);
  ios_base::sync_with_stdio(0);
  cin >> N;
  
  cin >>  A >> B >> C;

  cin >> M;

  for(int i = 0 ; i < M ; i++){
    int a, b, w;
    cin >> a >> b >> w;
    adj[a].push_back(make_pair(w, b));
    adj[b].push_back(make_pair(w, a));
  }
  // N + NlgE
  dijkstra(A, distA);
  dijkstra(B, distB);
  dijkstra(C, distC);

  int maxdist = -1;
  int ans = -1 ;

  for(int i = 1; i <= N; i++){
    //cout << i << " : "<< distA[i] << " " << distB[i] << " " << distC[i] << "\n";
    
    int d = min(distA[i], min(distB[i], distC[i]));
    if (maxdist < d){
      maxdist = d;
      ans = i;
    }
  }

  cout << ans ;
  return 0;
}
