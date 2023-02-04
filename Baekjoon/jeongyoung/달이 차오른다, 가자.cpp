#include <iostream>
#include <queue>
#define pii pair <int, int>
#define pipii pair <int, pii>

using namespace std;

int dy[4] = {-1, 0, 1, 0};
int dx[4] = {0, 1, 0, -1};
int N, M;
char map[55][55];
int visited[1<<6][55][55]; // if key exist => 1 else 0 index starts with 'a'
pii s;

int bfs(){
  queue < pipii > q;

  q.push(make_pair(0, s));

  while(!q.empty()){
    int keys = q.front().first;
    int y = q.front().second.first;
    int x = q.front().second.second;

    //cout << keys << " " << y << " " << x << "\n";
    q.pop();

    if(map[y][x] == '1')
      return visited[keys][y][x];

    for(int i = 0 ; i < 4 ; i++){
      int ny = y + dy[i];
      int nx = x + dx[i];

      if(ny < 0 || nx < 0 || ny >= N || nx >= M)
        continue;

      if(map[ny][nx] == '#')
        continue;

      if(map[ny][nx] >= 'A' && map[ny][nx] <= 'F'){
        if(!((keys >> (map[ny][nx] - 'A')) & 1)) //if key doesn't exist
          continue;
      }

      if(visited[keys][ny][nx])
        continue;
      
      int nextk = keys;
      if(map[ny][nx] >= 'a' && map[ny][nx] <= 'f'){
        nextk = keys | (1 << (map[ny][nx] - 'a'));
      }
      visited[nextk][ny][nx] = visited[keys][y][x] + 1;
      q.push(make_pair(nextk, make_pair(ny, nx)));
    }
  }
  return -1;
}
int main(){
  cin >> N >> M;
  for(int i = 0; i < N; i++){
    string str;
    cin >> str;
    for(int j = 0 ; j < M ; j++){
      map[i][j] = str[j];
      if(map[i][j] == '0'){
        s.first = i;
        s.second = j;
      }
    }
  }

  cout << bfs();
  return 0;
}
