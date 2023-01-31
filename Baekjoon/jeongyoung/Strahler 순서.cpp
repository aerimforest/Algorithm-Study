#include <iostream>
#include <cstring>
#include <vector>
#include <queue>

using namespace std;

// put indegree 0 nodes in queue with greedy method?

int T;
int K, M, P;

int indegree[1005];
int level[1005];
int maxlevelcount[1005];

int main() {
  cin.tie(0);
  ios_base::sync_with_stdio(0);

  cin >> T;

  while(T--){
    cin >> K >> M >> P;

    vector<int> adj[1005];
    queue<int> q;

    memset(level, 0, sizeof(level));
    memset(indegree, 0, sizeof(indegree));
    memset(maxlevelcount, 0, sizeof(maxlevelcount));

    for(int i = 0; i < P; i++){
      int A, B;
      cin >> A >> B;
      indegree[B]++;
      adj[A].push_back(B);
    }

    for(int i = 1 ; i <= M; i++){
      if(indegree[i] == 0){
        q.push(i);
        level[i] = 1;
      }
    }

    while(!q.empty()){
      int num = q.front();
      q.pop();

      for(int i = 0 ; i < adj[num].size(); i++){
        int nextnum = adj[num][i];
        indegree[nextnum]--;

        if(level[nextnum] < level[num]){
          level[nextnum] = level[num];
          maxlevelcount[nextnum] = 1;
        } else if(level[nextnum] == level[num]){
          maxlevelcount[nextnum]++;
        }

        if(indegree[nextnum] == 0){
          q.push(nextnum);
          if(maxlevelcount[nextnum] >= 2){
            level[nextnum]++;
          }
        }
      }
    }

    //for(int i = 1; i <=M ;i++){
    //  cout << level[i] << " ";
    //}
    cout << K << " " << level[M] << "\n";
  }
  return 0;
}
