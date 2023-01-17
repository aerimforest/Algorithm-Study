#include <iostream>
#include <cstring>

int dy[4] =  {0 , -1, 0, 1};
int dx[4] =  {-1, 0, 1, 0};
using namespace std;

int R, C;

char map[25][25];
int dist[25][25];

int dfs(int y, int x, bool used[30]){
  used[map[y][x] - 'A'] = true;

  int ans = 0;
  for(int i = 0; i < 4; i++){
    int ny = y + dy[i];
    int nx = x + dx[i];
    
    if(nx < 0 || ny < 0 || nx >= C || ny >= R)
      continue;

    if(used[map[ny][nx] - 'A'])
      continue;

    ans = max(ans, dfs(ny, nx, used));
    
  }
  used[map[y][x] - 'A'] = false;
  return ans + 1;
}


int main(){
  cin >> R >> C;

  for(int i = 0 ; i < R ; i++){
    string str;
    cin >> str;
    for(int j = 0 ; j < C ; j++){
      map[i][j] = str[j];
    }
  }


  bool used[30]; // alphabet
  memset(used, 0, sizeof(used));
  cout << dfs(0, 0, used);


  return 0;
}
