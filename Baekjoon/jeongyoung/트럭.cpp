#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int N, W, L;
vector<int> arr;

int main(){

  cin >> N >> L >> W;

  for(int i = 0 ; i < N ; i++){
    int a;
    cin >> a;
    arr.push_back(a);
  }

  int curW = W;
  int t = 0;
  queue<int> q;
  int idx = 0;
  while(idx < arr.size() || curW != W){
    int num = 0;
    t++;

    if(q.size() == L){
      curW += q.front();
    }

    if(idx < arr.size() && arr[idx] <= curW ){
      num = arr[idx];
      idx++;
    }

    curW -= num;
    q.push(num);

    if(q.size() > L){
      q.pop();
    }

  }
  cout << t;

  return 0;
}
