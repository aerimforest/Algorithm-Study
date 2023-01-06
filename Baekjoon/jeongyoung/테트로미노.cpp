#include <iostream>

int dy[4] = {0, 1, 0, -1}; // left down right [up]
int dx[4] = {-1, 0, 1, 0};

int map[505][505];
using namespace std;

int N, M; 

int dfs(int y, int x, int py, int px, int length)
{
  //cout << y << " " << x << " " << length << "\n";
  if(length == 3)
    return map[y][x];

  int val = 0;
  for(int i = 0 ; i < 3; i++){
    int nexty = y + dy[i];
    int nextx = x + dx[i];
    
    if(nextx < 0 || nexty < 0 || nextx >= M || nexty >= N)
      continue;

    // doesn't care about up repetition cause we don't have any
    if(nextx == px && nexty == py)
      continue;

    val = max(val, dfs(nexty, nextx, y, x, length + 1));

  }

  // For ㅗ ㅏ ㅜ ㅓ
  if(length == 1){
    for(int i = 0; i < 4; i++){
      for(int j = i + 1 ; j < 4 ; j++){
        int nexty1 = y + dy[i];
        int nexty2 = y + dy[j];

        int nextx1 = x + dx[i];
        int nextx2 = x + dx[j];

        if(nextx1 < 0 || nexty1 < 0 || nextx1 >= M || nexty1 >= N)
          continue;

        if(nextx2 < 0 || nexty2 < 0 || nextx2 >= M || nexty2 >= N)
          continue;

        if((nextx1 == px && nexty1 == py) || (nextx2 == px && nexty2 == py))
          continue;

        val = max(val, dfs(nexty1, nextx1, y, x, length +2) + dfs(nexty2, nextx2, y, x, length + 2));
      }
    }
  }
  //cout << y << " " << x << " " << length << " "<<  val + map[y][x]<< "\n";
  return val + map[y][x];
}

int main(){
  cin.tie(0);
  ios_base::sync_with_stdio(0);

  cin >> N >> M;

  for(int i = 0; i < N; i++){
    for(int j = 0; j < M ; j++){
      cin >> map[i][j];
    }
  }

  int val = 0;
  for(int i = 0; i < N; i++){
    for(int j = 0; j < M ; j++){
      val = max(val, dfs(i, j, -1, -1, 0));
    }
  }

  cout << val;
  return 0;
}
