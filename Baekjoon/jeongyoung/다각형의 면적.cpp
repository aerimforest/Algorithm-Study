#include <iostream>
#include <vector>

#define pdd pair <double, double>
using namespace std;

vector <pdd> ps;

double crossproduct(pdd a, pdd b, pdd c){

  double x1 = a.first;
  double x2 = b.first;
  double x3 = c.first;
  double y1 = a.second;
  double y2 = b.second;
  double y3 = c.second;

  return ((x1*y2 + x2*y3 + x3*y1) - (x2*y1 + x3*y2 + x1*y3)) / 2;
}
int N;
// divide it into triangles and calc
int main(){

  cin >> N ;

  for(int i = 0 ; i < N ; i++){
    double x, y;
    cin >> x >> y;

    ps.push_back(make_pair(x, y));
  }

  double ans = 0;
  for(int i = 1 ; i < N ; i++){
    ans += crossproduct(ps[0], ps[i-1], ps[i]);
  }

  if(ans < 0) ans *= -1;
   
  cout << fixed;
  cout.precision(1);
  cout << ans;
  return 0;
}
