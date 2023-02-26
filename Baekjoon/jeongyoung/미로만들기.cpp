#include <iostream>
#include <queue>
#include <cstring>

#define pii pair <int, int>
#define pipii pair <int, pii>
#define piipii pair <pii, pii>

using namespace std;

int dy[4] = {-1, 0, 1, 0};
int dx[4] = {0, 1, 0, -1};
int N;
int map[55][55];
int visited[55][55];

priority_queue<piipii> pq;
queue<pii> q2;

void printV(){
  
  for(int i = 0; i < N; i++){
    for(int j = 0 ; j < N; j++){
      cout << visited[i][j] << " ";
    }
    cout <<"\n";
  }
}
int main(){

  cin >> N;

  for(int i = 0; i < N; i++){
    string str;
    cin >> str;
    for(int j = 0 ; j < N; j++){
      map[i][j] = str[j] - '0';
      visited[i][j] = -1;
    }
  }

  pq.push(make_pair(make_pair(0, 1), make_pair(0, 0)));
  //q.push(make_pair(0, 0));
  visited[0][0] = 0;
  int stoneused = 0;
  while(!pq.empty()){
    int stones = -pq.top().first.first;
    int color = pq.top().first.second;
    int y = pq.top().second.first;
    int x = pq.top().second.second;
    pq.pop();
    
    for(int i = 0 ; i < 4 ; i++){
      int ny = y + dy[i];
      int nx = x + dx[i];

      if(ny < 0 || nx < 0 || ny >= N || nx >= N)
        continue;

      if(ny == N - 1 && nx == N -1){
        cout << stones;
        return 0;
      }

      if(visited[ny][nx] != -1)
        continue;

      int nstones = map[ny][nx] ? 0 : 1; 
      pq.push(make_pair(make_pair(-(stones + nstones), map[ny][nx]), make_pair(ny, nx)));

      visited[ny][nx] = (stones+nstones);
    }
  }
  return 0;
}
