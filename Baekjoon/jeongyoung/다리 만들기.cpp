#include <iostream>
#include <queue>

#define pii pair < int, int >
#define pipii pair < int, pii >

using namespace std;

int dy[4] = {-1, 0, 1, 0};
int dx[4] = {0, 1, 0, -1};

int N;
int map[105][105];
int gmap[105][105];
int dist[105][105];
int group = 1;
int distFoundAt = 2e9 ;
int mindist = 2e9 ;

bool found = false;

queue< pii > q2;

void bfs(int y, int x){
  queue<pii> q;
  q.push(make_pair(y, x));
  gmap[y][x] = group;

  while(!q.empty()){
    int a = q.front().first;
    int b = q.front().second;

    //cout << "bfs !:  "<<  a << " " << b << "\n";
    q.pop();

    for(int i = 0 ; i < 4; i++){
      int ny = a + dy[i];
      int nx = b + dx[i];

      if(ny < 0 || nx < 0 || nx >= N || ny >= N)
        continue;

      if(gmap[ny][nx] == gmap[y][x])
        continue;

      if(!map[ny][nx]){
        if(dist[ny][nx] == 0){
          dist[ny][nx] = 1;
          gmap[ny][nx] = gmap[y][x];
          q2.push(make_pair(ny, nx));
        } else if (gmap[ny][nx] != 0 && gmap[ny][nx] != gmap[y][x]){
          return ;
        }
        continue;
      }
      gmap[ny][nx] = group;
      q.push(make_pair(ny, nx));
    }
  }
}

void printDist(){
  cout << "-----------\n";
  for(int i = 0 ; i < N ; i++){
    for(int j = 0; j < N ; j++){
      cout << dist[i][j] << " ";
    }
    cout << "\n";
  }
}
void printGroup(){
  cout << "-----------\n";
  for(int i = 0 ; i < N ; i++){
    for(int j = 0; j < N ; j++){
      cout << gmap[i][j] << " ";
    }
    cout << "\n";
  }

}

int main(){

  cin >> N;
  for(int i = 0 ; i < N ; i++){
    for(int j = 0; j < N ; j++){
      cin >> map[i][j];
    }
  }
  
  for(int i = 0 ; i < N ; i++){
    for(int j = 0; j < N ; j++){
      if(gmap[i][j] || !map[i][j])
        continue;
      bfs(i, j);
      group++;
    }
  }

  //printGroup();
  if(found){
    cout << 1 ;
    return 0;
  }
  while(!q2.empty()){
    int y = q2.front().first;
    int x = q2.front().second;
    q2.pop();

    if(dist[y][x] > distFoundAt){
      continue;
    }

    for(int i = 0 ; i < 4; i++){
      int ny = y + dy[i];
      int nx = x + dx[i];

      if(ny < 0 || nx < 0 || ny >= N || nx >= N)
        continue;

      if(gmap[ny][nx] == gmap[y][x])
        continue;

      if(gmap[ny][nx] != 0 && gmap[ny][nx] != gmap[y][x]){
        //cout << dist[ny][nx] + dist[y][x];
        mindist = min(mindist, dist[ny][nx] + dist[y][x]);
        distFoundAt = dist[y][x];
        continue;
      }

      dist[ny][nx] = dist[y][x] + 1;
      gmap[ny][nx] = gmap[y][x];
      q2.push(make_pair(ny, nx));
    }
  }
  //printGroup();
  //printDist();

  cout << mindist ;


  return 0 ;
}
