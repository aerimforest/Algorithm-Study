#include <iostream>
#include <cstring>
#include <queue>

using namespace std;

int N, M; 

bool bridge[205][205];
bool visited[205];

int main(){

  cin >> N >> M;

  for(int i = 1 ; i <= N; i++){
    for(int j = 1 ; j <= N; j++){
      cin >> bridge[i][j];
      if(i == j)
        bridge[i][j] = 1;
    }
  }


  for(int i = 1; i <= N; i++){
    queue<int> q;

    memset(visited, false, sizeof(visited));
    visited[i] = true;
    q.push(i);
    while(!q.empty()){
      int k = q.front(); 
      q.pop();
      for(int j = 1; j <= N; j++){
        if(!bridge[k][j]) continue;

        if(visited[j]) continue;

        visited[j] = true;
        bridge[i][j] = true;
        q.push(j);
      }
    }
  }

  int prev = 0;
  int a;
  for(int i = 0 ; i < M ; i++){
    prev = a;
    cin >> a;
    
    if(i == 0) continue;

    if(!bridge[prev][a]) {
      cout << "NO";
      return 0;
    }
  }
  cout << "YES";


  return 0;
}
