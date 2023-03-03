#include <iostream>
#include <queue>
#include <algorithm>
#include <vector>

#define pii pair< int, int >

using namespace std;

int dy[4] = {-1, 0, 1, 0};
int dx[4] = {0, 1, 0, -1};

int N;
bool map[30][30];
int visited[30][30];


int bfs(int oy, int ox, int g){
  queue<pii> q;
  q.push(make_pair(oy, ox));
  visited[oy][ox] = g;

  int ans = 1 ;
  while(!q.empty()){
    int y = q.front().first;
    int x = q.front().second;
    q.pop();

    for(int i = 0; i < 4 ;i++){
      int ny = y + dy[i];
      int nx = x + dx[i];
      
      if(ny < 0 || nx < 0 || nx >= N || ny >= N)
        continue;

      if(visited[ny][nx])
        continue;
      
      if(!map[ny][nx])
        continue;

      ans++;
      visited[ny][nx] = g;
      q.push(make_pair(ny, nx));
    }
  }
  return ans;
}

int main(){
  
  cin >> N;
  for(int i = 0; i < N ; i++){
    string str;
    cin >> str;
    for(int j = 0 ; j < N ; j++){
      if(str[j] == '0')
        map[i][j] = false;
      else
        map[i][j] = true;
    }
  }

  vector<int> nums;
  int groupnum = 1;
  for(int i = 0; i < N ; i++){
    for(int j = 0 ; j < N ; j++){
      if(visited[i][j])
        continue;
      if(!map[i][j])
        continue;
      nums.push_back(bfs(i, j, groupnum++));
    }
  }

  sort(nums.begin(), nums.end());
  cout << nums.size() <<"\n";

  for(int i = 0 ; i < nums.size(); i++){
    cout << nums[i] << "\n";
  }
  

  return 0;
}
