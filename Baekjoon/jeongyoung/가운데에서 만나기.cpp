#include <iostream>
#include <vector>

using namespace std;

int N, M, K;

int dist[205][205];
int cities[205];

void printDist(){
  for(int i = 1 ; i <= N ; i++){
    for(int j = 1 ; j <= N; j++){
      cout << dist[i][j] << " ";
    }
    cout << "\n";
  }
}
int main(){
  cin >> N >> M;
  
  for(int i = 1 ; i <= N ; i++){
    for(int j = 1 ; j <= N; j++){
      if(i == j)
        continue;
      dist[i][j] = 1e9;
    }
  }

  for(int i = 0 ; i < M ; i++){
    int a, b, c;
    cin >> a >> b >> c;
    dist[a][b] = min(dist[a][b], c);
  }
  
  cin >> K;
  for(int i = 0 ; i < K; i++){
    cin >> cities[i];
  }

  for(int i = 1 ; i <= N ; i++){
    for(int j = 1; j <= N ; j++){
      for(int k = 1; k <= N; k++){
        dist[j][k] = min(dist[j][k], dist[j][i] + dist[i][k]);
      }
    }
  }

  //printDist();

  int mincost = 2e9;
  vector<int> mincity;
  for(int i = 1 ; i <= N ; i++){
    int maxcost = -1;
    int maxcity = -1;
    for(int j = 0 ; j < K ;j++){
      int n = cities[j];
      if(maxcost < dist[n][i] + dist[i][n]){
        maxcost = dist[n][i] + dist[i][n];
        maxcity = i;
      }
    }
    if(mincost > maxcost){
      mincost = maxcost;
      mincity.clear();
      mincity.push_back(maxcity);
    } else if(mincost == maxcost){
      mincity.push_back(maxcity);
    }
  }
  for(int i = 0 ; i < mincity.size(); i++){
    cout << mincity[i] << " ";
  }

  return 0;
}
