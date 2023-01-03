#include <iostream>
#include <vector>
#include <queue>
#include <cstring>

using namespace std;

int K, V, E;

vector<int> adj[20005];
int visited[20005];

void printG(){
  cout <<"pringG\n";
  for(int i = 1 ; i <= V; i++){
    cout << visited[i] << " ";
  }
  cout <<"\n";
}

bool check(){
  bool res = true;

  queue <int> q;
  
  for(int i = 1 ; i <= V ; i++){
    if(visited[i]) continue;

    q.push(i);
    visited[i] = 1;

    while(!q.empty()){
      int v = q.front();
      int color = visited[v];

      q.pop();

      for(int j = 0 ; j < adj[v].size(); j++){
        int u = adj[v][j];

        if(visited[u] == color) return false;

        if(visited[u] == (color % 2) + 1) continue;

        visited[u] = (color % 2) + 1;
        q.push(u);
      }
    }
  }

  return res;
}
// biparite graph
// bfs?
int main(){
  cin.tie(0);
  ios_base::sync_with_stdio(0);
  cin >> K;

  while(K--){
    cin >> V >> E;
    memset(visited, 0, sizeof(visited));

    for(int i = 1 ; i <= V ; i++){
      adj[i].clear();
    }

    for(int i = 0 ; i < E ; i++){
      int u, v;
      cin >> u >> v;

      adj[u].push_back(v);
      adj[v].push_back(u);
    }

    bool isBiparite = check();
    //printG();

    if(isBiparite){
      cout << "YES" << "\n";
    } else{
      cout << "NO" << "\n";
    }
  }


  return 0;
}
