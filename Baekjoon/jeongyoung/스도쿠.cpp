#include <iostream>

using namespace std;


int map[9][9];

int ans[9][9];

// 9 + 9 + 9 7 3
bool checkPossible(int y, int x, int num){
  
  for(int i = 0 ; i < 9 ; i++){
    // hor
    if(ans[y][i] == num && i != x)
      return false;
    // ver
    if(ans[i][x] == num && i != y)
      return false;

    // box
    int bi = (y/3*3) + i/3;
    int bj = (x/3*3) + i%3;

    //cout << bi << " " << bj << " " << ans[bi][bj] << " < >  " << num << "\n";
    if(ans[bi][bj] == num && !(bi == y && bj == x))
      return false;
  }
  return true;
}

void printMap(){
  for(int i = 0 ; i < 9 ; i++){
    for(int j = 0 ; j < 9; j++){
      cout << ans[i][j];
    }
    cout << "\n";
  }
}

// 9 * 9 * 9
void solve(int i, int j){
  //cout << i << " " << j << "\n";
  //printMap();
  if(j == 9){
    if(i == 8){
      printMap();
      exit(0);
    } else{
      solve(i+1, 0);
    }
  }

  if(ans[i][j] != 0){
    if(checkPossible(i, j, map[i][j])){
      solve(i, j+1);
    }
    
  } else {
    for(int n = 1; n <= 9; n++){
      if(checkPossible(i, j, n)){
        ans[i][j] = n;
        solve(i, j+1);
        ans[i][j] = map[i][j];
      }
    }
  }
}

int main(){

  for(int i = 0 ; i < 9; i++){
    string str;
    cin >> str;
    for(int j = 0 ; j < 9 ; j++){
      map[i][j] = str[j] - '0';
      ans[i][j] = map[i][j];
    }
  }

  solve(0, 0);

  return 0;
}
