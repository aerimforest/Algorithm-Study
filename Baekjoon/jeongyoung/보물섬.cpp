#include <iostream>
#include <queue>
#include <cstring>

#define pii pair < int , int >


using namespace std;

int dy[4] = {-1, 0, 1, 0};
int dx[4] = {0, 1, 0, -1};

int N, M;

bool map[55][55]; //true : lansi
int dist[55][55];
queue<pii> q;

int bfs(int i, int j){

  dist[i][j] = 1;
  q.push(make_pair(i, j));

  int biggest = 0;
  while(!q.empty()){
    int y = q.front().first;
    int x = q.front().second;

    q.pop();
    for(int i = 0 ; i < 4; i++){
      int ny = y + dy[i];
      int nx = x + dx[i];

      if(nx < 0 || ny < 0 || nx >= M || ny >= N)
        continue;

      if(dist[ny][nx])
        continue;

      if(!map[ny][nx])
        continue;

      dist[ny][nx] = dist[y][x] + 1;
      biggest = max(biggest, dist[ny][nx]);
      q.push(make_pair(ny, nx));
    }
  }
  return biggest;
}

void printdist(){
  cout << "-------------------------\n";
  for(int i = 0; i < N ; i++){
    for(int j = 0 ; j < M ; j++){
      cout << dist[i][j] << " ";
    }
    cout <<"\n";
  }
}

int main(){
  cin >> N >> M;

  for(int i= 0 ; i < N ; i++){
    string str;
    cin >> str;
    for(int j = 0 ; j < M ; j++){
      map[i][j] = str[j] == 'L' ? 1 : 0;
    }
  }

  int ans = 0;
  for(int i = 0 ; i < N ; i++){
    for(int j = 0 ; j < M ; j++){
      if(!map[i][j])
        continue;
      memset(dist, 0, sizeof(dist));
      ans = max(ans, bfs(i, j) - 1);
      //printdist();
    }
  }
  cout << ans;

  return 0;
}
