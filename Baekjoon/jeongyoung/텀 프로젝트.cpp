#include <iostream>
#include <cstring>

using namespace std;


int T;
int N;
int cnt;

int prefer[100005];
bool visited[100005];
bool checked[100005];

void dfs(int num){

  visited[num] = true;
  int next = prefer[num];
  if(!visited[next]){
    dfs(next);
  } else if(!checked[next]){ // cycle found because it was visited
    for(int i = next ; i != num ; i = prefer[i]){
      cnt++;
    }
    cnt++;
  }
  checked[num] = true;
}

int main(){
  cin.tie(0);
  ios_base::sync_with_stdio(0);

  cin >> T;
  while(T--){
    cin >> N;
    cnt = 0;
    memset(prefer, 0, sizeof(prefer));
    memset(visited, 0, sizeof(visited));
    memset(checked, 0, sizeof(checked));
    
    for(int i = 1 ; i <= N ; i++){
      cin >> prefer[i];
    }

    for(int i = 1 ; i <= N ; i++){
      if(visited[i])
        continue;

      dfs(i);
    }
    cout << N - cnt << "\n";
  }

  return 0;
}
