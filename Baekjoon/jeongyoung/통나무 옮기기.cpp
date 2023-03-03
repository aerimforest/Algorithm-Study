#include <iostream>
#include <queue>

#define pii pair<int, int>
#define pbpii pair<bool, pii >
#define NONE make_pair(-1,-1)

using namespace std;

int N;
char map[55][55];


int dy[5] = {-1, 0, 1, 0, 0};
int dx[5] = {0, -1, 0, 1, 0};
int dh[5] = {0, 0, 0, 0, 1};

pii B_center = NONE;
pii E_center = NONE;
bool B_isHorizontal = false;
bool E_isHorizontal = false;

// works as visited
int dp[55][55][2];


void printDP(){
  cout << "print DP \n";
  for(int i = 0 ; i < N ; i++){
    for(int j = 0 ; j < N ; j++){
      cout << "[ " << dp[i][j][0]  << " , " << dp[i][j][1] <<  " ] ";
    }
    cout << "\n";
  }
}
bool checkPerimeter(int y, int x){
  for(int i = -1 ; i <= 1; i++){
    for(int j = -1 ; j <= 1; j++){
      int newy = y + i;
      int newx = x + j;

      if( newy < 0 || newy >= N || newx < 0 || newx >= N)
        return false;

      if(map[newy][newx] == '1')
        return false;
    }
  }
  return true;
}

int bfs(){

  queue< pbpii > q;
  q.push(make_pair(B_isHorizontal, B_center));
  while(!q.empty()){
    bool isHorizontal = q.front().first;
    int y = q.front().second.first;
    int x = q.front().second.second;
    
    if(q.front().second == E_center && isHorizontal == E_isHorizontal)
      return dp[y][x][isHorizontal];

    q.pop();

    for(int i = 0 ; i < 5 ; i++){
      int nexty = y + dy[i];
      int nextx = x + dx[i];
      int nexth = isHorizontal ^ dh[i];

      if(i == 4 && !checkPerimeter(y,x))
        continue;

      if(nexty < 0 || nextx < 0 || nextx >= N || nexty >= N)
        continue;

      if(isHorizontal){
        if(nextx <= 0 || nextx >= N - 1)
          continue;

        if(map[nexty][nextx-1] == '1' || map[nexty][nextx] == '1' || map[nexty][nextx+1] == '1')
          continue;
      }
      if(!isHorizontal){
        if(nexty <= 0 || nexty >= N - 1)
          continue;

        if(map[nexty-1][nextx] == '1' || map[nexty][nextx] == '1' || map[nexty+1][nextx] == '1')
          continue;
      }

      if(dp[nexty][nextx][nexth])
        continue;

      dp[nexty][nextx][nexth] = dp[y][x][isHorizontal] + 1;
      q.push(make_pair(nexth, make_pair(nexty, nextx)));
    }
  }
  return-0;
}

int main(){

  cin >> N;
  
  int B_count = 0;
  int E_count = 0;
  for(int i = 0 ; i < N ; i++){
    string str;
    cin >> str;
    for(int j = 0; j < N; j++){
      map[i][j] = str[j];

      if(map[i][j] == 'B') B_count++;
      if(map[i][j] == 'E') E_count++;

      if(B_count == 2 && B_center == NONE){
        B_center = make_pair(i, j);
        if(j > 0 && map[i][j-1] == 'B') B_isHorizontal = true; 
      }
      if(E_count == 2 && E_center == NONE){
        E_center = make_pair(i, j);
        if(j > 0 && map[i][j-1] == 'E') E_isHorizontal = true; 
      }
    }
  }


  //cout << B_center.first << " " << B_center.second << "\n";
  cout << bfs();

  //printDP();

  return 0;
}

