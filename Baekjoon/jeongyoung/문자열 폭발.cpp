#include <iostream>
#include <vector>
#include <stack>
#define NONE "FRULA"
#define pic pair <char, int> 

using namespace std;

string str;
string bomb;
stack < pic > s;

int main(){

  cin.tie();
  ios_base::sync_with_stdio(0);
  cin >> str;
  cin >> bomb;

  // abcdaabbabe
  // ab
  
  int j = 0 ;
  for(int i = 0; i < str.size(); i++){

    if(str[i] == bomb[j]){
      j++;
    } else if(str[i] == bomb[0]){
      j = 1;
    } else {
      j = 0;
    }
    
    //cout << str[i] << " " << j << "\n";
    
    s.push(make_pair(str[i], j));
    
    if(j == bomb.size()){
      for(int k = 0 ; k < j ; k++)
        s.pop();
      if(!s.empty()){
        j = s.top().second;
        //cout << "> " << s.top().first << " " << j << "\n";
      } else {
        j = 0;
      }
    }
  }

  stack<char> ans;
  while(!s.empty()){
    ans.push(s.top().first);
    s.pop();
  }

  if(ans.size() == 0){
    cout << NONE << "\n";
  }

  while(!ans.empty()){
    cout << ans.top();
    ans.pop();
  }

  return 0;
}
