#include <iostream>
#include <cstring>

using namespace std;

int N;
char stars[7000][7000];

void colorBlank(int y, int x, int n){
  for(int i = 0 ; i < n; i++){
    for(int j = 0 ; j < n ; j++){
      stars[y+i][x+j] = ' ';
    }
  }
}

void solve(int y, int x, int n){

  if(n == 3){
    stars[y+1][x+1] = ' ';
    return;
  }

  for(int i = 0 ; i < 3; i++){
    for(int j = 0 ; j < 3 ;j++){
      int newy = y + i * n/3;
      int newx = x + j * n/3;
      if( i == 1 && j == 1){
        colorBlank(newy, newx, n/3);
      }
      solve(newy, newx, n / 3);
    }
  }
}


void printStars(){

  for(int i = 0; i < N; i++){
    for(int j = 0 ;j < N; j++){
      cout << stars[i][j];
    }
    cout << "\n";
  }
}
int main(){
  
  cin >> N;

  for(int i = 0 ; i < N; i++){
    for(int j = 0 ; j < N ; j++){
      stars[i][j] = '*';
    }
  }
  
  solve(0, 0, N);
  printStars();

  
  return 0; 
}
