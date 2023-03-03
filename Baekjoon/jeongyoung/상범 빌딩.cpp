#include <iostream>
#include <queue>
#include <cstring>
#define pii pair < int , int>
#define pipii pair < int, pii>
#define pipipii pair < int, pipii>

int dy[6] = {-1, 0, 1, 0, 0 ,0}; 
int dx[6] = {0, 1, 0, -1, 0 ,0}; 
int dz[6] = {0, 0, 0, 0, 1, -1}; 

using namespace std;

int L , R, C;

char map[35][35][35];
bool visited[35][35][35];
pipii s;


int bfs(){

  queue <pipipii> q;
  q.push(make_pair(0,s));

  while(!q.empty()){
    int min = q.front().first;
    int z = q.front().second.first;
    int y = q.front().second.second.first;
    int x = q.front().second.second.second;
    q.pop();

    if(map[z][y][x] == 'E')
      return min;

    for(int i = 0 ; i < 6; i++){
      int nz = z + dz[i];
      int nx = x + dx[i];
      int ny = y + dy[i];

      if(nz < 0 || ny < 0 || nx < 0 || nz >= L || ny >= R || nx >= C)
        continue;

      if(map[nz][ny][nx] == '#')
        continue;
      if(visited[nz][ny][nx])
        continue;

      q.push(make_pair(min+1, make_pair(nz, make_pair(ny, nx))));
      visited[nz][ny][nx] = true;

    }
  }
  return -1;
}
int main(){
  cin.tie(0);
  ios_base::sync_with_stdio(0);

  while(1){
    cin >> L >> R >> C;

    if(L * R * C  == 0 )
      break;

    memset(visited, 0, sizeof(visited));

    for(int i = 0; i < L ; i++){
      for(int j = 0 ; j < R; j++){
        for(int k = 0 ; k < C; k++){
          cin >> map[i][j][k];
          if(map[i][j][k] == 'S')
            s = make_pair(i, make_pair(j, k));
        }
      }
    }

    int ans = bfs();
    if(ans == -1){
      cout << "Trapped!\n";
    } else {
      cout << "Escaped in " << ans << " minute(s).\n";
    }
  }
    
  return 0;
}
