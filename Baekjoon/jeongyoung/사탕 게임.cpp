#include <iostream>


using namespace std;

int N;
char map[55][55];
int dy[4] = {1, 0, -1, 0};
int dx[4] = {0, 1, 0, -1};

int maxLen;
void getMax(int y, int x){

  int consec[4] = {0,};
  for(int i = 0 ; i < 4; i++){
    int ny = y + dy[i];
    int nx = x + dx[i];
    
    if(ny < 0 || nx < 0 || ny >= N || nx >= N)
      continue;

    int t = 0;
    while(map[ny][nx] == map[y][x]){
      ny = ny + dy[i];
      nx = nx + dx[i];
      t++;

      if(ny < 0 || nx < 0 || ny >= N || nx >= N)
        break;
    }
    consec[i] = t;
  }

  maxLen = max(maxLen, max(consec[0] + consec[2] + 1, consec[1] + consec[3] + 1));
}
//n is small
// 2500 * 2  * 4 * 50 
int main(){

  cin >> N ;

  for(int i = 0 ; i < N ; i++){
    string str;
    cin >> str;
    for(int j = 0 ; j < N; j++){
      map[i][j] = str[j];
    }
  }

  for(int i = 0 ; i < N; i++){
    for(int j = 0;  j < N; j++){

      getMax(i, j);

      for(int k = 0 ; k < 2; k++){
        int ny = i + dy[k];
        int nx = j + dx[k];

        if(ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
        if(map[ny][nx] == map[i][j]) continue; // smae color
        
        swap(map[ny][nx], map[i][j]);

        getMax(i, j);
        getMax(ny, nx);
        
        swap(map[ny][nx], map[i][j]);

      }
    }
  }
  cout << maxLen;
  return 0;
}
