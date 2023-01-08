#include <iostream>

int dy[4] = {-1, 0 , 1, 0}; 
int dx[4] = {0, 1, 0, -1}; // up right down left


// 0 - > 3
// 1 - > 0
// 2 - > 1
// 3 - > 2
int N , M ;
int map[55][55];
int r, c, d;

using namespace std;


void printMap(){

  for(int i = 0; i < N; i++){
    for(int j = 0; j < M; j++){
      cout << map[i][j] << " ";
    }
    cout << "\n";
  }
}

int main(){

  cin >> N >> M;

  cin >> r >> c >> d;

  for(int i = 0 ; i < N ;  i++){
    for(int j = 0 ; j < M ; j++){
      cin >> map[i][j];
    }
  }

  int cleaned = 0 ;
  while(1){
    //printMap();

    bool moved = false;
    
    if(map[r][c] == 0){
      map[r][c] = 2;
      cleaned++;
    }

    int nexty;
    int nextx;
    for(int i = 0; i < 4 ; i++){

      
      d = (d + 3) % 4;
      nexty = r + dy[d];
      nextx = c + dx[d];
      //cout << nexty << " "<< nextx << " " << d << "\n";

      if(map[nexty][nextx] == 0){
        r = nexty;
        c = nextx;
        moved = true;
        break;
      }
    }

    if(moved)
      continue;

    nexty = r + dy[(d+2)%4];
    nextx = c + dx[(d+2)%4];
      
    r = nexty;
    c = nextx;
    if(map[nexty][nextx] == 1){
      cout << cleaned;
      return 0 ;
    }
  }
  

  return 0;
}
