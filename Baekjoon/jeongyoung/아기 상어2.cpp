#include <iostream>
#include <queue>

#define pii pair < int, int >
#define pipii pair < int, pii >

using namespace std;


int dy[8] = {-1, -1, -1, 0, 0, 1, 1, 1};
int dx[8] = {-1, 0, 1, -1, 1, -1, 0, 1};
int N, M;
int map[55][55];
int visited[55][55];

// pq is not needeed..
priority_queue<pipii> pq;

int bfs(){

  while(!pq.empty()){
    int d = -pq.top().first;
    int y = pq.top().second.first;
    int x = pq.top().second.second;
    pq.pop();


    for(int i = 0 ; i < 8 ; i++){
      int ny = y + dy[i];
      int nx = x + dx[i];
      int nd = d + 1;

      if(ny < 0 || nx < 0 || nx >= M || ny > N)
        continue;

      if(visited[ny][nx] != -1)
        continue;

      if(map[ny][nx])
        return visited[y][x] ;

      visited[ny][nx] = visited[y][x] + 1;
      pq.push(make_pair(-nd, make_pair(ny, nx)));
    }
  }
  return 0;
}
// BFS TO ALL THE SHARKS
// There must be a better solution but it's time limiit accepts N*M*N*M
int main(){
  cin >> N >> M;

  for(int i = 0 ; i < N; i++){
    for(int j = 0 ; j < M ; j++){
      cin >> map[i][j];
      visited[i][j] = -1;

      if(map[i][j]){
        pq.push(make_pair(0, make_pair(i, j)));
        visited[i][j] = 0;
      }
    }
  }

  int ans = 0;
  bfs();

  for(int i = 0 ; i < N; i++){
    for(int j = 0 ; j < M ; j++){
      //cout << visited[i][j] << " ";
      ans = max(ans, visited[i][j]);
    }
    //cout << "\n";
  }

  cout << ans ;

  return 0;
}
