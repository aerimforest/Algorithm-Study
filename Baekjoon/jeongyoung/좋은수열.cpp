#include <iostream>
#include <cmath>
#define ll long long

using namespace std;

int N;

//int ans = 0; 
bool solved = false;

void solve(string ans){
  if(solved)
    return;

  for(int i = 1; i <= ans.size()/2; i++){
    // cmp
    // a
    //cout << "checkb " << ans << " "  << ans.size() - i <<  "\n";
    string cmp1 = ans.substr(ans.size() - i);
    string cmp2 = ans.substr(ans.size() - 2*i, i);

    //cout << "check " << ans << " " << cmp1 << " " << cmp2 << "\n";
    if(cmp1 == cmp2)
      return;
  }

  if(ans.size() == N){
    cout << ans << "\n";
    solved = true;
    return;
  }

  solve(ans+"1");
  solve(ans+"2");
  solve(ans+"3");

}


/// brute force 
int main(){

  cin >> N;
  solve("");


  return 0;
}
