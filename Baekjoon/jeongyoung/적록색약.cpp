#include <iostream>

using namespace std;

int dy[4] = {-1, 0, 1, 0};
int dx[4] = {0, 1, 0, -1};
int N;
char map[105][105];
bool visited[105][105];
bool visited2[105][105];

void dfs(int y, int x, char color){
  visited[y][x] = true;

  int ans = 0;
  for(int i = 0 ; i < 4; i++){
    int nexty = y + dy[i];
    int nextx = x + dx[i];

    if(nextx < 0 || nexty < 0 || nextx >= N || nexty >= N)
      continue;
  
    if(map[nexty][nextx] != color)
      continue;

    if(visited[nexty][nextx])
      continue;

    dfs(nexty, nextx, color);
  }
}

void dfs2(int y, int x, char color){
  visited2[y][x] = true;

  int ans = 0;
  for(int i = 0 ; i < 4; i++){
    int nexty = y + dy[i];
    int nextx = x + dx[i];

    if(nextx < 0 || nexty < 0 || nextx >= N || nexty >= N)
      continue;

    if((color == 'G' || color == 'R') && map[nexty][nextx] == 'B')
      continue;
    else if(color == 'B' && map[nexty][nextx] != color)
      continue;

    if(visited2[nexty][nextx])
      continue;

    dfs2(nexty, nextx, color);
  }
}

// dfs
int main(){

  cin >> N;

  for(int i = 0 ; i < N ; i++){
    for(int j = 0; j < N ; j++){
      cin >> map[i][j];
    }
  }

 
  int ans1 = 0;
  int ans2 = 0;
  for(int i = 0 ; i < N ; i++){
    for(int j = 0; j < N ; j++){
      if(visited[i][j]) continue;

      dfs(i, j, map[i][j]);
      ans1++;
    }
  }
  for(int i = 0 ; i < N ; i++){
    for(int j = 0; j < N ; j++){
      if(visited2[i][j]) continue;

      dfs2(i, j, map[i][j]);
      ans2++;
    }
  }
  cout << ans1 << " " << ans2;


  return 0;
}
