#include <iostream>
#include <queue>
#define pii pair< int , int>

using namespace std;

int dy[4] = {-1, 0, 1, 0};
int dx[4] = {0, 1, 0, -1};
queue< pii > q;

int N, M;
int map[1005][1005];
int tomatoes = 0 ;
int maxtomatoes = 1;
int numtomatoes = 0;
void bfs(){

  while(!q.empty()){
    int y = q.front().first;
    int x = q.front().second;
    q.pop();

    for(int i = 0; i < 4; i++){
      int ny = y + dy[i];
      int nx = x + dx[i];

      if(nx < 0 || ny < 0 || nx >= M || ny >= N)
        continue;

      if(map[ny][nx] || map[ny][nx] == -1)
        continue;

      map[ny][nx] = map[y][x] + 1;
      maxtomatoes = max(maxtomatoes, map[ny][nx]);
      numtomatoes++;
      q.push(make_pair(ny, nx));
    }
  }
  
}

int main(){
  cin >> M >> N ;

  for(int i = 0 ; i < N ; i++){
    for(int j = 0 ; j < M ; j++){
      cin >> map[i][j];
      if(map[i][j] == 1)
        q.push(make_pair(i, j));
      if(map[i][j] == 0)
        tomatoes++;
    }
  }

  bfs();

  if(numtomatoes == tomatoes)
    cout << maxtomatoes - 1;
  else
    cout << -1;

  return 0;
}
