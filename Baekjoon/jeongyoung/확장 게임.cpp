#include <iostream>
#include <queue>
#define pii pair < int , int >
#define pipii pair < int , pii > // moves, 
#define pipipii pair < int , pipii > // moves, 
#define ppppii pair < int , pipipii > // moves, 

using namespace std;

int dy[4] = {-1 ,0 , 1 ,0};
int dx[4] = {0 ,1 ,0, -1};
int s[10];
int ans[10];
int visited[1005][1005];
char map[1005][1005];
int N, M, P;
priority_queue<ppppii> pq;

void bfs(){

  while(!pq.empty()){
    int t = -pq.top().first ;
    int p = -pq.top().second.first ;
    int d = pq.top().second.second.first;
    int y = pq.top().second.second.second.first ;
    int x = pq.top().second.second.second.second ;
    
    //cout << t << " "<< p << " " << d << " " << y << " " << x << "\n";
    ans[p]++;
    
    pq.pop();
    
    for(int i = 0 ; i < 4; i++){
      int ny = y + dy[i];
      int nx = x + dx[i];
      
      if(ny < 0 || nx < 0 || ny >= N || nx >= M)
        continue;
      

      if(map[ny][nx] == '#' || visited[ny][nx])
        continue;


      visited[ny][nx] = p;
      if(d-1 == 0){
        pq.push(make_pair(-(t+1), make_pair(-p, make_pair(s[p], make_pair(ny, nx)))));
      } else {
        pq.push(make_pair(-t, make_pair(-p, make_pair(d-1, make_pair(ny, nx)))));
      }
    }
  }
}

void printMap(){
  for(int i = 0; i < N; i++){
    for(int j = 0 ; j < M ; j++){
      cout << visited[i][j] << " ";
    }
    cout << "\n";
  }
}
int main(){
  cin >> N >> M >> P;
  
  for(int i = 1 ; i <= P; i++){
    cin >> s[i];
  }

  for(int i = 0 ; i < N; i++){
    for(int j = 0; j < M; j++){
      cin >> map[i][j];
      if(map[i][j] >= '0' && map[i][j] <= '9') {
        int p = map[i][j] -'0';
        int d = s[p];
        pq.push(make_pair(-1, make_pair(-p, make_pair(d, make_pair(i, j)))));
        visited[i][j] = p;
      }
    }
  }

  bfs();
  //printMap();
  for(int i = 1 ;i <= P; i++){
    cout << ans[i] << " ";
  }

}
