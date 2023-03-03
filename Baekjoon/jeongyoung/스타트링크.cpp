#include <iostream>
#include <queue>

using namespace std;

int F, S, G, U, D;

int visited[1000005];
queue<int> q;
int main(){
  cin >> F >> S >> G >> U >> D;

  for(int i = 0 ; i <= F; i++){
    visited[i] = -1;
  }

  q.push(S);
  visited[S] = 0;
  
  int ans = -1;
  while(!q.empty()){
    int cur = q.front();
    q.pop();

    //cout << cur << " " << visited[cur] << "\n";

    if(cur == G){
      ans = visited[cur];
      break;
    }

    int up = cur + U;
    int down = cur - D;
    if( up <= F && visited[up] == -1){
      q.push(up);
      visited[up] = visited[cur] + 1;
    }

    if( down >= 1 && visited[down] == -1){
      q.push(down);
      visited[down] = visited[cur] + 1;
    }
  }

  if(ans == -1){
    cout << "use the stairs";
  }else{
    cout << ans;
  }


  return 0;
}
