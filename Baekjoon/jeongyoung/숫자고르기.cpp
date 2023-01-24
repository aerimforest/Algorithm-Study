#include <iostream>
#include <algorithm>
#include <vector>
#include <cstring>

using namespace std;

int N; 
int arr[105];
bool visited[105];

// graph problem, find nodes that starts and end
int main(){
  cin.tie(0);
  ios_base::sync_with_stdio(0);
  cin >> N;

  for(int i = 1; i <= N ; i++){
    cin >> arr[i];
  }

  vector<int> ans;
  for(int i = 1 ; i <= N ; i++){
    //cout << "> " << i << " ";
    int next = arr[i];

    memset(visited, 0, sizeof(visited));
     
    while(1){
      
      if(next == i){
        ans.push_back(i);
        break;
      }
      if(visited[next])
        break;
      visited[next] = true;

      next = arr[next];
    }
  }

  sort(ans.begin(), ans.end());

  cout << ans.size() << "\n";
  for(int i = 0 ; i < ans.size(); i++){
    cout << ans[i] << "\n";
  }


  return 0;
}
