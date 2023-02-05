#include <iostream>
#include <vector>

using namespace std;

int N;
vector<int> adj[10005];
int people[10005];
int dp[10005][3];
bool visited[10005];

void dfs(int cur){

  visited[cur] = true;
  dp[cur][0] = 0;
  dp[cur][1] = people[cur];

  for(int i = 0 ; i < adj[cur].size(); i++){
    int next = adj[cur][i];
    if(visited[next])
      continue;

    dfs(next);

    dp[cur][0] += max(dp[next][0], dp[next][1]);

    dp[cur][1] += dp[next][0];
  }
}

int main(){
  cin >> N;
  for(int i = 1 ; i <= N; i++){
    cin >> people[i];
  }

  for(int i = 0 ; i < N-1; i++){
    int a, b;
    cin >> a >>  b;
    adj[a].push_back(b);
    adj[b].push_back(a);
  }


  dfs(1);
  //memset(visited, 0, sizeof(visited));
  
  //cout << "---\n";
  cout << max(dp[1][0], dp[1][1]);

  return 0;
}
