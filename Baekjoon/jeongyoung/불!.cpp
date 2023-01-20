#include <iostream>
#include <queue>

#define INF -1
#define pii pair < int, int >
#define ppiipii pair < pii , pii > // 1 : player 0 : Fire

int dy[4] = {-1, 0, 1, 0};
int dx[4] = {0, 1, 0, -1};

using namespace std;

int R, C;
char map[1005][1005];
int dist[1005][1005];

int px, py;
int bx, by;

priority_queue<ppiipii> pq;

int bfs(){
  pq.push(make_pair(make_pair(0, -1), make_pair(py, px)));
  
  while(!pq.empty()){
    int d = -pq.top().first.first;
    int isPerson = -pq.top().first.second;
    int y = pq.top().second.first;
    int x = pq.top().second.second;

    pq.pop();
    //cout << d << " " << isPerson << " " << y << " " << x << "\n";

    if(isPerson && (y == 0 || x == 0 || y == R-1 || x == C-1))
      return dist[y][x];

    for(int i = 0; i < 4; i++){
      int ny = y + dy[i]; 
      int nx = x + dx[i];

      if(ny < 0 || nx < 0 || ny >= R || nx >= C)
        continue;

      if(map[ny][nx] == '#' || map[ny][nx] == 'F')
        continue;

      if(isPerson && dist[ny][nx])
        continue;

      if(isPerson)
        dist[ny][nx] = dist[y][x] + 1;
      else 
        map[ny][nx] = 'F';
      
      pq.push(make_pair(make_pair(-(d+1), -isPerson), make_pair(ny, nx)));
      //pq.push(make_pair(dist+1, isFire), make_pair(ny, nx));
    }
  }
  return INF;
}

int main(){
  
  cin >> R >> C;

  for(int i = 0; i < R ; i++){
    for(int j = 0; j < C; j++){

      cin >> map[i][j];

      if(map[i][j] == 'J'){
        py = i;
        px = j;
      }
      if(map[i][j] == 'F'){
        by = i;
        bx = j;
        pq.push(make_pair(make_pair(0, 0), make_pair(by, bx)));
      }
    }
  }

  dist[py][px] = 1;
  int ans = bfs();

  if(ans == -1){
    cout << "IMPOSSIBLE";
  } else{
    cout << ans ;
  }


  return 0;
}
