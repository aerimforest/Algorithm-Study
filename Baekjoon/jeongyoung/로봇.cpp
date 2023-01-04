#include <iostream>
#include <vector>
#include <cstring>

using namespace std;

int N;

int find(vector<int> &p, int a){
  if(p[a] < 0)
    return a;
  else return p[a] = find(p, p[a]);
}

void uni(vector<int> &p, int a, int b){
  int u = find(p, a);
  int v = find(p, b);

  if(u == v)
    return;

  if(u > v)
    swap(u, v);

  p[u] += p[v];
  p[v] = u;
}

void printP(vector <int> &p){
  cout << "P : \n";
  for(int i = 1 ; i <= N ; i++)
    cout << p[i] << " ";

}

int main(){
  cin.tie(0);
  ios_base::sync_with_stdio(0);

  vector<int> p(1000005, -1);
  
  cin >> N;

  //memset(p, -1, sizeof(p));
  //for(int i = 1; i <= 1e6 ; i++){
  //  p[i] = -1;
  //}

  for(int i = 0 ; i < N ; i++){
    char op ;
    int a, b, c;
    cin >> op;

    if(op == 'I'){
      cin >> a >> b;
      uni(p, a,b);

    } else {
      cin >> c;
      cout << - 1* p[find(p, c)] << "\n";
    }

    //printP();
  }

  return 0;
}
