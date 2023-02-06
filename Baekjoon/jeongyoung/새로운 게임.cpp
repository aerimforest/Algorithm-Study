#include <iostream>
#include <vector>
#include <algorithm>

#define pii pair<int, int>

using namespace std;

int N, K;

// 0 -> 1 2->3 3 <-2
int dy[4] = {0, 0, -1, 1};
int dx[4] = {1, -1, 0, 0};

int map[15][15]; // numbering, direction

//void moveVector
struct piece {
  int idx;
  int y;
  int x;
  int d;
  int child;
};

vector<int> ps[15][15]; // numbering, direction
piece p[15];

void printMap(){
  cout <<"-----------------\n";
  for(int i = 0 ; i < N ; i++){
    for(int j = 0 ; j < N ; j++){
      cout << "[ ";
      for(int k = 0 ; k < ps[i][j].size(); k++){
        cout << ps[i][j][k] << " " << p[ps[i][j][k]].d + 1 << ", ";
      }
      cout << "] ";
    }
    cout << "\n";
  }
  cout <<"\n\n";
}

int main(){
  cin >> N >> K;
  for(int i = 0 ; i < N ; i++){
    for(int j = 0; j < N; j++){
      cin >> map[i][j];
    }
  }

  for(int i = 1 ; i <= K ; i++){
    int y, x, d;
    cin >> y >> x >> d;
    p[i].idx = i;
    p[i].y = y-1;
    p[i].x = x-1;
    p[i].d = d-1;
    ps[y-1][x-1].push_back(i);
    //peace[y-1][x-1].push_back(make_pair(i + 1, d));
  }

  int turn = 1;
  while(1){
    
    if(turn > 1000){
      cout << -1;
      break;
    }
    bool stack = false;

    for(int i = 1 ; i <= K; i++){
      //printMap();
      int y = p[i].y;
      int x = p[i].x;
      int d = p[i].d;

      int ny = y + dy[d];
      int nx = x + dx[d];


      // blue or wall
      if(nx < 0 || ny < 0 || nx >= N  || ny >= N || map[ny][nx] == 2){
        if(!stack){
          p[i].d = (d/2*2) + (d+1) % 2 ;
          stack = true;
          i--;
          continue;
        }
      } else if(map[ny][nx] == 0){ // white wall
        // move
        bool found = false;
        int idx = 0;
        for(int j = 0 ; j < ps[y][x].size(); j++){
          if(ps[y][x][j] == i || found){
            if(!found){
              idx = j;
              found = true;
            }
            
            ps[ny][nx].push_back(ps[y][x][j]);
            p[ps[y][x][j]].y = ny;
            p[ps[y][x][j]].x = nx;
          }
        }

        if(ps[ny][nx].size() >= 4){
          cout << turn;
          return 0;
        } 
        ps[y][x].erase(ps[y][x].begin() + idx, ps[y][x].end());


      } else if (map[ny][nx] == 1){ // Red tile

        bool found = false;
        int idx = 0;
        for(int j = 0 ; j < ps[y][x].size(); j++){
          if(ps[y][x][j] == i || found){
            if(!found){
              idx = j;
              found = true;
              reverse(ps[y][x].begin() + j, ps[y][x].end());
            }
            
            ps[ny][nx].push_back(ps[y][x][j]);

            p[ps[y][x][j]].y = ny;
            p[ps[y][x][j]].x = nx;
          }
        }
        ps[y][x].erase(ps[y][x].begin() + idx, ps[y][x].end());
        
        if(ps[ny][nx].size() >= 4){
          cout << turn;
          return 0 ;
        } 

      } else {
        cout << "somethings wrong... map can't be 2\n";
      }
      stack = false;
    }
    turn++;
  }


  return 0;
}
