#include <iostream>
#include <vector>
#include <stack>

#define pii pair < int, int > 
using namespace std;
// find first element that is bigger than the element

int N;

vector<int> arr;

int main(){
  
  stack<pii> s;

  cin >> N ;

  arr.push_back(2e9);
  s.push(make_pair(2e9, 0 ));
  
  for(int i = 1 ; i <= N; i++){
    int a;
    cin >> a;
    arr.push_back(a);
  }

  for(int i = 1 ; i <= N; i++){
    while(s.top().first < arr[i])
      s.pop();
    cout << s.top().second << " "; 
    s.push(make_pair(arr[i], i));
  }

  return 0;
}
