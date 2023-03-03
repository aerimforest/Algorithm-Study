#include <iostream>

using namespace std;

int N, M;
int map[105][105];


void printMap(){
  for(int i = 1 ; i <= N ; i++){
    for(int j = 1; j <= N ; j++){
      if(map[i][j] == 1e9)
        cout << 0 << " ";
      else 
        cout <<  map[i][j] << " ";
    }
    cout <<"\n";
  }
  
}
int main(){
  cin >> N >> M ;

  for(int i = 1 ; i <= N ; i++){
    for(int j = 1; j <= N ; j++){
      if(i == j)
        continue;
      map[i][j] = 1e9;
    }
  }
  for(int i = 0 ; i < M; i++){
    int a, b, c;
    cin >> a >> b >> c;
    map[a][b] = min(map[a][b], c);
  }
  //printMap();

  for(int i = 1 ; i <= N ; i++){
    for(int j = 1 ; j <= N ; j++){
      for(int k = 1 ; k <= N; k++){
        map[j][k] = min(map[j][k], map[j][i] + map[i][k]);
      }
    }
  }
  printMap();



  return 0;
}
