#include <iostream>

using namespace std;

int N, K;

int main(){

  cin >> N >> K;
  int n = N;

  int c = 2e9;

  c =  __builtin_popcount(n);
  int a = 0;
  while(c > K){
    a++;
    c =  __builtin_popcount(n + a);
  }

  cout << a <<"\n";
  return 0;
}
