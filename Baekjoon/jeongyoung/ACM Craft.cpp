#include <iostream>
#include <cstring>
#include <queue>

using namespace std;
int T, N, K, W;
int main(){

  cin >> T;

  while(T--){
    cin.tie(0);
    ios_base::sync_with_stdio(0);
    
    int cost[1005];
    vector<int> adj[1005];
    int indegree[1005];
    int ans[1005];
    queue<int> q;

    memset(indegree, 0, sizeof(indegree));
    memset(ans, 0, sizeof(ans));

    cin >> N >> K;
    for(int i = 1 ; i <= N; i++){
      cin >> cost[i];
    }

    for(int i = 0; i < K ; i++){
      int a, b;
      cin >> a >> b;
      indegree[b]++;
      adj[a].push_back(b);
    }

    for(int i = 1; i <= N ; i++){
      if(indegree[i] == 0){
        q.push(i);
        ans[i] = 0;
      }
    }
    cin >> W;

    while(!q.empty()){
      int x = q.front();
      q.pop();

      
      if(x == W) {
        cout << ans[x] + cost[x] <<"\n";
        break;
      }
      
      //cout << x << " " << ans[x] + cost[x] <<  "\n";

      for(int i = 0 ; i < adj[x].size(); i++){
        int nx = adj[x][i];
        indegree[nx]--;
        
        ans[nx] = max(ans[nx], ans[x] + cost[x]);

        if(indegree[nx] == 0){
          q.push(nx);
        }
      }
    }


  }

  return 0;
}
